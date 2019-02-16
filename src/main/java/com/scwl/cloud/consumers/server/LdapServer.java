package com.scwl.cloud.consumers.server;

import com.scwl.cloud.consumers.domain.LdapPersonDomain;
import org.springframework.ldap.core.LdapTemplate;

import java.util.List;

/**
 * @Author weizhibang
 * @Date 2019-01-28 11:34
 * @VERSION 1.0
 * @Description LdapServer : 信息描述
 **/
public interface LdapServer {

    /**
     * LdapTemplate
     * @param ldapTemplate
     */
    void setLdapTemplate(LdapTemplate ldapTemplate);

    List<String> getAllPersonNames();

    List<String> getAllPersonNamesWithTraditionalWay();

    List<LdapPersonDomain> getAllPersons();

    LdapPersonDomain findPersonWithDn(String dn);

    List<String> getPersonNamesByOrgId(String orgId);
}
