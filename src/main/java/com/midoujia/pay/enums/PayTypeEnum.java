package com.midoujia.pay.enums;

import com.midoujia.pay.exception.PayException;
import com.midoujia.pay.exception.BusinessMsg;

import static com.midoujia.pay.enums.PayPlatformEnum.ALIPAY;

/**
 * 支付方式
 *
 * @author zfldiv@163.com
 */
public enum PayTypeEnum {

    /**
     * 支付方式
     */
    ALIPAY_APP("alipay_app", ALIPAY, "支付宝app"),
    ALIPAY_PC("alipay_pc", ALIPAY, "支付宝pc"),
    ALIPAY_QRCODE("alipay_precreate", ALIPAY, "支付宝统一收单线下交易预创建"),
    ALIPAY_BARCODE("alipay_barcode", ALIPAY, "支付宝统一收单交易支付接口(付款码)"),
    ;

    private String code;
    private PayPlatformEnum platform;
    private String desc;

    PayTypeEnum(String code, PayPlatformEnum platform, String desc) {
        this.code = code;
        this.platform = platform;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public PayPlatformEnum getPlatform() {
        return platform;
    }

    public String getDesc() {
        return desc;
    }

    public static PayTypeEnum getByName(String code) {
        for (PayTypeEnum bestPayTypeEnum : PayTypeEnum.values()) {
            if (bestPayTypeEnum.name().equalsIgnoreCase(code)) {
                return bestPayTypeEnum;
            }
        }
        throw new PayException(BusinessMsg.PayTypeError);
    }
}
