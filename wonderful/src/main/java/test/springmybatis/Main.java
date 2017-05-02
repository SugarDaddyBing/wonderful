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
  SqlSessionTemplate sqlSessionTemplate = (SqlSessionTemplate) factory.getBean("sqlSessionTemplate");
    List<Role> list = sqlSessionTemplate.getMapper(Mapper.class).getRole();
    System.out.println(list.get(0).getName());
  }

}
