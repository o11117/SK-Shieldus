package com.rookies4.myspringboot.runner;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class MyPropsRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
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
