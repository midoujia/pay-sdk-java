package com.midoujia.pay.service;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.midoujia.pay.config.AliPayConfig;
import com.midoujia.pay.constants.AliPayConstants;
import com.midoujia.pay.enums.PayTypeEnum;
import com.midoujia.pay.exception.BusinessMsg;
import com.midoujia.pay.exception.PayException;
import com.midoujia.pay.model.PayRequest;
import com.midoujia.pay.model.PayResponse;
import com.midoujia.pay.service.DefaultPayClient;
import com.midoujia.pay.service.alipay.AlipayTradePagePayImpl;

/**
 * @author zfldiv@163.com
 */
public class AlipayServiceClient extends DefaultPayClient {

    protected AlipayClient alipayClient;

    public AlipayServiceClient() {}

    public AlipayServiceClient(AliPayConfig aliPayConfig) {
        // 初始化 AlipayClient
        this.alipayClient = new DefaultAlipayClient(AliPayConstants.SERVER_URL,
                aliPayConfig.getAppId(), aliPayConfig.getPrivateKey(), AliPayConstants.FORMAT, AliPayConstants.CHARSET_UTF8, aliPayConfig.getAliPayPublicKey(), AliPayConstants.SIGN_TYPE_RSA2);
    }

    public void setAlipayClient(AlipayClient alipayClient) {
        this.alipayClient = alipayClient;
    }

    @Override
    public <T extends PayResponse> T pay(PayRequest<T> request) {
        if (request.getPayTypeEnum() == PayTypeEnum.ALIPAY_PC) {
            AlipayTradePagePayImpl alipayTradePagePay = new AlipayTradePagePayImpl();
            alipayTradePagePay.setAlipayClient(alipayClient);
            return alipayTradePagePay.pay(request);
        }
        throw new PayException(BusinessMsg.PayTypeError);
    }
}
