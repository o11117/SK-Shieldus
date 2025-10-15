package com.javatechie.crud.runner;

import com.javatechie.crud.entity.Order;
import com.javatechie.crud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class InsertRunner implements ApplicationRunner {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        IntStream.rangeClosed(1,10)
                .forEach(this::generateOrder);
    }

    private void generateOrder(int index){
        Order savedOrder = orderRepository.save(buildOrder(index));
        System.out.println("등록된 Order Name savedOrder.getName() = " + savedOrder.getName());
    }

    private Order buildOrder(int index){
        return Order.builder()
                .name("Computer " + index)
                .price(1000.0)
                .qty(10 + index)
                .build();
    }


}
