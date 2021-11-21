package com.midoujia.pay.model;

import com.midoujia.pay.enums.PayTypeEnum;

import java.io.Serializable;

/**
 * 支付时的同步/异步返回参数
 *
 * @author zfldiv@163.com
 */
public class PayResponse implements Serializable {

    /** 支付方式 */
    private PayTypeEnum payType;

    /** 第三方支付的流水号（订单号） */
    private String orderNo;

    /** 支付返回的请求参数信息 */
    private String reqParam;

    public PayTypeEnum getPayType() {
        return payType;
    }

    public void setPayType(PayTypeEnum payType) {
        this.payType = payType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getReqParam() {
        return reqParam;
    }

    public void setReqParam(String reqParam) {
        this.reqParam = reqParam;
    }
}
