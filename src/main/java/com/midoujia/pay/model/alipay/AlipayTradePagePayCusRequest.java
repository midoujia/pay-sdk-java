package com.midoujia.pay.model.alipay;

import com.midoujia.pay.enums.PayTypeEnum;
import com.midoujia.pay.model.PayRequest;


/**
 * alipay.trade.page.pay(统一收单下单并支付页面接口) 请求体
 *
 * @author zfldiv@163.com
 */
public class AlipayTradePagePayCusRequest implements PayRequest<AlipayTradePagePayCusResponse> {
    private PayTypeEnum payTypeEnum;
    private String orderId;
    private Double orderAmount;
    private String orderName;

    @Override
    public PayTypeEnum getPayTypeEnum() {
        return payTypeEnum;
    }

    @Override
    public void setPayTypeEnum(PayTypeEnum payTypeEnum) {
        this.payTypeEnum = payTypeEnum;
    }

    @Override
    public String getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public Double getOrderAmount() {
        return orderAmount;
    }

    @Override
    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String getOrderName() {
        return orderName;
    }

    @Override
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
