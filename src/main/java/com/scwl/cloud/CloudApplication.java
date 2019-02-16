package com.scwl.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;

/**
 * spring boot 服务启动类
 *
 * @author weizhibang
 * @date 2018/10/31
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableLdapRepositories
public class CloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudApplication.class, args);
    }
}
