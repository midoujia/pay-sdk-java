package com.midoujia.pay.service;

import com.midoujia.pay.exception.Business;
import com.midoujia.pay.exception.PayException;

/**
 * @author zfldiv@163.com
 */
public interface ServiceSupport {
    default void ex(Business business) {
        throw new PayException(business);
    }
}
