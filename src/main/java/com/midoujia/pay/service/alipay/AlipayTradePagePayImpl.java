package com.midoujia.pay.service.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.midoujia.pay.constants.AliPayConstants;
import com.midoujia.pay.exception.BusinessMsg;
import com.midoujia.pay.exception.PayException;
import com.midoujia.pay.model.PayRequest;
import com.midoujia.pay.model.PayResponse;
import com.midoujia.pay.model.alipay.AlipayTradePagePayCusRequest;
import com.midoujia.pay.model.alipay.AlipayTradePagePayCusResponse;
import com.midoujia.pay.service.AlipayServiceClient;

/**
 * alipay.trade.page.pay(统一收单下单并支付页面接口)
 * 文档：https://opendocs.alipay.com/open/028r8t?scene=22
 *
 * @author zfldiv@163.com
 */
public class AlipayTradePagePayImpl extends AlipayServiceClient {

    @Override
    public <T extends PayResponse> T pay(PayRequest<T> req) {
        AlipayTradePagePayCusRequest alipayTradePagePayCusRequest = (AlipayTradePagePayCusRequest) req;

        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl("");
        request.setReturnUrl("");
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", alipayTradePagePayCusRequest.getOrderNo());
        bizContent.put("total_amount", alipayTradePagePayCusRequest.getOrderAmount());
        bizContent.put("subject", alipayTradePagePayCusRequest.getOrderName());
        bizContent.put("product_code", AliPayConstants.FAST_INSTANT_TRADE_PAY);

        request.setBizContent(bizContent.toString());
        try {
            AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
            if(response.isSuccess()){
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
            final AlipayTradePagePayCusResponse alipayTradePagePayCusResponse = new AlipayTradePagePayCusResponse();
            alipayTradePagePayCusResponse.setBody(response.getBody());
            alipayTradePagePayCusResponse.setOrderId(req.getOrderNo());
            alipayTradePagePayCusResponse.setPayTypeEnum(alipayTradePagePayCusRequest.getPayTypeEnum());
            return (T) alipayTradePagePayCusResponse;
        } catch (AlipayApiException alipayApiException) {
            throw new PayException(BusinessMsg.Fail);
        }
    }
}
