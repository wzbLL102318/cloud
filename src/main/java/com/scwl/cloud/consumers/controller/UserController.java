package com.scwl.cloud.consumers.controller;

import com.scwl.cloud.consumers.domain.UserDomain;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Title: 用户管理
 * Description: 对用户资源的增删改查
 *
 * @author weizhibang
 * @created 2018年09月27日
 */
@RestController
@RequestMapping("/cloud_users")
public class UserController {

    /**
     * @description 获取测试DEMO结果
     * @author rico
     * @created 2017年7月4日 下午4:55:13
     * @return
     */
    @RequestMapping(value = "/demo", method = RequestMethod.GET, produces = "application/json")
    public String getUserDemoList() {

        System.out.println("测试http://localhost:8080/cloud_rest/cloud_users/user?id=1");
        return "hello world";
    }
    /**
     * @description 获取指定Id的用户
     * @author rico
     * @created 2017年7月4日 下午4:55:13
     * @param id
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public String getUserPaht(int id) {
        System.out.println("用户ID："+ id);
        return "hello world  user : "+ id;
    }

    /**
     * @description 获取指定Id的用户
     *
     * @PathVariable表示参数将被绑定到变量 URI 模板。
     * 用的是 @RestController 注解，这标志着这个类作为控制器，每一个方法返回域对象pojo代替一个视图。这意味着我们不再使用视图解析器，我们不再直接发送响应的HTML，我们只发送的域对象转换成格式。在我们的例子中，由于 jackson 包含在类路径中，消息对象将转换成JSON格式。
     * @author rico
     * @created 2017年7月4日 下午4:55:13
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public UserDomain getUser(@PathVariable String id) {
        System.out.println("用户ID："+ id);
        UserDomain userDomain = new UserDomain();
        userDomain.setId(Long.valueOf(id));
        userDomain.setAge(12);
        userDomain.setBalance(BigDecimal.valueOf(65.00));
        userDomain.setName("AAAAAAA");
        userDomain.setUsername("wzb");

        return userDomain;
    }
}
