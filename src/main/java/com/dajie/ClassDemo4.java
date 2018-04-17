package com.dajie;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Date: 2018-04-16 18:23
 * Mobile: 13161819553
 * @author: changXuan.lv
 */
public class ClassDemo4 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("String");
        Class<? extends ArrayList> c1 = arrayList.getClass();
        Class<? extends ArrayList> c2 = arrayList1.getClass();
        System.out.println(c1==c2 );
        //所以反射的操作 都是编译之后的操作
        /**
         * c1 == c2 返回的结果为true 说明编译之后集合的泛型 是去泛型化的
         * 所以Java中集合的泛型是为了防止错误输入的，只在编译阶段有效
         * 绕过编译就无效了
         * 验证：通过Java反射来操作 绕过编译
         */
        try {
            Method add = c2.getDeclaredMethod("add", Object.class);
            Object invoke = add.invoke(arrayList1, 20);
            System.out.println(arrayList1.size());
            System.out.println(arrayList1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
