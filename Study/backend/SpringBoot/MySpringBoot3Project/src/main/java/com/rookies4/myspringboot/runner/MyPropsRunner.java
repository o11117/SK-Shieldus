package com.rookies4.myspringboot.runner;


import com.rookies4.myspringboot.config.vo.CustomVO;
import com.rookies4.myspringboot.property.MyBootProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class MyPropsRunner implements ApplicationRunner {

    @Value("${myboot.name}")
    private String name;

    @Value("${myboot.age}")
    private int age;

    @Autowired
    private Environment environment;

    @Autowired
    private MyBootProperties properties;

    @Autowired
    private CustomVO custom;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("현재 활성화된 CustomVO = " + custom);

        System.out.println("MyBootProperties.getName() = " + properties.getName());
        System.out.println("MyBootProperties.getAge() = " + properties.getAge());
        System.out.println("MyBootProperties.getFullName() = " + properties.getFullName());

        System.out.println("Properties myboot.name = " + name);
        System.out.println("Properties myboot.age = " + age);
        System.out.println("Properties myboot.fullName = " + environment.getProperty("myboot.fullName"));

        System.out.println("VM Arguments " + args.containsOption("foo"));//false
        System.out.println("Program Arguments " + args.containsOption("bar"));//true

        //Program Argument의 모든 이름 출력
        for (String argName: args.getOptionNames()) {
            System.out.println("아규먼트 이름 = " + argName);
        }

        //args.getOptionNames()의 리턴타입 Set<String>
        //Iterable의 forEach 메서드를 사용하여 모든 이름 출력
        //Consumer의 추상메서드 accept()를 구현하는 람다식 사용
        //1. 익명의 Inner Class (Annonymous Inner Class)
        args.getOptionNames().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Inner Class 아규먼트 이름 = " + s);
            }
        });

        //2. 람다식
        args.getOptionNames().forEach(s -> System.out.println("람다식 아규먼트 이름 = " + s));

        //3. 메서드 레퍼런스
        args.getOptionNames().forEach(System.out::println);


    }
}
