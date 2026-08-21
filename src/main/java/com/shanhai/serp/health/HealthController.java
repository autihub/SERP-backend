package com.shanhai.serp.health;

import com.shanhai.serp.common.api.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 健康检查接口（P0-02 验收）。
 *
 * <p>完整路径：GET /api/health（context-path = /api）。
 * 也可使用 Spring Boot Actuator：GET /api/actuator/health。
 */
@RestController
public class HealthController {

    @GetMapping("/health")
    public Result<Map<String, Object>> health() {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("status", "UP");
        data.put("service", "serp-backend");
        data.put("time", Instant.now().toString());
        return Result.ok(data);
    }
}
