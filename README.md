# SSM 员工与用户管理系统（myssm_2201）

> Spring + Spring MVC + MyBatis 整合实战（含验证码登录注册、文件上传下载）

## 📖 项目简介

`myssm_2201` 是一个经典的 **SSM（Spring + Spring MVC + MyBatis）** Web 项目，实现了用户注册 / 登录（含 Kaptcha 验证码与 MD5 密码加密）、员工信息后台管理，以及文件上传下载等功能，是学习 SSM 分层架构与整合流程的完整示例。

## ✨ 功能特性

- **用户注册**：验证码校验 + MD5 密码加密后入库
- **用户登录**：验证码校验 + 账号密码认证
- **后台管理**：员工信息（`Emp`）的增删改查
- **文件上传 / 下载**：基于 Commons FileUpload
- **日志**：Log4J 统一日志
- **连接池**：Alibaba Druid

## 🛠 技术栈

| 组件 | 版本 |
|------|------|
| Spring / Spring MVC | 5.3.25 |
| MyBatis | 3.5.15 |
| mybatis-spring | 2.0.4 |
| MySQL Connector/J | 8.0.33 |
| Druid | 1.2.23 |
| Log4j | 1.2.17 |
| JUnit | 4.12 |
| JDK / 编译级别 | 8 |

> 打包方式为 `war`，`groupId: com.bigdata`，`artifactId: myssm_2201`。

## 📂 目录结构

```
myssm_2201/
├── db_emp2.sql                      # 建库建表脚本
├── pom.xml
└── src/main/
    ├── java/com/bigdata/
    │   ├── controller/              # Login / Regist / Manager / Index / FileLoad
    │   ├── dao/                     # EmpDao、UserDao
    │   ├── entity/                  # Emp、User
    │   ├── service/ + impl/         # UserService / UserServiceImpl
    │   └── utils/
    ├── resources/
    │   ├── applicationContext.xml   # Spring 主配置
    │   ├── springmvc.xml            # Spring MVC 配置
    │   ├── db.properties            # 数据库连接配置
    │   └── mapper/                  # EmpDaoMapper.xml、UserDaoMapper.xml
    └── webapp/                      # 静态资源与页面
```

## 🚀 快速开始

```bash
# 1. 创建数据库并导入结构
mysql -u root -p -e "CREATE DATABASE db_emp DEFAULT CHARSET utf8mb4;"
mysql -u root -p db_emp < db_emp2.sql

# 2. 修改数据库连接
#    编辑 src/main/resources/db.properties

# 3. 打包
mvn clean package

# 4. 部署
#    将 target/mybatisspring.war 放入 Tomcat 8+ 的 webapps/ 目录后启动
```

访问 `http://localhost:8080/mybatisspring/`。

## ⚠️ 说明

- 运行环境：JDK 8+、Tomcat 8+、MySQL 8.0+。
- 请勿把 `db.properties` 中的真实数据库口令提交到公开仓库。
