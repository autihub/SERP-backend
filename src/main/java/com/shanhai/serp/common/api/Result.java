package com.shanhai.serp.common.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * 统一返回结构。
 *
 * <p>前端约定：{@code { "code": 0, "message": "ok", "data": {} }}。
 * code 为 0 或 200 视为成功，其余由全局拦截器弹出错误。
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {

    private int code;
    private String message;
    private T data;
    private long timestamp;

    private Result() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> Result<T> ok() {
        return ok(null);
    }

    public static <T> Result<T> ok(T data) {
        Result<T> r = new Result<>();
        r.code = ResultCode.SUCCESS.getCode();
        r.message = ResultCode.SUCCESS.getMessage();
        r.data = data;
        return r;
    }

    public static <T> Result<T> fail(ResultCode rc) {
        return fail(rc.getCode(), rc.getMessage());
    }

    public static <T> Result<T> fail(ResultCode rc, String message) {
        return fail(rc.getCode(), message);
    }

    public static <T> Result<T> fail(int code, String message) {
        Result<T> r = new Result<>();
        r.code = code;
        r.message = message;
        return r;
    }
}
