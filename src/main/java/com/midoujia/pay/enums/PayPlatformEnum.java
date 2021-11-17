package com.midoujia.pay.enums;

/**
 * 支付平台
 *
 * @author zfldiv@163.com
 */
public enum PayPlatformEnum {

    /**
     * 支付平台
     */
    ALIPAY("alipay", "支付宝"),
    Wechat("wechat", "微信"),
    ;

    private String code;
    private String name;

    PayPlatformEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
