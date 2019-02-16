package com.scwl.cloud.consumers.controller;

import com.scwl.cloud.consumers.domain.LdapPersonDomain;
import com.scwl.cloud.consumers.server.impl.LdapServerImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author weizhibang
 * @Date 2019-01-28 14:20
 * @VERSION 1.0
 * @Description LdapTest : 信息描述
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LdapTest {

    @Autowired
    private LdapTemplate ldapTemplate;

    private LdapServerImpl ldapServer;

    @Before
    public void init(){
        ldapServer = new LdapServerImpl();
        ldapServer.setLdapTemplate(ldapTemplate);
    }

    public static Logger logger = LoggerFactory.getLogger(LdapTest.class);

    @Test
    public void ldapTest(){
        logger.info("ldap  连接测试");
        LdapPersonDomain ldapPersonDomain = ldapServer.findPersonWithDn("uid=admin,ou=People,dc=phjr,dc=com");

        logger.info("ldap 查询:{}",ldapPersonDomain.toString());


    }

}