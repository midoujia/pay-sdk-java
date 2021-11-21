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
import com.midoujia.pay.service.alipay.AlipayTradePagePayImpl;
import com.midoujia.pay.service.alipay.AlipayTradePrecreateImpl;

/**
 * @author zfldiv@163.com
 */
public class AlipayServiceClient extends DefaultPayClient {

    protected AlipayClient alipayClient;

    public AlipayServiceClient() {}

    public AlipayServiceClient(AliPayConfig aliPayConfig) {
        // 是否是沙箱环境
        if (aliPayConfig.getSandbox()) {
            // 沙箱环境初始化 AlipayClient
            this.alipayClient = new DefaultAlipayClient(AliPayConstants.SERVER_URL_DEV,
                    aliPayConfig.getAppId(), aliPayConfig.getPrivateKey(), AliPayConstants.FORMAT,
                    AliPayConstants.CHARSET_UTF8, aliPayConfig.getAliPayPublicKey(), AliPayConstants.SIGN_TYPE_RSA2);
        } else {
            // 线上环境初始化 AlipayClient
            this.alipayClient = new DefaultAlipayClient(AliPayConstants.SERVER_URL,
                    aliPayConfig.getAppId(), aliPayConfig.getPrivateKey(), AliPayConstants.FORMAT,
                    AliPayConstants.CHARSET_UTF8, aliPayConfig.getAliPayPublicKey(), AliPayConstants.SIGN_TYPE_RSA2);
        }
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
        } else if (request.getPayTypeEnum() == PayTypeEnum.ALIPAY_QRCODE) {
            AlipayTradePrecreateImpl alipayTradePrecreate = new AlipayTradePrecreateImpl();
            alipayTradePrecreate.setAlipayClient(alipayClient);
            return alipayTradePrecreate.pay(request);
        }
        throw new PayException(BusinessMsg.PayTypeError);
    }
}
