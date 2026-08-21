package com.shanhai.serp.common.api;

import lombok.Getter;

/**
 * 统一错误码。
 *
 * <p>约定：code == 0 表示成功；其余为错误码。前端拦截器将 code != 0 且 != 200 视为失败。
 * 错误码尽量与 HTTP 状态对齐，便于排查：400/401/403/404/500，业务错误用 9xx 段。
 */
@Getter
public enum ResultCode {

    SUCCESS(0, "ok"),

    PARAM_ERROR(400, "参数错误"),
    UNAUTHORIZED(401, "未登录或登录已过期"),
    FORBIDDEN(403, "无权限"),
    NOT_FOUND(404, "资源不存在"),

    BUSINESS_ERROR(900, "业务处理失败"),
    SERVER_ERROR(500, "服务器内部错误");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
