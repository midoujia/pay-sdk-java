package com.midoujia.pay.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 支付时的同步/异步返回参数
 *
 * @author zfldiv@163.com
 */
@Data
public class PayResponse implements Serializable {

    /**
     * 第三方支付的流水号
     */
    private String orderNo;

    /**
     * 支付宝App支付返回的请求参数信息
     */
    private String orderInfo;
}
