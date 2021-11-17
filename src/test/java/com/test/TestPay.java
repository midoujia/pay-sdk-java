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
        String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAykDPL9odscHw2De7/lKZXQDmPAOhlY9mrmQB09gCaWe7a+jRok3cEGy5SW0qUDntN4For42gxES7EnE6ORfRCaSMmTmfc3maDqzHTeV/9ZOJbGIzs8XrdBGx5ohumtodMv78Nzq9DweeasPkvx3t5h+ozNlFNonQwTMMxSHsrfXgv0ygmAuPpuB9X20Zetezu+oyVHDPzbj9i1SLhqQ1XDFbBkECOZlhB5ihQXqtv3QmyqZ95HVP0pT5mgje+EjRN+ZYZPYGqLbYOhK8U9xJaynYLl1nSPAHuCLMqaGAZoOD4pOrdKsU+wZxt3z6Jbn8BUcS7BaAxwWg5BhMFYyhDwIDAQAB";
        String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDKQM8v2h2xwfDYN7v+UpldAOY8A6GVj2auZAHT2AJpZ7tr6NGiTdwQbLlJbSpQOe03gWivjaDERLsScTo5F9EJpIyZOZ9zeZoOrMdN5X/1k4lsYjOzxet0EbHmiG6a2h0y/vw3Or0PB55qw+S/He3mH6jM2UU2idDBMwzFIeyt9eC/TKCYC4+m4H1fbRl617O76jJUcM/NuP2LVIuGpDVcMVsGQQI5mWEHmKFBeq2/dCbKpn3kdU/SlPmaCN74SNE35lhk9gaottg6ErxT3ElrKdguXWdI8Ae4IsypoYBmg4Pik6t0qxT7BnG3fPolufwFRxLsFoDHBaDkGEwVjKEPAgMBAAECggEAXcYiyfsFXY+gTX+56Db/6IEsPpMobiGo6B5yQnia1ahE28l8uRYEfJEMb6Dvx3a0J9IWaZ7u9VEws2JQLnx+bUwf7EMtTOsKpNczKUjJRWF8jAYUFrwjaRNzOoHzVlTeyPA0nJ7dXYSYzMO64WnNDa+MIj5yutC3O3yh5RzPke/lmYD5OEe411Zko75T4N+hHY9ropOE837txu7OeF9mR/zLme0tTWaqTUlA0XpPgIId0kD5fdQTlgp/b3rkI49VM8wN4ldTeEIDGIb/TXHDQo58KQcSwOG8jlOaa2QAEIsU16gFkLgiEMLuYnR7TF63hsi21ZOXsLBb2ZPG97ixEQKBgQDmUJcRibuyxu6dlYD/jrXeNH8y+1zyklJic11SWLaJWvK6/Ernc/XGTZaeZaArI9jABNehnW4wazKsd1ULanA/FqVkZEO1b2CZDMJgPw2uXufn/qaNd6PtP8W+xdVx4+ZD/DuAFNBscYc/ryE1T2osa1ZyDwsR0A8dHSSYguBSpQKBgQDgzxGagNUiwlRHD3hpzCe/nTeYZTMkOpOAAA0D6DRrQYjefsqwYIpIFBL6ZN39Zxsng+J50SIJbj290+BDP3+hfMnYGJRXzIZbzOXv+AS9A7eCszeRncQp1jL0/oR3WHI8sS0Bss7923aKs6nrr46T2xz6/a3joXuxCVOj1uJaowKBgQCxahs1E1hXWw6srWH1esV2KhJh/2eWJEj6NcwJhvT10e1xRK+eo6EL5PDFi5taH/7zy8cfY9phyfH7EOGeLZvRvWwibWoK9YT/4OhKo8eyLsGN4IgEKclJFPsK/fJyDRBwBnj/LQlwv/Njh1CZdFdhaD3rFtN8IT3DO5PZN9f9UQKBgBrQeBAOt91qgnTrYnh0EnWngf8aawwyNG+7EdJaew4kBfhL9U8uZLAOPOlC6LuV9cYz0+qlyEKJtLGUuRYsV8PiR40P+Xmzen8upGqIEcCd1eCwEbu7rq8yzmcsiI5XrWCR3YVrV4cuCyimH2luSjpWk1FYusoA8+j87M4JDnyzAoGBANCs6Qgn2xLri6mD/7hsSkv3dS+azWipM6CT4c192NQkApOzGeQ6evaEIydfwAFYJN7vgCHEKo3/oOgHnWBGTGavcBGtW6yr39HskI6W40cVV1YnkXA9iPU0vEZAI4OvpqMq1xMZCDFpl/sUkblr5/ApzfXB6Vs+svumBR8eyBYl";

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
