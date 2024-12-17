# 数据分析平台

持续优化中 使用账号admin,88888888

ps.没有多少tokens了,悠着点用
## 使用技术

SpringBoot初始化化模板

### 主流框架&特性

- Spring Boot 2.7.x + Java 8
- Spring MVC
- MyBatis X + MyBatis Plus 数据访问（开启分页）
- Spring Boot 调试工具和项目处理器
- Spring AOP 切面编程
- Spring Scheduler 定时任务
- Spring 事务注解

### 数据存储

- MySQL 8.0+ 数据库
- Redis 5 内存数据库
  
### 中间件

- 讯飞星火 AI
- RabbitMQ 3.12.0 消息队列（官网示例 https://www.rabbitmq.com/tutorials）

### 工具类

- Easy Excel 表格处理
- Hutool 工具库
- Apache Commons Lang3 工具类
- Lombok 注解

### 业务特性

- 业务代码生成器（支持自动生成 Service、Controller、数据模型代码）
- Spring Session Redis 分布式登录
- 全局请求响应拦截器（记录日志）
- 全局异常处理器
- 自定义错误码
- 封装通用响应类
- Swagger + Knife4j 接口文档
- 自定义权限注解 + 全局校验
- 全局跨域处理
- 长整数丢失精度解决
- 多环境配置
  
## 实现的业务功能

- 用户登录、注册、注销、更新、检索、权限管理
- 图表创建、删除、编辑、更新、数据库检索
- 图表同步智能分析
- 图表异步智能分析（自定义线程池实现方式）
- 图表异步智能分析（RabbitMQ消息队列实现方式）
- 支持excel文件上传

### 单元测试

- JUnit5 单元测试

```java  
/**
 * 用户服务测试
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void userRegister() {
        String userAccount = "sun";
        String userPassword = "";
        String checkPassword = "123456";
        try {
            long result = userService.userRegister(userAccount, userPassword, checkPassword);
            Assertions.assertEquals(-1, result);
            userAccount = "sun";
            result = userService.userRegister(userAccount, userPassword, checkPassword);
            Assertions.assertEquals(-1, result);
        } catch (Exception e) {

        }
    }
}
```

### 架构设计

- 合理分层

### 流程图

消息队列
![image](https://github.com/user-attachments/assets/2273daa1-fd93-44c5-8e83-e28685beaaca)

自定义线程池
![image](https://github.com/user-attachments/assets/12a508cd-9b29-4c0f-acfd-4e2b926d1524)



## 快速上手


### MySQL 数据库
1）修改 `application.yml` 的数据库配置为你自己的：

```yml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/my_db
    username: root
    password: 123456
```

2）执行 `sql/create_table.sql` 中的数据库语句，自动创建库表

3）启动项目，访问 `http://localhost:8101/api/doc.html` 即可打开接口文档

### Redis 分布式登录

1）修改 `application.yml` 的 Redis 配置为你自己的：

```yml
spring:
  redis:
    database: 1
    host: localhost
    port: 6379
    timeout: 5000
    password: 123456
```

2）修改 `application.yml` 中的 session 存储方式：

```yml
spring:
  session:
    store-type: redis
```

3）移除 `MainApplication` 类开头 `@SpringBootApplication` 注解内的 exclude 参数：

修改前：

```java
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
```

修改后：


```java
@SpringBootApplication
```

### RabbitMQ 消息队列

1）修改 `application.yml` 的 Redis 配置为你自己的：

```yml
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
```

### 业务代码生成器

支持自动生成 Service、Controller、数据模型代码，配合 MyBatisX 插件，可以快速开发增删改查等实用基础功能。

找到 `generate.CodeGenerator` 类，修改生成参数和生成路径，并且支持注释掉不需要的生成逻辑，然后运行即可。

```
// 指定生成参数
String packageName = "com.sun.springbootinit";
String dataName = "用户评论";
String dataKey = "userComment";
String upperDataKey = "UserComment";
```
