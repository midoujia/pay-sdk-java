package com.midoujia.pay.model.alipay;

import com.midoujia.pay.enums.AlipayTradeStatusEnum;
import com.midoujia.pay.model.PayResponse;

/**
 * alipay.trade.query(统一收单线下交易查询) 返回体
 *
 * @author zfldiv@163.com
 */
public class AlipayTradeQueryCusResponse extends PayResponse {

    /** 交易状态 */
    private AlipayTradeStatusEnum tradeStatus;

    /** 订单金额 */
    private Double orderAmount;

    /** 买家支付宝账号 eg:159****5620 */
    private String buyerLoginId;

    /** 买家在支付宝的用户id eg:2088101117955611 */
    private String buyerUserId;

    /** 公共响应参数 */
    private String body;

    public AlipayTradeStatusEnum getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(AlipayTradeStatusEnum tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getBuyerLoginId() {
        return buyerLoginId;
    }

    public void setBuyerLoginId(String buyerLoginId) {
        this.buyerLoginId = buyerLoginId;
    }

    public String getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
