package com.aiways.datamap.exception.handler;

import com.aiways.datamap.exception.entity.Result;
import com.aiways.datamap.exception.enums.ResultEnum;
import com.aiways.datamap.exception.exception.MyException;
import com.aiways.datamap.exception.utils.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常统一处理类，方便用户可以更加友好的看到错误信息
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理系统内部异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        e.printStackTrace();
        return ResultUtil.getError(ResultEnum.SystemException.getCode(),
                ResultEnum.ServiceException.getMsg());
    }

    /**
     * 处理自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public Result handleMyException(MyException e){
        e.printStackTrace();
        return ResultUtil.getError(e.getCode(), e.getMessage());
    }

}
