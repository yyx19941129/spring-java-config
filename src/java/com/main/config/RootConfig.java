package com.main.config;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *<p>Title: RootConfig.java</p>
 *<p>Description: 配置类，用于管理ContextLoadListener创建的上下文的bean</p>
 *<p>CreateDate: 2017年6月12日</p>
 *@author shen
 *@version v1.0
 */
@Configuration
@Import(DataSourceConfig.class)
public class RootConfig {

    @Bean
    public BeanNameAutoProxyCreator proxycreate(){
        BeanNameAutoProxyCreator proxycreate = new BeanNameAutoProxyCreator();
        proxycreate.setProxyTargetClass(true);
        proxycreate.setBeanNames("*Service");
        proxycreate.setInterceptorNames("transactionInterceptor");
        return proxycreate;
    }
}