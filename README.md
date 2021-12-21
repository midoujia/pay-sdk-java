pay-sdk-java
=
[![Maven Central](https://img.shields.io/badge/maven--central-v1.0.2-green)](https://mvnrepository.com/artifact/com.midoujia/pay-sdk-java)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fmidoujia%2Fpay-sdk-java.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Fmidoujia%2Fpay-sdk-java?ref=badge_shield)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/17833dfd82d34624ab5623d736bc376d)](https://app.codacy.com/gh/midoujia/pay-sdk-java/dashboard)

## 介绍 

最流行的支付SDK for java

## 已支持功能

- 接入支付宝PC web支付
- 接入支付宝当面付扫码支付
- 接入订单查询

## 快速接入

Maven 依赖
```xml
<dependency>
    <groupId>com.midoujia</groupId>
    <artifactId>pay-sdk-java</artifactId>
    <version>1.0.2</version>
</dependency>
```

## 实例
Demo实例1：
```java
public class Demo01 {
    @Test
    public void test() {
        String ALIPAY_PUBLIC_KEY = "Alipay公钥";
        String APP_PRIVATE_KEY = "你生成的私钥";

        AliPayConfig aliPayConfig = new AliPayConfig();
        aliPayConfig.setAppId("APPID");
        aliPayConfig.setPrivateKey(APP_PRIVATE_KEY);
        aliPayConfig.setAliPayPublicKey(ALIPAY_PUBLIC_KEY);
        // 开启沙箱环境
        aliPayConfig.setSandbox(true);

        PayClient payClient = new DefaultPayClient(aliPayConfig);
        // PayClient payClient = new AlipayServiceClient(aliPayConfig);

        MiDouAlipayTradePagePayCusRequest miDouAlipayTradePagePayCusRequest = new MiDouAlipayTradePagePayCusRequest();
        miDouAlipayTradePagePayCusRequest.setPayTypeEnum(PayTypeEnum.ALIPAY_PC);
        miDouAlipayTradePagePayCusRequest.setOrderAmount(0.01);
        miDouAlipayTradePagePayCusRequest.setOrderName("测试商品名称");
        miDouAlipayTradePagePayCusRequest.setOrderId("20210817010101004");// 订单号
        MiDouAlipayTradePagePayCusResponse payResponse = payClient.pay(miDouAlipayTradePagePayCusRequest);
        System.out.println(payResponse.getBody());
    }
}
```

Demo实例2 Springboot项目集成：

```java
@Configuration
public class ApplicationConfig {

    @Bean
    @ConditionalOnMissingBean(name = {"payClient"})
    public PayClient payClient(){
        String ALIPAY_PUBLIC_KEY = "Alipay公钥";
        String APP_PRIVATE_KEY = "你生成的私钥";
        AliPayConfig aliPayConfig = new AliPayConfig();
        aliPayConfig.setAppId("APPID");
        aliPayConfig.setPrivateKey(APP_PRIVATE_KEY);
        aliPayConfig.setAliPayPublicKey(ALIPAY_PUBLIC_KEY);
        return new DefaultPayClient(aliPayConfig);
    }
}

public class Demo02 {
    
    @Autowired
    private PayClient payClient;

    public void pay() {
        MiDouAlipayTradePagePayCusRequest miDouAlipayTradePagePayCusRequest = new MiDouAlipayTradePagePayCusRequest();
        miDouAlipayTradePagePayCusRequest.setPayTypeEnum(PayTypeEnum.ALIPAY_PC);
        miDouAlipayTradePagePayCusRequest.setOrderAmount(0.01);
        miDouAlipayTradePagePayCusRequest.setOrderName("测试商品名称");
        miDouAlipayTradePagePayCusRequest.setOrderId("20210817010101004");
        MiDouAlipayTradePagePayCusResponse payResponse = payClient.pay(miDouAlipayTradePagePayCusRequest);
        System.out.println(payResponse);
    }
}
```

## License

[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fmidoujia%2Fpay-sdk-java.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Fmidoujia%2Fpay-sdk-java?ref=badge_large)