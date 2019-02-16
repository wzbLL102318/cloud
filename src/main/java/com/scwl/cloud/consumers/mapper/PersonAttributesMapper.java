package com.scwl.cloud.consumers.mapper;

import com.scwl.cloud.consumers.domain.LdapPersonDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.AttributesMapper;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

/**
 * @Author weizhibang
 * @Date 2019-01-28 14:09
 * @VERSION 1.0
 * @Description PersonAttributesMapper : 信息描述
 **/
public class PersonAttributesMapper implements AttributesMapper<LdapPersonDomain> {

    public static Logger logger = LoggerFactory.getLogger(PersonAttributesMapper.class);

    @Override
    public LdapPersonDomain mapFromAttributes(Attributes attributes) throws NamingException {
        LdapPersonDomain person = new LdapPersonDomain();

        logger.info("Mapper cn信息:{}",attributes.get("cn").get());

        person.setPersonName((String)attributes.get("cn").get());

        return person;
    }
}