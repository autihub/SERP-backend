package com.shanhai.serp.common.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Result 统一返回结构单测（纯单测，不依赖 Spring 上下文与数据库）。
 */
class ResultTest {

    @Test
    void okShouldFillSuccessCodeAndData() {
        Result<String> r = Result.ok("hello");
        assertEquals(0, r.getCode());
        assertEquals("ok", r.getMessage());
        assertEquals("hello", r.getData());
    }

    @Test
    void okWithoutDataShouldHaveNullData() {
        Result<Void> r = Result.ok();
        assertEquals(0, r.getCode());
        assertNull(r.getData());
    }

    @Test
    void failShouldFillCodeAndMessage() {
        Result<Void> r = Result.fail(ResultCode.PARAM_ERROR, "数量不能为空");
        assertEquals(400, r.getCode());
        assertEquals("数量不能为空", r.getMessage());
    }

    @Test
    void businessExceptionShouldKeepCode() {
        BusinessException e = new BusinessException(ResultCode.NOT_FOUND, "采购单不存在");
        assertEquals(404, e.getCode());
        assertEquals("采购单不存在", e.getMessage());
    }
}
