# SSM整合项目 (myssm_2201)

## 项目简介
基于 Spring + Spring MVC + MyBatis 的员工及用户管理系统，含文件上传下载、验证码登录注册。

## 技术栈
- Spring 5.3.25 + Spring MVC
- MyBatis 3.5.15 + MyBatis-Spring
- Druid 连接池
- MySQL 8.0
- Kaptcha 验证码
- Commons FileUpload
- Log4J 日志

## 功能列表
- 用户注册（含验证码、MD5密码加密）
- 用户登录（含验证码校验）
- 后台管理（员工管理）
- 文件上传 / 下载

## 运行要求
- JDK 8+
- Tomcat 8+
- MySQL 8.0+

## 数据库配置
1. 创建数据库 `db_emp`
2. 执行 `db_emp2.sql`
3. 修改 `src/main/resources/db.properties` 中的数据库连接信息

## 构建部署
```bash
mvn clean package
```
将生成的 `target/mybatisspring.war` 部署到 Tomcat
