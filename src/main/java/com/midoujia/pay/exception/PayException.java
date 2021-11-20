package com.midoujia.pay.exception;

/**
 * 异常类
 *
 * @author zfldiv@163.com
 */
public class PayException extends RuntimeException {
    private Business business;
    private Object data;

    public PayException(Business business) {
        super(business.getMsg());
        this.business = business;
    }

    public PayException(Business business, String data) {
        super(business.getMsg() + data);
        this.business = business;
        this.data = data;
    }

    public Business getBusiness() {
        return this.business;
    }

    public Object getData() {
        return this.data;
    }
}
