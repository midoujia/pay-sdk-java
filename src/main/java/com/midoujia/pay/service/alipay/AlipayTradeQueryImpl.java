package com.midoujia.pay.service.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.midoujia.pay.enums.AlipayTradeStatusEnum;
import com.midoujia.pay.enums.PayTypeEnum;
import com.midoujia.pay.exception.BusinessMsg;
import com.midoujia.pay.exception.PayException;
import com.midoujia.pay.model.PayRequest;
import com.midoujia.pay.model.PayResponse;
import com.midoujia.pay.model.alipay.AlipayTradePrecreateCusRequest;
import com.midoujia.pay.model.alipay.AlipayTradePrecreateCusResponse;
import com.midoujia.pay.model.alipay.AlipayTradeQueryCusRequest;
import com.midoujia.pay.model.alipay.AlipayTradeQueryCusResponse;
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
        AlipayTradeQueryCusRequest alipayTradeQueryCusRequest = (AlipayTradeQueryCusRequest) req;

        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", alipayTradeQueryCusRequest.getOrderNo());
        //bizContent.put("trade_no", "2014112611001004680073956707");
        request.setBizContent(bizContent.toString());
        try {
            AlipayTradeQueryResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                System.out.println("调用成功");
            } else {
                // 订单不存在
                if ("ACQ.TRADE_NOT_EXIST".equals(response.getSubCode())) {
                    throw new PayException(BusinessMsg.TradeNotExist, response.getSubMsg());
                }
                throw new PayException(BusinessMsg.Fail, response.getSubMsg());
            }
            AlipayTradeQueryCusResponse alipayTradeQueryCusResponse = new AlipayTradeQueryCusResponse();
            alipayTradeQueryCusResponse.setBody(response.getBody());
            alipayTradeQueryCusResponse.setOrderNo(req.getOrderNo());
            alipayTradeQueryCusResponse.setReqParam(bizContent.toString());
            alipayTradeQueryCusResponse.setOrderAmount(Double.valueOf(response.getBuyerPayAmount()));
            alipayTradeQueryCusResponse.setBuyerLoginId(response.getBuyerLogonId());
            alipayTradeQueryCusResponse.setBuyerUserId(response.getBuyerUserId());
            // 设置交易状态
            alipayTradeQueryCusResponse.setTradeStatus(AlipayTradeStatusEnum.findByName(response.getTradeStatus()));
            alipayTradeQueryCusResponse.setPayType(alipayTradeQueryCusRequest.getPayTypeEnum());
            return (T) alipayTradeQueryCusResponse;
        } catch (AlipayApiException alipayApiException) {
            throw new PayException(BusinessMsg.Fail, alipayApiException.getMessage());
        }
    }
}
