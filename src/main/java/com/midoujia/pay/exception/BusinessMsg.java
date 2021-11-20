package com.midoujia.pay.exception;

/**
 * 异常业务Code码
 *
 * @author zfldiv@163.com
 */
public enum BusinessMsg implements Business {

    /**
     * 通用Code码
     */
    Fail("99999", "fail"),
    Success("00000", "success"),
    ParamLoss("99998", "param loss"),

    /**
     * 业务异常Code码
     */
    PayTypeError("00001", "错误的支付方式"),
    PayConfigError("00002", "请用有参构造进行初始化配置！"),
    ;

    private String code;
    private String msg;

    BusinessMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
