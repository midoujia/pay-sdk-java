package com.midoujia.pay.service.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.midoujia.pay.constants.AliPayConstants;
import com.midoujia.pay.enums.PayTypeEnum;
import com.midoujia.pay.exception.BusinessMsg;
import com.midoujia.pay.exception.PayException;
import com.midoujia.pay.model.PayRequest;
import com.midoujia.pay.model.PayResponse;
import com.midoujia.pay.model.alipay.AlipayTradePagePayCusRequest;
import com.midoujia.pay.model.alipay.AlipayTradePagePayCusResponse;
import com.midoujia.pay.model.alipay.AlipayTradePrecreateCusRequest;
import com.midoujia.pay.model.alipay.AlipayTradePrecreateCusResponse;
import com.midoujia.pay.service.AlipayServiceClient;

import java.math.BigDecimal;

/**
 * alipay.trade.precreate(统一收单线下交易预创建)
 * 文档：https://opendocs.alipay.com/open/02ekfg?scene=19
 *
 * @author zfldiv@163.com
 */
public class AlipayTradePrecreateImpl extends AlipayServiceClient {

    @Override
    public <T extends PayResponse> T pay(PayRequest<T> req) {
        AlipayTradePrecreateCusRequest alipayTradePrecreateCusRequest = (AlipayTradePrecreateCusRequest) req;


        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setNotifyUrl("");
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", alipayTradePrecreateCusRequest.getOrderId());
        bizContent.put("total_amount", alipayTradePrecreateCusRequest.getOrderAmount());
        bizContent.put("subject", alipayTradePrecreateCusRequest.getOrderName());

        //// 商品明细信息，按需传入
        //JSONArray goodsDetail = new JSONArray();
        //JSONObject goods1 = new JSONObject();
        //goods1.put("goods_id", "goodsNo1");
        //goods1.put("goods_name", "子商品1");
        //goods1.put("quantity", 1);
        //goods1.put("price", 0.01);
        //goodsDetail.add(goods1);
        //bizContent.put("goods_detail", goodsDetail);

        //// 扩展信息，按需传入
        //JSONObject extendParams = new JSONObject();
        //extendParams.put("sys_service_provider_id", "2088511833207846");
        //bizContent.put("extend_params", extendParams);

        //// 结算信息，按需传入
        //JSONObject settleInfo = new JSONObject();
        //JSONArray settleDetailInfos = new JSONArray();
        //JSONObject settleDetail = new JSONObject();
        //settleDetail.put("trans_in_type", "defaultSettle");
        //settleDetail.put("amount", 0.01);
        //settleDetailInfos.add(settleDetail);
        //settleInfo.put("settle_detail_infos", settleDetailInfos);
        //bizContent.put("settle_info", settleInfo);

        //// 二级商户信息，按需传入
        //JSONObject subMerchant = new JSONObject();
        //subMerchant.put("merchant_id", "2088000603999128");
        //bizContent.put("sub_merchant", subMerchant);

        //// 业务参数信息，按需传入
        //JSONObject businessParams = new JSONObject();
        //businessParams.put("busi_params_key", "busiParamsValue");
        //bizContent.put("business_params", businessParams);

        //// 营销信息，按需传入
        //JSONObject promoParams = new JSONObject();
        //promoParams.put("promo_params_key", "promoParamsValue");
        //bizContent.put("promo_params", promoParams);

        request.setBizContent(bizContent.toString());
        try {
            AlipayTradePrecreateResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
            AlipayTradePrecreateCusResponse alipayTradePrecreateCusResponse = new AlipayTradePrecreateCusResponse();
            alipayTradePrecreateCusResponse.setBody(response.getBody());
            alipayTradePrecreateCusResponse.setOrderNo(req.getOrderId());
            alipayTradePrecreateCusResponse.setOrderAmount(alipayTradePrecreateCusRequest.getOrderAmount());
            alipayTradePrecreateCusResponse.setOrderName(alipayTradePrecreateCusRequest.getOrderName());
            alipayTradePrecreateCusResponse.setQrCode(response.getQrCode());
            alipayTradePrecreateCusResponse.setReqParam(bizContent.toString());
            alipayTradePrecreateCusResponse.setPayType(PayTypeEnum.ALIPAY_QRCODE);
            return (T) alipayTradePrecreateCusResponse;
        } catch (AlipayApiException alipayApiException) {
            throw new PayException(BusinessMsg.Fail, alipayApiException.getMessage());
        }
    }
}
