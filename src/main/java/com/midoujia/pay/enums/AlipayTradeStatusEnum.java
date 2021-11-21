package com.midoujia.pay.enums;

/**
 * 支付宝交易状态
 *
 * @author zfldiv@163.com
 */
public enum AlipayTradeStatusEnum {

    /**
     * 支付宝交易状态：
     */
    WAIT_BUYER_PAY("交易创建，等待买家付款"),
    TRADE_CLOSED("未付款交易超时关闭，或支付完成后全额退款"),
    TRADE_SUCCESS("交易支付成功"),
    TRADE_FINISHED("交易结束，不可退款"),
    UNKNOW("未知状态"),
    ;

    /** 描述 */
    private String desc;

    AlipayTradeStatusEnum(String desc) {
        this.desc = desc;
    }

    public static AlipayTradeStatusEnum findByName(String name) {
        for (AlipayTradeStatusEnum alipayTradeStatusEnum : AlipayTradeStatusEnum.values()) {
            if (name.equalsIgnoreCase(alipayTradeStatusEnum.name())) {
                return alipayTradeStatusEnum;
            }
        }
        // throw new PayException(BusinessMsg.Fail, "错误的支付宝支付状态");
        return UNKNOW;
    }

    public String getDesc() {
        return desc;
    }
}
