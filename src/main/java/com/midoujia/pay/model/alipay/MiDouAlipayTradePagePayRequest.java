package com.midoujia.pay.model.alipay;

import com.midoujia.pay.enums.PayTypeEnum;
import com.midoujia.pay.model.PayRequest;


/**
 * alipay.trade.page.pay(统一收单下单并支付页面接口) 请求体
 *
 * @author zfldiv@163.com
 */
public class MiDouAlipayTradePagePayRequest implements PayRequest<MiDouAlipayTradePagePayResponse> {

    /** 支付类型 */
    private PayTypeEnum payTypeEnum;

    /** 订单号 */
    private String orderNo;

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
    public String getOrderNo() {
        return orderNo;
    }

    @Override
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
