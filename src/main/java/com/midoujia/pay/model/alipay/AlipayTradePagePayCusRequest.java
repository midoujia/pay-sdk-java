package com.midoujia.pay.model.alipay;

import com.midoujia.pay.enums.PayTypeEnum;
import com.midoujia.pay.model.PayRequest;
import lombok.Data;

/**
 * @author zfldiv@163.com
 */
@Data
public class AlipayTradePagePayCusRequest implements PayRequest<AlipayTradePagePayCusResponse> {
    private PayTypeEnum payTypeEnum;
    private String orderId;
    private Double orderAmount;
    private String orderName;
}
