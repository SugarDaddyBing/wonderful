package test.reflect;

public class AnotherTest {

  /**
   * 运行时，maven会将main/java跟main/resource下的文件 扔到target/classes下面
   *
   * @param args
   */
  public static void main(String[] args) {
    String modulePath = "module/yeah.txt";
    System.out.println(Boolean.TRUE.equals(null));
    System.out.println(AnotherTest.class.getClassLoader().getResource(""));
    System.out.println(AnotherTest.class.getClassLoader().getResource(modulePath).getPath().substring(1));
  }
}
