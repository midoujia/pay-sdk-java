package com.test;

import com.midoujia.pay.PayClient;
import com.midoujia.pay.config.AliPayConfig;
import com.midoujia.pay.enums.PayTypeEnum;
import com.midoujia.pay.model.alipay.MiDouAlipayTradePagePayRequest;
import com.midoujia.pay.model.alipay.MiDouAlipayTradePagePayResponse;
import com.midoujia.pay.service.DefaultPayClient;

public class TestPay {

    //@Test
    public void test() {
        String ALIPAY_PUBLIC_KEY = "你的公钥";
        String APP_PRIVATE_KEY = "你的私钥";

        AliPayConfig aliPayConfig = new AliPayConfig();
        aliPayConfig.setAppId("2021000116697530");
        aliPayConfig.setPrivateKey(APP_PRIVATE_KEY);
        aliPayConfig.setAliPayPublicKey(ALIPAY_PUBLIC_KEY);
        // 开启沙箱环境
        aliPayConfig.setSandbox(true);

        PayClient payClient = new DefaultPayClient(aliPayConfig);
        // PayClient payClient = new AlipayServiceClient(aliPayConfig);

        MiDouAlipayTradePagePayRequest alipayTradePagePayCusRequest = new MiDouAlipayTradePagePayRequest();
        alipayTradePagePayCusRequest.setPayTypeEnum(PayTypeEnum.ALIPAY_PC);
        alipayTradePagePayCusRequest.setOrderAmount(0.01);
        alipayTradePagePayCusRequest.setOrderName("测试商品");
        alipayTradePagePayCusRequest.setOrderNo("20210817010101004");
        MiDouAlipayTradePagePayResponse payResponse = payClient.pay(alipayTradePagePayCusRequest);
        System.out.println(payResponse);
    }
}
