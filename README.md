pay-sdk-java
=

## 介绍 

最流行的支付SDK for java

## 已支持功能

- 接入支付宝PC web支付

## 快速接入

Maven 依赖
```xml
<dependency>
    <groupId>com.midoujia</groupId>
    <artifactId>pay-sdk-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 实例
Demo实例
```java
public class Demo01 {
    @Test
    public void test() {
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
}
```

## License

[MIT](https://github.com/midoujia/pay-sdk-java/blob/main/LICENSE)