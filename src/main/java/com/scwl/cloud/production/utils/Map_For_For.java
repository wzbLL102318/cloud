package com.wzb.yd.javase;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * map替换双重for循环
 */
public class Map_For_For {

    private Integer id;
    private String name;
    private Integer age;
    private Date addDate;

    /** 无参数构造 */
    public Map_For_For() {
    }

    /** 有参数构造 */
    public Map_For_For(Integer id, String name, Integer age, Date addDate) {
        // 有参构造显示指定父类的构造函数 防止报错 默认调用父类的无参构造函数
        // 如果父类有有参构造，则必须super（）父类的有参构造函数
        super();

        this.id = id;
        this.name = name;
        this.age = age;
        this.addDate = addDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

}


class ForToFor {

    public static void main(String[] args)
            throws InterruptedException {


        /*
        java多态的表现形式
        多态的定义：指允许不同类的对象对同一消息做出响应。即同一消息可以根据发送对象的不同而采用多种不同的行为方式。
        （发送消息就是函数调用）
        List是interface ArrayList实现了List
        List list;是在栈区开辟一个空间放list引用，并没有创建对象所以不知道ArrayList还是LinkedList
        当你list= new ArrayList(); 就创建了ArrayList对象。并且把开始创建的list引用指向这个对象ArrayList
        ArrayList、LinkedList、Vector都是List的实现类

        面向接口编程

        List有多个实现类，如 LinkedList或者Vector等等，现在用的是ArrayList，也许哪一天你需要换成其它的实现类呢？
        这时你只要改变这一行就行了：List list = new LinkedList(); 其它使用了list地方的代码根本不需要改动。
        假设你开始用 ArrayList alist = new ArrayList(), 这下有的改了，特别是如果使用了 ArrayList特有的方法和属性。

        如果没有特别需求的话,最好使用List list = new LinkedList(); ,便于程序代码的重构

        接口的灵活性就在于“规定一个类必须做什么，而不管你如何做"

        多态
        类B和类C是实现接口InterA的两个类，分别实现了InterA接口的方法fun()，通过将类B和类C的实例赋给接口引用a

        实现了方法在运行时的动态绑定，充分利用了“一个接口，多个方法”，展示了Java的动态多态性。

　　     需要注意的一点是：Java在利用接口变量调用其实现类的对象的方法时


         注意接口调用函数时

         该方法必须已经在接口中被声明，而且在接口的实现类中该实现方法的类型和参数必须与接口中所定义的精确匹配。


         */
        List<Map_For_For> list1 = new ArrayList<>();
        List<Map_For_For> list2 = new ArrayList<>();

        for (int i = 0; i < 30000; i++) {
            Date date = new Date();
            list1.add(new Map_For_For((i + 1), "技术客", (i + 1), date));
            if (i % 2 == 0) {
                list2.add(new Map_For_For((i + 1), null, (i + 1), date));
            }
        }

        // 双for循环嵌套测试
        long s1 = System.currentTimeMillis();
        // 统计总数
        int forNumber = 0;

        for (Map_For_For m2 : list2) {
            if (m2.getName() == null) {
                for (Map_For_For m1 : list1) {
                    if (m1.getId().intValue() == m2.getId().intValue()) {
                        forNumber++;
                    }
                }
            }
        }

        long s2 = System.currentTimeMillis();

        System.out.println("双for循环查询时间为：" + (s2 - s1) + "(毫秒)，一共查询出" + forNumber + "条数据 \n\n\n");

        // 睡眠3秒
        TimeUnit.SECONDS.sleep(3);

        //map查询测试
        long s3 = System.currentTimeMillis();

        int mapNumber = 0;

        // map =>> (id,T) Map<String,Object> 优化匹配效率
        Map<Integer, Map_For_For> map = new HashMap<>();

        for (Map_For_For m1 : list1) {
            map.put(m1.getId(), m1);
        }

        for (Map_For_For m2 : list2) {
            if (m2.getName() == null) {
                Map_For_For m = map.get(m2.getId());
                if (m != null) {
                    mapNumber++;
                }
            }
        }

        long s4 = System.currentTimeMillis();

        System.out.println("使用map结构查询时间为：" + (s4 - s3) + "(毫秒)，一共查询出" + mapNumber + "条数据 \n\n\n");
    }

}