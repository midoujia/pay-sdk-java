package com.midoujia.pay.model.alipay;

import com.midoujia.pay.model.PayResponse;

/**
 * alipay.trade.precreate(统一收单线下交易预创建) 返回体
 *
 * @author zfldiv@163.com
 */
public class AlipayTradePrecreateCusResponse extends PayResponse {

    /** 订单金额 */
    private Double orderAmount;

    /** 订单标题。 注意：不可使用特殊字符，如 /，=，& 等。*/
    private String orderName;

    /** 当前预下单请求生成的二维码码串，可以用二维码生成工具根据该码串值生成对应的二维码 */
    private String qrCode;

    /** 公共响应参数 */
    private String body;

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

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
