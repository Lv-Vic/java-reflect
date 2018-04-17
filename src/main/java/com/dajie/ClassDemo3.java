package com.dajie;

import java.lang.reflect.Method;

/**
 * @Date: 2018-04-16 17:41
 * Mobile: 13161819553
 * @author: changXuan.lv
 */
public class ClassDemo3 {
    public static void main(String[] args) {
        //获取print(int a,int b)的方法 ,首先要获取类的信息，获取类的的信息 那么就要获取类的类类型
        A a1 = new A();
        Class<? extends A> c = a1.getClass();
        /**
         * 获取方法名称和参数列表来决定
         * getMethod() 获取的是public的方法
         * getDeclaredMethod() 获取自己声明的方法
         */
//        Method m = c.getDeclaredMethod("print", new Class[]{int.class, int.class});
        try {
            Method m2 = c.getDeclaredMethod("print", int.class, int.class);


            /**
             * 方法的反射操作
             * 以前是 a1.print(10,20); 方法的反射操作是用m对象来进行方法调用  和a1.print调用的效果是一样的
             * invoke 方法如果没有返回值 返回的是null  如果有返回值则返回的是具体的返回值
             */
            /**
             * 同样也可以写成下面这样
            Object invoke = m2.invoke(a1, new Object[]{10, 20});
             */
            Object invoke = m2.invoke(a1, 10, 20);
            System.out.println("-------------------");
            //获取方法print(String,Striing)
            Method m3 = c.getDeclaredMethod("print", String.class, String.class);
            //用方法的反射操作
            Object invoke1 = m3.invoke(a1, "HEELO", "WORLD");
            System.out.println("---------");
            Method m4 = c.getDeclaredMethod("print");
            Object invoke2 = m4.invoke(a1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class A{
    public void print(int a,int b){
        System.out.println(a + b);
    }

    public void print(String a,String b){
        System.out.println(a + b);
    }

    public void print(){
        System.out.println("hello world");
    }
}
