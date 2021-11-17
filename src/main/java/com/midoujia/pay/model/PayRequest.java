package com.midoujia.pay.model;

import com.midoujia.pay.enums.PayTypeEnum;

/**
 * @author zfldiv@163.com
 */
public interface PayRequest<T extends PayResponse> {

    /**
     * 支付方式.
     */
    PayTypeEnum getPayTypeEnum();
    void setPayTypeEnum(PayTypeEnum payTypeEnum);

    /**
     * 订单号.
     */
    String getOrderId();
    void setOrderId(String orderId);

    /**
     * 订单金额.
     */
    Double getOrderAmount();
    void setOrderAmount(Double orderAmount);

    /**
     * 订单名字.
     */
    String getOrderName();
    void setOrderName(String orderName);
}
