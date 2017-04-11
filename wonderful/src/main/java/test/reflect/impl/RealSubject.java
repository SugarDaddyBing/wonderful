package test.reflect.impl;

import test.reflect.inter.Subject;

public class RealSubject implements Subject {

  @Override
  public String say(String name, int age) {
    return name + "    " + age;
  }

  @Override
  public String hit(String name, int count) {
    return "hit" + name + count + "下";
  }

}
