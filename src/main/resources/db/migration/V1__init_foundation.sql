-- =====================================================================
-- V1__init_foundation.sql
-- 山海雪冰进销存系统 · 基础表（用户 + 操作日志）
-- ---------------------------------------------------------------------
-- 业务表（商品/供应商/采购/库存/销售 等）按迭代在 V2、V3... 逐步追加，
-- 不在本初始化脚本中一次性建齐，保持与 plan.md 迭代节奏一致。
-- =====================================================================

-- 用户表（店主/店长/店员）
CREATE TABLE `sys_user` (
    `id`            BIGINT       NOT NULL AUTO_INCREMENT,
    `username`      VARCHAR(64)  NOT NULL COMMENT '登录名',
    `password_hash` VARCHAR(128) NOT NULL COMMENT '加密密码（BCrypt）',
    `role`          VARCHAR(32)  NOT NULL DEFAULT 'STAFF' COMMENT 'OWNER 店主 / MANAGER 店长 / STAFF 店员',
    `name`          VARCHAR(64)           DEFAULT NULL COMMENT '姓名',
    `status`        TINYINT      NOT NULL DEFAULT 1 COMMENT '1 启用 / 0 停用',
    `deleted`       TINYINT      NOT NULL DEFAULT 0 COMMENT '逻辑删除：1 已删除 / 0 正常',
    `created_at`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_username` (`username`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='用户';

-- 操作日志表
CREATE TABLE `operation_log` (
    `id`         BIGINT       NOT NULL AUTO_INCREMENT,
    `user_id`    BIGINT                DEFAULT NULL COMMENT '操作人ID',
    `module`     VARCHAR(64)  NOT NULL COMMENT '模块：采购/库存/销售/用户等',
    `action`     VARCHAR(64)  NOT NULL COMMENT '操作：CREATE/UPDATE/DELETE/LOGIN等',
    `target`     VARCHAR(128)          DEFAULT NULL COMMENT '操作目标',
    `detail`     TEXT                  DEFAULT NULL COMMENT '详情(JSON)',
    `ip`         VARCHAR(64)           DEFAULT NULL,
    `created_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_user` (`user_id`),
    KEY `idx_created` (`created_at`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='操作日志';
