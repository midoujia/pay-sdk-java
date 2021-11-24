package com.midoujia.pay.service.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.midoujia.pay.enums.AlipayTradeStatusEnum;
import com.midoujia.pay.exception.BusinessMsg;
import com.midoujia.pay.exception.PayException;
import com.midoujia.pay.model.PayRequest;
import com.midoujia.pay.model.PayResponse;
import com.midoujia.pay.model.alipay.MiDouAlipayTradeQueryRequest;
import com.midoujia.pay.model.alipay.MiDouAlipayTradeQueryResponse;
import com.midoujia.pay.service.AlipayServiceClient;

/**
 * alipay.trade.query(统一收单线下交易查询)
 * 文档：https://opendocs.alipay.com/open/02ekfh?scene=common
 *
 * @author zfldiv@163.com
 */
public class AlipayTradeQueryImpl extends AlipayServiceClient {

    @Override
    public <T extends PayResponse> T queryOrder(PayRequest<T> req) {
        MiDouAlipayTradeQueryRequest miDouAlipayTradeQueryRequest = (MiDouAlipayTradeQueryRequest) req;

        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", miDouAlipayTradeQueryRequest.getOrderNo());
        //bizContent.put("trade_no", "2014112611001004680073956707");
        request.setBizContent(bizContent.toString());
        try {
            AlipayTradeQueryResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                MiDouAlipayTradeQueryResponse miDouAlipayTradeQueryResponse = new MiDouAlipayTradeQueryResponse();
                miDouAlipayTradeQueryResponse.setBody(response.getBody());
                miDouAlipayTradeQueryResponse.setOrderNo(req.getOrderNo());
                miDouAlipayTradeQueryResponse.setReqParam(bizContent.toString());
                miDouAlipayTradeQueryResponse.setOrderAmount(Double.valueOf(response.getBuyerPayAmount()));
                miDouAlipayTradeQueryResponse.setBuyerLoginId(response.getBuyerLogonId());
                miDouAlipayTradeQueryResponse.setBuyerUserId(response.getBuyerUserId());
                // 设置交易状态
                miDouAlipayTradeQueryResponse.setTradeStatus(AlipayTradeStatusEnum.findByName(response.getTradeStatus()));
                miDouAlipayTradeQueryResponse.setPayType(miDouAlipayTradeQueryRequest.getPayTypeEnum());
                return (T) miDouAlipayTradeQueryResponse;
            } else {
                // 订单不存在
                if ("ACQ.TRADE_NOT_EXIST".equals(response.getSubCode())) {
                    throw new PayException(BusinessMsg.TradeNotExist, response.getSubMsg());
                }
                throw new PayException(BusinessMsg.Fail, response.getSubMsg());
            }
        } catch (AlipayApiException alipayApiException) {
            throw new PayException(BusinessMsg.Fail, alipayApiException.getMessage());
        }
    }
}
