package com.midoujia.pay.config;

import com.midoujia.pay.exception.BusinessMsg;
import com.midoujia.pay.exception.PayException;
import com.midoujia.pay.utils.StringUtil;

/**
 * 支付宝配置类
 *
 * @author zfldiv@163.com
 */
public class AliPayConfig extends PayConfig {

    /** appId */
    private String appId;

    /** 商户私钥 */
    private String privateKey;

    /** 支付宝公钥 */
    private String aliPayPublicKey;

    @Override
    public void check() {

        if (StringUtil.isEmpty(appId)) {
            throw new PayException(BusinessMsg.ParamLoss, "config param 'appId' is null.");
        }
        if (StringUtil.isEmpty(privateKey)) {
            throw new PayException(BusinessMsg.ParamLoss, "config param 'privateKey' is null.");
        }
        if (StringUtil.isEmpty(aliPayPublicKey)) {
            throw new PayException(BusinessMsg.ParamLoss, "config param 'aliPayPublicKey' is null.");
        }

        if (appId.length() > 32) {
            throw new IllegalArgumentException("config param 'appId' is incorrect: size exceeds 32.");
        }
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAliPayPublicKey() {
        return aliPayPublicKey;
    }

    public void setAliPayPublicKey(String aliPayPublicKey) {
        this.aliPayPublicKey = aliPayPublicKey;
    }
}
