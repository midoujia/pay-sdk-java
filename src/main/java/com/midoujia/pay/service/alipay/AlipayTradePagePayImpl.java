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
import com.midoujia.pay.model.alipay.MiDouAlipayTradePagePayRequest;
import com.midoujia.pay.model.alipay.MiDouAlipayTradePagePayResponse;
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
        MiDouAlipayTradePagePayRequest miDouAlipayTradePagePayRequest = (MiDouAlipayTradePagePayRequest) req;

        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl("");
        request.setReturnUrl("");
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", miDouAlipayTradePagePayRequest.getOrderNo());
        bizContent.put("total_amount", miDouAlipayTradePagePayRequest.getOrderAmount());
        bizContent.put("subject", miDouAlipayTradePagePayRequest.getOrderName());
        bizContent.put("product_code", AliPayConstants.FAST_INSTANT_TRADE_PAY);

        request.setBizContent(bizContent.toString());
        try {
            AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
            if(response.isSuccess()){
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
            MiDouAlipayTradePagePayResponse miDouAlipayTradePagePayResponse = new MiDouAlipayTradePagePayResponse();
            miDouAlipayTradePagePayResponse.setBody(response.getBody());
            miDouAlipayTradePagePayResponse.setPayTypeEnum(miDouAlipayTradePagePayRequest.getPayTypeEnum());
            miDouAlipayTradePagePayResponse.setPayTypeEnum(req.getPayTypeEnum());
            miDouAlipayTradePagePayResponse.setReqParam(bizContent.toString());
            miDouAlipayTradePagePayResponse.setOrderAmount(miDouAlipayTradePagePayRequest.getOrderAmount());
            miDouAlipayTradePagePayResponse.setOrderNo(miDouAlipayTradePagePayRequest.getOrderNo());
            return (T) miDouAlipayTradePagePayResponse;
        } catch (AlipayApiException alipayApiException) {
            throw new PayException(BusinessMsg.Fail);
        }
    }
}
