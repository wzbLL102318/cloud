package com.wzb.yd.javase;

/**
 *
 *
 * final 关键字
 *
 */
public class Final_JAVA {
    /**
      ==
      A：基本数据类型 则比较他们的值
      B：是引用类型 则比较的是内存中的地址

      equals
      equals方法不能作用于基本数据类型的变量，equals继承Object类，比较的是是否是同一个对象

　　　　如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；

　　　　诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容

       static方法就是没有this的方法。在static方法内部不能调用非静态方法，反过来是可以的。
       而且可以在没有创建任何对象的前提下，仅仅通过类本身来调用static方法。这实际上正是static方法的主要用途。

       {

       方便在没有创建对象的情况下来进行调用（方法/变量）

       被static关键字修饰的方法或者变量不需要依赖于对象来进行访问，只要类被加载了，就可以通过类名去进行访问。

　　    static可以用来修饰类的成员方法、类的成员变量，另外可以编写static代码块来优化程序性能。

       static变量也称作静态变量，静态变量和非静态变量的区别是：静态变量被所有的对象所共享，在内存中只有一个副本
       当且仅当在类初次加载时会被初始化。而非静态变量是对象所拥有的，在创建对象的时候被初始化，存在多个副本，各个对象拥有的副本互不影响

       static成员变量的初始化顺序按照定义的顺序进行初始化

       static代码块

　　    static关键字还有一个比较关键的作用就是 用来形成静态代码块以优化程序性能。static块可以置于类中的任何地方，类中可以有多个static块。
       在类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次

       }

       static和final关键字混淆，static作用于成员变量用来表示只保存一份副本，而final的作用是用来保证变量不可变

       //  生命周期不一致 -解决方案 -拷贝
       匿名内部类中使用的外部局部变量为什么只能是final变量? MyClass
       这段代码会被编译成两个class文件：Test.class和Test1.class。默认情况下，编译器会为匿名内部类和局部内部类起名为Outterx.class（x为正整数）

     */
    public static void finalJava(){

        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(d));
        System.out.println(System.identityHashCode(e));


    }

    public static void getHelloA() {
       String a = "hello2";
       final String b = getHello();
        System.out.println(System.identityHashCode(b));
       String c = b + 2;
       System.out.println((a == c));

    }

    public static String getHello() {
        return "hello";
    }

        public static void main(String[] args) {
           finalJava();
            getHelloA();
            finalStatic();
    }

    public static void finalStatic(){
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println("LLLL" + myClass1.i);
        System.out.println("LLLL" + myClass2.i);
        System.out.println("");

        System.out.println("LLLL" + MyClass.j);
    }

}

class MyClass {
    public final double i = Math.random();
    public static double j = Math.random();

//    public class Test {
//        public static void main(String[] args)  {
//
//        }
//
//        public void test(final int b) {
//            final int a = 10;
//            new Thread(){
//                public void run() {
//                    System.out.println(a);
//                    System.out.println(b);
//                };
//            }.start();
//        }
//    }


}
