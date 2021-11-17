package com.midoujia.pay.config;

import lombok.Data;

import java.util.Objects;

/**
 * @author zfldiv@163.com
 */
@Data
public class AliPayConfig extends PayConfig {
    /**
     * appId
     */
    private String appId;
    /**
     * 商户私钥
     */
    private String privateKey;
    /**
     * 支付宝公钥
     */
    private String aliPayPublicKey;

    @Override
    public void check() {
        Objects.requireNonNull(appId, "config param 'appId' is null.");
        Objects.requireNonNull(privateKey, "config param 'privateKey' is null.");
        Objects.requireNonNull(aliPayPublicKey, "config param 'aliPayPublicKey' is null.");

        if (appId.length() > 32) {
            throw new IllegalArgumentException("config param 'appId' is incorrect: size exceeds 32.");
        }
    }
}
