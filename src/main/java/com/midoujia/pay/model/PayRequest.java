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
    String getOrderId();
    void setOrderId(String orderId);

    /**
     * 订单金额.
     *
     * @return Double
     */
    Double getOrderAmount();
    void setOrderAmount(Double orderAmount);

    /**
     * 订单名字.
     *
     * @return String
     */
    String getOrderName();
    void setOrderName(String orderName);
}
