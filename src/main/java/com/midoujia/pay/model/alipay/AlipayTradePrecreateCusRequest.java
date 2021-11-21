package com.midoujia.pay.model.alipay;

import com.midoujia.pay.enums.PayTypeEnum;
import com.midoujia.pay.model.PayRequest;

/**
 * alipay.trade.precreate(统一收单线下交易预创建) 请求体
 *
 * @author zfldiv@163.com
 */
public class AlipayTradePrecreateCusRequest implements PayRequest<AlipayTradePrecreateCusResponse> {

    private PayTypeEnum payTypeEnum;
    private String orderId;
    private Double orderAmount;
    private String orderName;

    @Override
    public PayTypeEnum getPayTypeEnum() {
        return this.payTypeEnum;
    }

    @Override
    public void setPayTypeEnum(PayTypeEnum payTypeEnum) {
        this.payTypeEnum = payTypeEnum;
    }

    @Override
    public String getOrderId() {
        return this.orderId;
    }

    @Override
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public Double getOrderAmount() {
        return this.orderAmount;
    }

    @Override
    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String getOrderName() {
        return this.orderName;
    }

    @Override
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
