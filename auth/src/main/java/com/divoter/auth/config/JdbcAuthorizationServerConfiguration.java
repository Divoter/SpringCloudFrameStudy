package com.divoter.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @ClassName AuthorizationServerConfiguration
 * @Description
 * @Authour Divoter
 * @Date 2020/9/28 14:53
 * @Version 1.0
 */
@Configuration
@EnableAuthorizationServer
public class JdbcAuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    /**
     * 配置数据源
     * @return
     */
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 设置token数据源
     * @return
     */
    @Bean
    public TokenStore tokenStore(){
        return new JdbcTokenStore(dataSource());
    }

    /**
     * 设置client数据源
     * @return
     */
    @Bean
    public ClientDetailsService jdbcClientDetails(){
        return new JdbcClientDetailsService(dataSource());
    }

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置认证客户端
        // 配置client数据源
        clients.withClientDetails(jdbcClientDetails());


    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 配置token数据源 内存模式不需要
        endpoints.tokenStore(tokenStore());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        // 设置 uri: /oauth/check_token 可以通过访问
        security.checkTokenAccess("permitAll()");
    }
}
