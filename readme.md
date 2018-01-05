[toc]
### 概要


### 概况
#### maven作为包管理
##### Junit包
作为单元测试
[JUnit单元测试--IntelliJ IDEA](https://www.cnblogs.com/huaxingtianxia/p/5563111.html)

##### c3p0
作为数据库连接池 需要
> 1. 项目开工需要远程数据库
> 1. 配置文件位于resource中选定的xml文件里[解决IntelliJ IDEA无法读取配置文件的问题](https://www.cnblogs.com/Sinte-Beuve/p/5730572.html)
> 1. 注意点： 
>> 1. spring中的org.springframework.jdbc.core.JdbcTemplate作为实际上的操作对象
>> 2. c3p0配置完成够仅仅作为数据源.
>> 3. 数据库相关的操作可以在单元测试中进行
            
##### 考虑是否需要添加  log4日志管理
         
#####  spring
导入相关的依赖

#### spring中的事件机制
[spring mvc入门介绍的博客](https://www.cnblogs.com/sunniest/p/4555801.html)

[JAVA中Action层, Service层 ，modle层 和 Dao层的功能区分](http://blog.csdn.net/limuzi13/article/details/44968819)
[JdbcTemplate类](https://www.cnblogs.com/wanggd/p/3140506.html)
#### 进度
基本的环境配置完成，写了一个测试增加用户的demo单元测试

