package com.midoujia.pay.service;

import com.midoujia.pay.PayClient;
import com.midoujia.pay.config.AliPayConfig;
import com.midoujia.pay.config.WxPayConfig;
import com.midoujia.pay.enums.PayPlatformEnum;
import com.midoujia.pay.exception.BusinessMsg;
import com.midoujia.pay.exception.PayException;
import com.midoujia.pay.model.PayRequest;
import com.midoujia.pay.model.PayResponse;

/**
 * 支付实现
 *
 * @author zfldiv@163.com
 */
public class DefaultPayClient extends ServiceSupport implements PayClient {

    private AliPayConfig aliPayConfig;

    private WxPayConfig wxPayConfig;

    public DefaultPayClient() {}

    public DefaultPayClient(AliPayConfig aliPayConfig) {
        aliPayConfig.check();
        this.aliPayConfig = aliPayConfig;
    }

    public DefaultPayClient(WxPayConfig wxPayConfig) {
        wxPayConfig.check();
        this.wxPayConfig = wxPayConfig;
    }

    public DefaultPayClient(AliPayConfig aliPayConfig, WxPayConfig wxPayConfig) {
        aliPayConfig.check();
        wxPayConfig.check();
        this.aliPayConfig = aliPayConfig;
        this.wxPayConfig = wxPayConfig;
    }

    @Override
    public <T extends PayResponse> T pay(PayRequest<T> request) {
        if (request == null) {
            throw new PayException(BusinessMsg.ParamLoss, "request params must not be null.");
        }
        // 支付宝支付
        if (PayPlatformEnum.ALIPAY == request.getPayTypeEnum().getPlatform()) {
            AlipayServiceClient aliPayService = new AlipayServiceClient(this.aliPayConfig);
            return aliPayService.pay(request);
        }
        throw new PayException(BusinessMsg.PayTypeError);
    }
}