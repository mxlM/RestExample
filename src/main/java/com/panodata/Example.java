package com.panodata;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 注意：
 * 1：Pom文件中  groupId  配置的内容为  com.panodata   所以启动类函数必须配置于该目录下
 *
 * 2：Pom文件中  mainClass 配置内容为    com.panodata.Example   所以整个程序的启动类为 Example
 *
 * 3：spring boot 遵循规约大于配置原则,所以,应用中所有其他功能性类/配置/目录 必须位于groupId  配置的目录  com.panodata 下才能生效，且不能和Example为同级目录
 *
 * 4：resources 目录下存在application.properties 配置文件，该文件是应用启动时的默认配置文件,应用启动时会读取该配置文件中的内容对当前启动的服务进行初始化配置
 *
 * 5: resources 目录下同时还存在application-dev.properties  /  application-prod.properties   /  application-test.properties  三个配置文件
 * 分别为  开发环境/生产环境/测试环境   的基本配置   默认不生效
 *
 * 6: resources 目录下存在application.properties 配置中一般仅配置一句话  spring.profiles.active=dev   其中  =  号前面为参数名称 ,  = 号后面为参数值
 * dev 代表通知应用在加载配置文件时去加载开发环境配置文件application-dev.properties   一般不做修改,生产环境或测试环境中启动时使用另外方案，下文会有介绍
 *
 * 7: 应用在开发期间，直接运行以下main函数即可，无需单独配置tomcat服务器,如需debug应用，请以debug Run 方式运行
 *
 * 8: 该应用使用 maven 方式打包 请自行在各自本机安装maven环境，并配置上公司私服，联系我就可以
 *
 * 9: maven 打包该应用指令为 mvn clean install -Dmaven.test.skip=true   , 请使用ide打包或着在当前项目文件夹下与pom同级执行该指令
 * 打包成功之后会生成target 目录,该目录下存在与pom文件中artifactId配置的属性同名的jar文件，本示例中为RestExample.jar,   该文件就是生产或测试环境需要部署的文件
 *
 * 10: spring boot 服务部署jar包文件同样不需要配置tomcat服务器
 *
 * 11：spring boot 服务部署过程中，配置属性的优先级为 ： 指令行>配置文件>编码
 *
 * 12：spring boot 服务打包所生成的jar包部署指令为：
 * nohup java  -jar /home/weihu/app/test/v3/dr/Drainage.jar  --spring.profiles.active=test --server.port=50013 > /home/weihu/app/test/v3/dr/info.log 2>&1  &
 * 解释如下： nohup ******* &            linux 中后台运行
 *           java -jar  ****.jar        启动指定jar服务
 *           -Xmx -Xms -Xmn -Xss -XX    等，均为jvm优化部分,不添加的话会使用默认配置，足够满足绝大多数情况,如需个性化定制请添加在java  和  -jar  中间
 *           --spring.profiles.active=  根据等号后面的值确定具体读取哪个环境的配置文件
 *           --server.port=             根据等号后面的值确定服务启动时具体监听哪个端口
 *           > /home/weihu/app/test/v3/dr/info.log 2>&1   linux指令,将该应用输出的内容重定向到指定文件中
 *
 * 13：创建包时请遵循  以英文命名，见字达意,包名全小写
 *
 * 14: 创建类的时候请遵循 以英文命名，见字达意，类名首字母大写，驼峰式
 *
 * Created by wp_sp on 2017/9/21.
 */
@SpringBootApplication //spring boot 指定启动类注解
@EnableScheduling //spring boot 开启定时任务可用
public class Example {

    private static Logger logger = Logger.getLogger(Example.class);  //log4j 日志配置

    /**
     * spring boot 启动函数
     * @param args
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(Example.class).web(true).run(args);
        logger.info("应用启动时间为----------" + System.currentTimeMillis());
    }


}
