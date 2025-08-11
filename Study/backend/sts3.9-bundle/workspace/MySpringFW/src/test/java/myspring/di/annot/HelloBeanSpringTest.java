package myspring.di.annot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	HelloBean hello;
	@Autowired
	@Qualifier("stringPrinterBean")
	PrinterBean printer;
	
	@Test
	void helloBean() {
		assertEquals("Hello 어노테이션", hello.sayHello());
		
		hello.print();
		
		assertEquals("Hello 어노테이션", printer.toString());
	}
	
}
