package com.panodata.conf.tomcat;

import com.panodata.interceptor.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * 配置spring boot 响应的部分
 * Created by wp_sp on 2017/5/23.
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //设置public目录下全部文件缓存时长为1天
        registry.addResourceHandler("/**").addResourceLocations("classpath:/public/").setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS).cachePublic());
        //配置dr_files_images目录可以被直接访问 并且代理到服务器目录e:/roncoo/ttt/   下   ,  缓存一天
        registry.addResourceHandler("/dr_files_images/**").addResourceLocations("file:e:/roncoo/ttt/").setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS).cachePublic());
        super.addResourceHandlers(registry);
    }

    /**
     * 配置拦截器
     *
     * @param registry
     * @author lance
     */
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器链路
//        //token拦截
//        registry.addInterceptor(new ApiTokenInterceptor())
//                .addPathPatterns("/api/*/**");
//        //黑白名单拦截
//        registry.addInterceptor(new BlacklistInterceptor())
//                .addPathPatterns("/api/**");
//        //接口访问权限拦截
//        registry.addInterceptor(new AccessInterceptor())
//                .addPathPatterns("/api/**");
        //web拦截
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/web/**");
//        //授权
//        registry.addInterceptor(new BaseInterceptor())
//                .addPathPatterns("/base/auth/token");
//        //其他请求直接返回
        registry.addInterceptor(new OtherInterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns("/api/*/**")
        .excludePathPatterns("/web/**")
        .excludePathPatterns("/base/authToken");
    }
}
