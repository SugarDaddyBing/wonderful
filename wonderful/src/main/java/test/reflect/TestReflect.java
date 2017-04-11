package test.reflect;

import java.lang.reflect.Method;

import test.reflect.impl.RealSubject;
import test.reflect.inter.Subject;

public class TestReflect {

  public static void main(String[] args) throws Exception {

    MyInvocationHandler demo = new MyInvocationHandler();
    Subject sub = (Subject) demo.bind(new RealSubject());
    String info = sub.say("cruelbb", 24);
    System.out.println(info);

    Class<?> clazz = Class.forName("test.reflect.impl.RealSubject");
    // 调用realsubject的方法
    Method method = clazz.getMethod("hit", String.class, int.class);
    String info2 = (String) method.invoke(clazz.newInstance(), "xx", 5);
    System.out.println(info2);
  }
}
