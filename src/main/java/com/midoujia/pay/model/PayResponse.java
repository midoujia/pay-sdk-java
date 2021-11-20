package com.midoujia.pay.model;

import java.io.Serializable;

/**
 * 支付时的同步/异步返回参数
 *
 * @author zfldiv@163.com
 */
public class PayResponse implements Serializable {

    /** 第三方支付的流水号 */
    private String orderNo;

    /** 支付宝App支付返回的请求参数信息 */
    private String orderInfo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }
}
