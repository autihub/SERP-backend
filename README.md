# 🏔️ 山海雪冰 Web 进销存系统

面向单店刨冰店的轻量级 Web 进销存管理平台，一期覆盖采购、库存、销售和基础经营分析。

## 🏗️ 技术架构

| 层级 | 技术选型 | 说明 |
|------|---------|------|
| 前端 | Vue 3 + Vite + TypeScript | Composition API, Element Plus |
| 后端 | Java 17 + Spring Boot 3 | REST API, MyBatis-Plus |
| 数据库 | MySQL 8.4 LTS | 自建部署 |
| 反向代理 | Nginx | 静态资源托管 + API 代理 |
| 文件存储 | Tencent Cloud COS | 采购凭证和产品图片 |
| OCR | Tencent Cloud OCR | 采购与有效期识别 |
| 部署 | Tencent Cloud CVM | Nginx + Spring Boot JAR + systemd |

## 📋 阶段计划

### 阶段一：本地开发（Mac Mini）
- [x] 架构设计
- [x] 项目说明书 / PRD
- [x] 前端 Vue 3 项目搭建（仓库：[SERP-frontend](https://github.com/autihub/SERP-frontend)）
- [/] 后端 Spring Boot 项目搭建（代码完成，待本地 Java+MySQL 验证）
- [/] 数据库表结构设计（V1 基础表已建，业务表按迭代追加）
- [ ] 本地联调

### 阶段二：生产上云（Tencent Cloud）
- [ ] CVM 环境配置
- [ ] MySQL 8.4 LTS 部署
- [ ] 应用打包部署
- [ ] Nginx 配置
- [ ] 域名 & SSL 配置

## 📁 项目结构

本仓库为后端工程（前端在独立仓库 [SERP-frontend](https://github.com/autihub/SERP-frontend)）：

```
SERP-backend/
├── PRD.md                          # 项目说明书
├── plan.md                         # 开发计划（P0-P3 + 想法池 + 迭代记录）
├── architecture.html               # 架构设计图
├── build.gradle                    # Spring Boot 3 + Gradle 构建配置
├── settings.gradle
├── gradlew / gradle/wrapper/       # Gradle Wrapper（8.10.2）
├── .env.example                    # 环境变量模板
└── src/
    ├── main/
    │   ├── java/com/shanhai/serp/
    │   │   ├── SerpApplication.java        # 启动类
    │   │   ├── common/api/                 # Result/ResultCode/异常/全局处理
    │   │   ├── common/config/              # Web/CORS 配置
    │   │   └── health/                     # 健康检查
    │   └── resources/
    │       ├── application.yml             # 配置（DB 环境变量 + Flyway + MyBatis-Plus）
    │       └── db/migration/               # Flyway 迁移脚本
    └── test/                               # 单元测试
```

## 🔧 本地开发（后端）

前置：JDK 17、MySQL 8.4（建议用 Homebrew 安装）。

```bash
# 1. 准备数据库
mysql -uroot -p -e "CREATE DATABASE IF NOT EXISTS serp DEFAULT CHARSET utf8mb4;"

# 2. 配置环境变量（按本地实际情况修改）
cp .env.example .env
#   编辑 .env：DB_HOST/DB_PORT/DB_NAME/DB_USER/DB_PASSWORD
export $(grep -v '^#' .env | xargs)

# 3. 启动后端（首次会自动下载 Gradle 8.10.2 并执行 Flyway 迁移建表）
./gradlew bootRun
```

启动后：
- 健康检查：GET http://localhost:8080/api/health → `{ "code":0, "message":"ok", "data":{...} }`
- Actuator：GET http://localhost:8080/api/actuator/health

前端启动见 [SERP-frontend](https://github.com/autihub/SERP-frontend)：`npm run dev`（dev server 代理 /api → http://localhost:8080）。

## 📦 构建

```bash
./gradlew build      # 编译 + 测试 + 打包（build/libs/serp-backend-0.0.1-SNAPSHOT.jar）
./gradlew test       # 仅运行测试
```

## 📄 架构图

打开 `architecture.html` 查看完整架构设计（含本地 Mac Mini 和腾讯云双阶段）。

---

> 🏔️ 山海 · 一口刨冰，尽在掌握
