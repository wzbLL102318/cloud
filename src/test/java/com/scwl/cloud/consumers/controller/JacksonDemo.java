package com.scwl.cloud.consumers.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scwl.cloud.consumers.domain.UserDomain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JacksonDemo {


    public static Logger logger = LoggerFactory.getLogger(JacksonDemo.class);

    @Test
    public void jackSonTest() throws IOException {
        UserDomain user = new UserDomain();
        user.setName("小民");
        user.setAge(20);

        /**
         * JSON 封装 - 依赖一下核心API
         *
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         *
         *
         * JSON注解
         * Jackson提供了一系列注解，方便对JSON序列化和反序列化进行控制，下面介绍一些常用的注解。
         * @JsonIgnore 此注解用于属性上，作用是进行JSON操作时忽略该属性。
         * @JsonFormat 此注解用于属性上，作用是把Date类型直接转化为想要的格式，如@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")。
         * @JsonProperty 此注解用于属性上，作用是把该属性的名称序列化为另外一个名称，如把trueName属性序列化为name，@JsonProperty("name")。 
         */
        ObjectMapper mapper = new ObjectMapper();

        //User类转JSON 
        //输出结果：{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"} 
        String json = mapper.writeValueAsString(user);

        logger.info(json);

        //Java集合转JSON 
        //输出结果：[{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}] 
        List<UserDomain> users = new ArrayList<UserDomain>();
        users.add(user);

        String jsonlist = mapper.writeValueAsString(users);
        logger.info(jsonlist);


       // String jsonUser = "{\"name\":\"小民\",\"age\":20,\"username\":844099200000}";

        String jsonUser = "{\"name\":\"小民\",\"age\":20}";

        /**
         * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
         */
        UserDomain userJson = mapper.readValue(jsonUser, UserDomain.class);
        logger.info(userJson.toString());


        logger.info("equals:{}",user.equals(userJson));

        logger.info("====:{}",user.hashCode());
        logger.info("====:{}",userJson.hashCode());


    }

    @Test
    public void contextLoads() {
        logger.info("I am trace log.");
        logger.debug("I am debug log.");
        logger.warn("I am warn log.");
        logger.error("I am error log.");
    }

}
