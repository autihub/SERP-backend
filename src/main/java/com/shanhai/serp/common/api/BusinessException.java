package com.shanhai.serp.common.api;

import lombok.Getter;

/**
 * 业务异常。Service 层抛出后由 {@link GlobalExceptionHandler} 统一转成 Result。
 */
@Getter
public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(ResultCode rc) {
        super(rc.getMessage());
        this.code = rc.getCode();
    }

    public BusinessException(ResultCode rc, String message) {
        super(message);
        this.code = rc.getCode();
    }

    public BusinessException(String message) {
        super(message);
        this.code = ResultCode.BUSINESS_ERROR.getCode();
    }
}
