package com.midoujia.pay.model.alipay;

import com.midoujia.pay.enums.PayTypeEnum;
import com.midoujia.pay.model.PayRequest;

/**
 * alipay.trade.precreate(统一收单线下交易预创建) 请求体
 *
 * @author zfldiv@163.com
 */
public class MiDouAlipayTradePrecreateRequest implements PayRequest<MiDouAlipayTradePrecreateResponse> {

    /** 支付类型 */
    private PayTypeEnum payTypeEnum;

    /** 订单号 */
    private String orderNo;

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
    public String getOrderNo() {
        return orderNo;
    }

    @Override
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Double getOrderAmount() {
        return this.orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderName() {
        return this.orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
