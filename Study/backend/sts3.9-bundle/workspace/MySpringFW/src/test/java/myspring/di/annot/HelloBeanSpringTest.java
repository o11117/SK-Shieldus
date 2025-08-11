package myspring.di.annot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	HelloBean hello;
	
	@Test
	void helloBean() {
		Assertions.assertEquals(expected, hello.sayHello());
	}
	
}
