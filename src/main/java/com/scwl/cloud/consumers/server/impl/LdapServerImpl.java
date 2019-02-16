package com.scwl.cloud.consumers.server.impl;

import com.scwl.cloud.consumers.domain.LdapPersonDomain;
import com.scwl.cloud.consumers.mapper.PersonAttributesMapper;
import com.scwl.cloud.consumers.server.LdapServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.NameNotFoundException;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * @Author weizhibang
 * @Date 2019-01-28 14:02
 * @VERSION 1.0
 * @Description LdapServerImpl : ldap增删改查实现类
 **/
public class LdapServerImpl implements LdapServer {

    private LdapTemplate ldapTemplate;

    public static Logger logger = LoggerFactory.getLogger(LdapServerImpl.class);
    @Override
    public void setLdapTemplate(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    /**
     * 查询部分字段集合
     * @return
     */
    @Override
    public List<String> getAllPersonNames() {
        return ldapTemplate.search(
                query().where("objectclass").is("person"), (AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());
    }

    /**
     * 传统LDAP查询方式
     * @return
     */
    @Override
    public List<String> getAllPersonNamesWithTraditionalWay() {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://x.x.x.x:7003/dc=platform,dc=xxx,dc=com");
        env.put(Context.SECURITY_PRINCIPAL, "ou=xxx,ou=componentaccounts,dc=platform,dc=xxx,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "UlAwRkYl");
        DirContext ctx;
        try {
            ctx = new InitialDirContext(env);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        List<String> list = new LinkedList<String>();
        NamingEnumeration results = null;
        try {
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            results = ctx.search("", "(objectclass=person)", controls);
            while (results.hasMore()) {
                SearchResult searchResult = (SearchResult) results.next();
                Attributes attributes = searchResult.getAttributes();
                Attribute attr = attributes.get("cn");
                String cn = attr.get().toString();
                list.add(cn);
            }
        } catch (NameNotFoundException e) {
            // The base context was not found.
            // Just clean up and exit.
        } catch (NamingException e) {
            //throw new RuntimeException(e);
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (Exception e) {
                    // Never mind this.
                }
            }
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception e) {
                    // Never mind this.
                }
            }
        }
        return list;
    }

    /**
     * 查询对象映射集合
     * @return
     */
    @Override
    public List<LdapPersonDomain> getAllPersons() {
        return ldapTemplate.search(query()
                .where("objectclass").is("person"), new PersonAttributesMapper());
    }

    /**
     * 根据DN查询指定人员信息
     * @param dn
     * @return
     */
    @Override
    public LdapPersonDomain findPersonWithDn(String dn) {

        logger.info("ldap 数据DN:{}",dn);
        return (LdapPersonDomain)ldapTemplate.lookup(dn);
                //.lookup(dn, new PersonAttributesMapper());
    }

    /**
     * 组装查询语句
     * @param orgId
     * @return
     */
    @Override
    public  List<String> getPersonNamesByOrgId(String orgId) {
        LdapQuery query = query()
                .base("ou=person,dc=coreservice")
                .attributes("cn", "sn")
                .where("objectclass").is("person")
                .and("orgId").is(orgId);
        return ldapTemplate.search(query,(AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());
    }
}