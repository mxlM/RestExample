package com.panodata.conf.response;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

/**
 * 统一异常处理
 * Created by wp_sp on 2017/9/21.
 */
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {
    private static Logger logger = Logger.getLogger(RestExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private <T> ResponseResult<T> runtimeExceptionHandler(Exception e) {
        logger.error("---------> huge error!", e);
        return RestResultGenerator.genErrorResult(ResponseErrorEnum.ERROR_C01);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private <T> ResponseResult<T> illegalParamsExceptionHandler(MethodArgumentNotValidException e) {
        logger.error("---------> invalid request!", e);
        return RestResultGenerator.genErrorResult(ResponseErrorEnum.ERROR_C01);
    }
}
