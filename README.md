# demoCMS

边学SpringMVC边写着玩的。

## 部署
1.配置数据库，修改application.properties

    CREATE DATABASE demoCMS CHARSET utf8mb4 COLLATE utf8mb4_general_ci;

    CREATE TABLE users (
    id LONG AUTO_INCREMENT NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(256) NOT NULL
    );

2.在项目根目录启动服务

    gradle bootRun

## 接口

/user

GET传参{id}，查询用户

/user/login

POST传参{username}{password}，用户登陆

/user/register

POST传参{username}{password}，用户注册
