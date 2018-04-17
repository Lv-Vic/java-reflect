package com.dajie;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Date: 2018-04-16 15:56
 * Mobile: 13161819553
 * @author: changXuan.lv
 */
public class ClassUtil {
    /**
     * 打印类的信息，包括类的成员函数
     * @param obj  该对象所属类的信息
     */
    public static void printClassMessge(Object obj){
        //获取类的信息  首先要获取类的类类型
        //传递的是哪个子类的对象 c就是该子类的类类型
        Class<?> c = obj.getClass();
        //获取类的简单名称
        c.getSimpleName();

        //获取类的名称
        System.out.println("类的名称是：" + c.getName());

        /**
         * Method类   方法对象
         * 一个成员方法就是一个method对象
         * getMethods()方法就是取的所有public的函数  包括父类继承而来的函数
         * getDeclaredMethods()  方法是获取该类自己声明的函数 不问访问权限
         */
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            //得到方法的返回值类型的类类型
            Class<?> returnType = method.getReturnType();
            System.out.println(returnType.getName() + "");
            //得到方法的名称
            System.out.print(method.getName() + "(");
            //获取方法的参数类型-->得到的是参数列表的类型的类类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType.getName()+ ",");
            }
            System.out.print(")");


        }
    }

    /**
     * 获取成员变量
     * @param object
     */
    public static void printFieldMessge(Object object) {
        Class<?> c = object.getClass();
        /**
         * 成员变量也是对象
         * java.lang.reflect.Field
         * Field类封装了关于成员变量的操作
         * getFields()方法获取的是所有的public的成员变量的信息
         * c.getDeclaredFields()获取的是该类自己声明的成员变量的信息
         */

//            Field[] fields = c.getFields();
        Field[] declaredFields = c.getDeclaredFields();
        for (Field field : declaredFields) {
            //得到成员变量的类型的类类型
            Class<?> type = field.getType();
            String typeName = type.getName();
            //得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(typeName + "," + fieldName);
        }
    }

    /**
     * 获取该类构造函数的信息
     * @param obj
     */
    public static void getConMessge(Object obj){
        Class<?> c = obj.getClass();
        /**
         *首先构造函数也是对象
         * java.lang.reflect.Constructor中封装了构造函数的信息
         * c.getConstructors()获取所有的public的构造函数
         */
//        Constructor<?>[] constructors = c.getConstructors();
        //获取自己声明的构造函数的信息
        Constructor<?>[] cs = c.getDeclaredConstructors();
        for (Constructor<?> constructor : cs) {
            System.out.println(constructor.getName() + "(");
            //获取构造函数参数的列表--> 得到的是参数列表的类类型
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType.getName() + ",");
            }
            System.out.print(")");
        }
    }

}
