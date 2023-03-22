# yunNoteBlog

**yunNoteBlog**是一个基于Java开发的个人博客系统。

## 功能特点

- 支持Markdown编辑器
- 支持文章分类、标签管理
- 支持评论功能
- 支持用户认证和授权

## 技术栈

- 前端：HTML、CSS、JavaScript、Bootstrap、jQuery
- 后端：Spring Boot、MyBatis、Thymeleaf、Redis、MySQL
- 开发工具：IntelliJ IDEA、Visual Studio Code、Navicat

## 快速开始

### 环境要求

- JDK 1.8+
- Maven 3.2+
- MySQL 5.7+
- Redis 3.2+

### 克隆代码

```
git clone https://github.com/jasonlius/yunNoteBlog.git
```

### 运行项目

1. 在MySQL中创建数据库，并导入`db/mysql.sql`中的SQL脚本。
2. 修改`src/main/resources/application.yml`中的数据库和Redis连接配置。
3. 在项目根目录下执行以下命令：

```
mvn spring-boot:run
```

4. 打开浏览器，访问`http://localhost:8080`即可查看博客系统。

## 文档

- [API文档](doc/API.md)
- [数据库设计文档](doc/database.md)

## 贡献

欢迎贡献代码，提交PR或者Issue。

## 许可证

本项目基于MIT许可证发布。