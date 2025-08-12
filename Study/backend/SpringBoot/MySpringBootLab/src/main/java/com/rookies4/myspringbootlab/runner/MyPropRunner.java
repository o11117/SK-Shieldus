package com.rookies4.myspringbootlab.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class MyPropRunner implements ApplicationRunner {

    @Value("${myprop.username}")
    private String username;

    @Value("${myprop.port}")
    private int port;

    @Autowired
    private Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Properties myprop.username = " + username);
        System.out.println("Properties myprop.port = " + port);

    }
}
