package test;

import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


public class First {



	@Test
	public void test() {
		Map<Object, Object> map = ArrayUtils.toMap(new Object[][] {
				{ "xx", "xx" }, { "ss", "ss" }, { "uu", "uu" } });
		String re =  map.get("xx").toString();
		System.out.println(re);
	}
}
