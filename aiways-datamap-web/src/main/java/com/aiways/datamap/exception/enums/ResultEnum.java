package com.aiways.datamap.exception.enums;

/**
 * 自定义一些返回状态码，便于本系统的使用，自己先定义如下的，有需要就后续补充
 * 在系统中，我们应该有统一的某些编码对应某些内容，这样能够方便开发人员进行及时的处理。
 */
public enum ResultEnum {
    /**
     * 成功.: 200 (因为http中的状态码200一般都是表示成功)
     */
    SUCCESS(200, "成功"),

    /**
     * 系统异常. ErrorCode : -1
     */
    SystemException(-1, "系统异常"),

    /**
     * 未知异常. ErrorCode : 01
     */
    UnknownException(01, "未知异常"),

    /**
     * 服务异常. ErrorCode : 02
     */
    ServiceException(02, "服务异常"),

    /**
     * 业务错误. ErrorCode : 03
     */
    MyException(03, "业务错误"),

    /**
     * 提示级错误. ErrorCode : 04
     */
    InfoException(04, "提示级错误"),

    /**
     * 数据库操作异常. ErrorCode : 05
     */
    DBException(05, "数据库操作异常"),

    /**
     * 参数验证错误. ErrorCode : 06
     */
    ParamException(06, "参数验证错误");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
