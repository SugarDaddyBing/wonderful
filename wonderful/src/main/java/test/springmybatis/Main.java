package test.springmybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.springmybatis.mapper.Mapper;
import test.springmybatis.po.Role;

public class Main {

  private static ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:test/springmybatis/ApplicationContext.xml");

  public static void main(String[] args) {
    SqlSessionTemplate sqlSessionTemplate_f = (SqlSessionTemplate) factory.getBean("sqlSessionTemplate_f");
    SqlSessionTemplate sqlSessionTemplate_t = (SqlSessionTemplate) factory.getBean("sqlSessionTemplate_t");
    List<Role> list = sqlSessionTemplate_f.getMapper(Mapper.class).getRole();
    System.out.println(list.get(0).getName());
    for (int i = 0; i < list.size(); i++) {
      sqlSessionTemplate_t.getMapper(Mapper.class).setRole(list.get(i));
      System.out.println("ok++"+(i+1));
    }
  }

}
