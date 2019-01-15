package com.wzb.yd.javase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * for实现原理分析
 */
public class For_Code {


    private static List<String> arrayList = new ArrayList<>();
    private static List<String> linkList = new LinkedList<>();
    private static List<String> vector = new Vector<>();


    private static List<Integer> integerArrayList = new ArrayList<>();

    /**

     程序*起始

     */
    public static void main(String[] args) {
        System.out.println("面向接口编程" + arrayList.getClass());
        System.out.println("面向接口编程" + linkList.getClass());
        System.out.println("面向接口编程" + vector.getClass());

        if (arrayList.getClass() == integerArrayList.getClass()) {
            System.out.println("同类");
        }
        for (String str : arrayList) {
            System.out.println("str" + str);
        }

    }
}