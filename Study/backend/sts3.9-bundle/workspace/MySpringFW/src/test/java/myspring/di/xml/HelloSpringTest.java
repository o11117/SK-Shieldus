package myspring.di.xml;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//static import
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class HelloSpringTest {
	@Autowired
	Hello hello;
	
	@Test
	void helloBeanByConstructor() {
//		assertEquals(expected, hello.sayHello());
		System.out.println(hello.sayHello());
	}
}
