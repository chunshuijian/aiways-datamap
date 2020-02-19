package com.aiways.datamap.exception.entity;

import lombok.Data;

/**
 * 异常处理实体包装类
 */
@Data
public class Result<T> {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;
}

/*
{
    "code": 200, //通过状态码可以得到消息是否返回正常，然后再决定是否去解析data域的内容
    "data": { //返回的数据内容
    }
    "msg": success //返回的提示内容
}
 */