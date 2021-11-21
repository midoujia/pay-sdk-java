package com.midoujia.pay.model;

import com.midoujia.pay.enums.PayTypeEnum;

/**
 * @author zfldiv@163.com
 */
public interface PayRequest<T extends PayResponse> {

    /**
     * 支付方式
     *
     * @return PayTypeEnum
     */
    PayTypeEnum getPayTypeEnum();
    void setPayTypeEnum(PayTypeEnum payTypeEnum);

    /**
     * 订单号.
     *
     * @return String
     */
    String getOrderNo();
    void setOrderNo(String orderNo);
}
