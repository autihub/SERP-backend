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
- [ ] 前端 Vue 3 项目搭建
- [ ] 后端 Spring Boot 项目搭建
- [ ] 数据库表结构设计
- [ ] 本地联调

### 阶段二：生产上云（Tencent Cloud）
- [ ] CVM 环境配置
- [ ] MySQL 8.4 LTS 部署
- [ ] 应用打包部署
- [ ] Nginx 配置
- [ ] 域名 & SSL 配置

## 📁 项目结构

```
山海进销存系统/
├── architecture.html    # 架构设计图
├── PRD.md                # 项目说明书
├── frontend/            # Vue 3 前端
├── backend/             # Java 17 后端
└── README.md
```

## 🔧 本地开发

```bash
# 启动后端
cd backend && ./gradlew bootRun

# 启动前端
cd frontend && npm run dev
```

## 📄 架构图

打开 `architecture.html` 查看完整架构设计（含本地 Mac Mini 和腾讯云双阶段）。

---

> 🏔️ 山海 · 一口刨冰，尽在掌握
