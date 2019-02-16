package com.scwl.cloud.consumers.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;

/**
 * @Author weizhibang
 * @Date 2019-01-28 11:09
 * @VERSION 1.0
 * @Description LdapPersonDomain : 信息描述
 **/


@Data
@ToString
@Entry(base = "dc=phjr,dc=com", objectClasses = {"organizationalPerson", "person", "top"})
public class LdapPersonDomain {
    /**
     * 主键
     */
    @Attribute
    private String personId;

    /**
     * 人员姓名
     */
    @Attribute(name = "uid")
    private String personUid;

    /**
     * CN
     */
    @Attribute(name = "cn")
    private String personCn;

    /**
     * 人员姓名
     */
    @Attribute(name = "sn")
    private String personName;

    /**
     * 邮箱
     */
    @Attribute(name = "email")
    private String email;

    /**
     * 工号
     */
    @Attribute(name = "uidNumber")
    private String personUidNumber;

    /**
     * home目录
     */
    @Attribute(name = "homeDirectory")
    private String homeDirectory;

    /**
     * groupNumber
     */
    @Attribute(name = "gidNumber")
    private String personGidNumber;

    /**
     * groupNumber
     */
    @Attribute(name = "result")
    private String result;
}