package com.panodata.conf.response;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wp_sp on 2017/3/24.
 */
public class RestResultGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestResultGenerator.class);

    /**
     * 生成响应成功(带正文)的结果
     *
     * @param data    结果正文
     * @param responseSuccessEnum 成功提示信息
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> genResult(T data, ResponseSuccessEnum responseSuccessEnum) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setSuccess(true);
        result.setResult(data);
        result.setMessage(responseSuccessEnum.getName());
        result.setCode(responseSuccessEnum.getIndex());
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("--------> result:{}", JSON.toJSONString(result));
        }
        return result;
    }

    /**
     * 生成响应失败(带errorCode)的结果
     *
     * @param responseErrorEnum 失败信息
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> genErrorResult(ResponseErrorEnum responseErrorEnum) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setSuccess(false);
        result.setErrorInfo(responseErrorEnum);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("--------> result:{}", JSON.toJSONString(result));
        }
        return result;
    }

}