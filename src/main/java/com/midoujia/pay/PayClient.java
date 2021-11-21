package com.midoujia.pay;

import com.midoujia.pay.exception.PayException;
import com.midoujia.pay.model.PayRequest;
import com.midoujia.pay.model.PayResponse;

/**
 * @author zfldiv@163.com
 */
public interface PayClient {

    /**
     * 发起支付
     *
     * @param request 请求对象
     * @param <T> 具体的请求对象
     * @return PayResponse
     * @throws PayException 自定义异常
     */
    <T extends PayResponse> T pay(PayRequest<T> request) throws PayException;

    /**
     * 订单查询
     *
     * @param request 请求对象
     * @param <T> 具体的请求对象
     * @return PayResponse
     * @throws PayException 自定义异常
     */
    <T extends PayResponse> T queryOrder(PayRequest<T> request) throws PayException;
}
