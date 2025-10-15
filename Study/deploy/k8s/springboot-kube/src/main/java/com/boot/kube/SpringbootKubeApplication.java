package com.boot.kube;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootKubeApplication {
	Logger logger = LoggerFactory.getLogger(SpringbootKubeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKubeApplication.class, args);
	}

	@GetMapping("/message")
	public String displayMessage(){
		return "Congratulation you successfully deployed your application to kubernetes !!";
	}

	@GetMapping("/messageVer2")
	public String displayMessageVer2(){
		return "Version1 Deployment Test !!";
	}


	@Bean
	public String helloBean() {
		return "hello!!";
	}

}
