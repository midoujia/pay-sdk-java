# 最流行的支付SDK for java

### V1.0.0 版本内容更新
1. 接入支付宝支付

### 优点
1. 低依赖

### 快速接入

Maven 依赖
```xml
<dependency>
    <groupId>com.midoujia</groupId>
    <artifactId>pay-sdk-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

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
