package com.dajie;

/**
 * @Date: 2018-04-16 10:55
 * Mobile: 13161819553
 * @author: changXuan.lv
 */
public class ClassDemo1 {
    public static void main(String[] args) {
        //foo的实例对象如何表示  foo1就表示出来了
        Foo foo1 = new Foo();
        //Foo这个类也是实力对象 是Class的实例对象，那么Class的实例对象如何表示呢
        //首先要清楚的是 任何一个类都是Class的实例对象，而这个实例对象的表达方式有三种

        //第一种表示方式 -->实际在告诉我们任何一个类都有一个隐含的静态成员变量Class
        Class<Foo> c1 = Foo.class;

        //第二种表达方式  -->已经知道该类的对象通过getClass的方法
        Class<? extends Foo> c2 = foo1.getClass();

        /*官网表示 C1  c2 都表示了Foo类的类类型（class type）
        * 万物皆对象
        * 类也是对象，是class类的实例对象
        * 这个对象 我们称为该类的类类型
        * */

        //不管C1 C2都代表了Foo类的类类型  一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2);


        //第三种表达方式
        Class c3 = null;
        try {
            //需要该类的全路径
            c3 = Class.forName("com.dajie.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c2 == c3);


        //那么我们可以完全通过该类的类类型创建该类的对象实例 -->通过C1 或者C2 C3创建Foo的对象
        try {
            //这个方法的前提是需要有无参的构造方法
            Foo foo = (Foo)c1.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
class Foo{

}
