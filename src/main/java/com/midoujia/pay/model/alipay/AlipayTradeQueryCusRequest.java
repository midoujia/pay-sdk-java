package com.midoujia.pay.model.alipay;

import com.midoujia.pay.enums.PayTypeEnum;
import com.midoujia.pay.model.PayRequest;

/**
 * alipay.trade.query(统一收单线下交易查询) 请求体
 *
 * @author zfldiv@163.com
 */
public class AlipayTradeQueryCusRequest implements PayRequest<AlipayTradeQueryCusResponse> {

    /** 支付类型 */
    private PayTypeEnum payTypeEnum;

    /** 订单号 */
    private String orderNo;

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
}
