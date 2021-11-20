package com.midoujia.pay.service;

import com.midoujia.pay.exception.Business;
import com.midoujia.pay.exception.PayException;

/**
 * Service上层抽象类
 *
 * @author zfldiv@163.com
 */
public abstract class ServiceSupport {

    /**
     * 异常方法
     *
     * @param business 系统业务异常枚举
     */
    protected void ex(Business business) {
        throw new PayException(business);
    }

    /**
     * 异常方法
     *
     * @param business 系统业务异常枚举
     * @param data 自定义数据返回
     */
    protected void ex(Business business, Object data) {
        throw new PayException(business);
    }
}
