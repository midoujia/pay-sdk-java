package com.test;

import com.alipay.api.AlipayApiException;
import com.midoujia.pay.PayClient;
import com.midoujia.pay.config.AliPayConfig;
import com.midoujia.pay.enums.PayTypeEnum;
import com.midoujia.pay.model.alipay.AlipayTradePagePayCusRequest;
import com.midoujia.pay.model.alipay.AlipayTradePagePayCusResponse;
import com.midoujia.pay.service.AlipayServiceClient;
import com.midoujia.pay.service.DefaultPayClient;
import org.junit.Test;

public class TestPay {

    @Test
    public void test2() {
        String ALIPAY_PUBLIC_KEY = "你的公钥";
        String APP_PRIVATE_KEY = "你的私钥";

        AliPayConfig aliPayConfig = new AliPayConfig();
        aliPayConfig.setAppId("2021000116697530");
        aliPayConfig.setPrivateKey(APP_PRIVATE_KEY);
        aliPayConfig.setAliPayPublicKey(ALIPAY_PUBLIC_KEY);

        PayClient payClient = new DefaultPayClient(aliPayConfig);
        // PayClient payClient = new AlipayServiceClient(aliPayConfig);

        AlipayTradePagePayCusRequest alipayTradePagePayCusRequest = new AlipayTradePagePayCusRequest();
        alipayTradePagePayCusRequest.setPayTypeEnum(PayTypeEnum.ALIPAY_PC);
        alipayTradePagePayCusRequest.setOrderAmount(0.01);
        alipayTradePagePayCusRequest.setOrderName("测试商品");
        alipayTradePagePayCusRequest.setOrderId("20210817010101004");
        AlipayTradePagePayCusResponse payResponse = payClient.pay(alipayTradePagePayCusRequest);
        System.out.println(payResponse);
    }

    @Test
    public void test1() throws AlipayApiException {

    }
}
