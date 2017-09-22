package com.panodata.conf.database;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * Configuration  这个注解相当与  传统 spring mvc 中 xml 配置文件中的  <beans></beans> 标签   ，通俗的讲就是 类上面有了这个注解就说明这是一个配置类
 * EnableTransactionManagement   顾名思义   事物管理托付
 * MapperScan  使用mybatis  需要指定 mapper类和方法所在目录，这个可以配置多个目录：@MapperScan(basePackages = {"com.panodata.metadata.dao.mapper", "com.panodata.backstagemanagement.mapper"})
 * Value 注解过可以通过括号后的K  在配置文件中获取相应的值
 * Bean 注解就相当于 传统 spring mvc 中 xml 配置文件中的  <bean></bean> 标签 ,通俗的说就是  将一个类托付于spring 容器做管理
 *
 * Created by wp on 2017/2/26.
 */
@Configuration
@EnableTransactionManagement
@MapperScan(value = "com.panodata.mapper")
public class DatabaseConfiguration {
//    private Environment environment;
//    private RelaxedPropertyResolver propertyResolver;

//    @Override
//    public void setEnvironment(Environment environment) {
//        this.environment = environment;
//        this.propertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
//    }

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.initialSize}")
    private String initialSize;
    @Value("${spring.datasource.minIdle}")
    private String minIdle;
    @Value("${spring.datasource.maxActive}")
    private String maxActive;
    @Value("${spring.datasource.maxWait}")
    private String maxWait;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private String timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private String minEvictableIdleTimeMillis;
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.testWhileIdle}")
    private String testWhileIdle;
    @Value("${spring.datasource.testOnBorrow}")
    private String testOnBorrow;
    @Value("${spring.datasource.testOnReturn}")
    private String testOnReturn;
    @Value("${spring.datasource.poolPreparedStatements}")
    private String poolPreparedStatements;
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private String maxPoolSize;
    @Value("${spring.datasource.connectionProperties}")
    private String connectionProperties;
    @Value("${spring.datasource.filters}")
    private String filters;


    //注册dataSource
    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() throws SQLException {
        if (StringUtils.isEmpty(url)) {
            throw new ApplicationContextException(
                    "Database connection pool is not configured correctly");
        }
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(Integer.parseInt(initialSize));
        druidDataSource.setMinIdle(Integer.parseInt(minIdle));
        druidDataSource.setMaxActive(Integer.parseInt(maxActive));
        druidDataSource.setMaxWait(Integer.parseInt(maxWait));
        druidDataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(timeBetweenEvictionRunsMillis));
        druidDataSource.setMinEvictableIdleTimeMillis(Long.parseLong(minEvictableIdleTimeMillis));
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(Boolean.parseBoolean(testWhileIdle));
        druidDataSource.setTestOnBorrow(Boolean.parseBoolean(testOnBorrow));
        druidDataSource.setTestOnReturn(Boolean.parseBoolean(testOnReturn));
        druidDataSource.setPoolPreparedStatements(Boolean.parseBoolean(poolPreparedStatements));
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(maxPoolSize));
        druidDataSource.setFilters(filters);
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        //mybatis分页
        PageHelper pageHelper = new PageHelper();
        Properties props = new Properties();
        props.setProperty("dialect", "mysql");
        props.setProperty("reasonable", "true");
        props.setProperty("supportMethodsArguments", "true");
        props.setProperty("returnPageInfo", "check");
        props.setProperty("params", "count=countSql");
        pageHelper.setProperties(props); //添加插件
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/com/panodata/metadata/dao/xml/*.xml"));
//        cloud-metadata-mapper-1.0.0.jar\com\didispace\metadata\dao\xml - ZIP 压缩文件, 解包大小为 924,494 字节
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}