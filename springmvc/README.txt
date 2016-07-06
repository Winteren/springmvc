springmvc + mybatis 的一个基于 maven 的小demo

访问 url：http://localhost/user/getAllUser.json

调用栈 controller --> service --> manager --> dao

controller 层：返回json数据 或者页面跳转
service 层：逻辑处理层，做缓存等
manager 层：做事务处理
dao 层：只有接口没有实现类

数据库建表语句在：..\WEB-INF\sql\init.sql 文件中

只是一个小 demo 实现了 基本的增删改查功能，包括批量处理，以及添加本地缓存的功能。

如有错误请指正，谢谢。