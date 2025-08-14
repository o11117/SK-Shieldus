package com.rookies4.myspringboot.repository;

import com.rookies4.myspringboot.entity.Customer;
import org.junit.jupiter.api.Disabled;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.as;
import static org.junit.jupiter.api.Assertions.*;
//assertj 라이브러리의 Assertions 클래스
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    //Customer 조회
    void testFindCustomer() {
        //findByCustomerId 메소드를 이용해서 Customer 조회
        Optional<Customer> customerById = customerRepository.findById(1L);
//        assertThat(customerById).isNotEmpty();
//        assertThat(customerById).isEmpty();

        if(customerById.isPresent()) {
            Customer existCustomer = customerById.get();
            assertThat(existCustomer.getId()).isEqualTo(1L);
        }
    }

    @Test
    @Rollback(false)
    @Disabled
    void testSaveCustomer() {
        //Given (준비단계)
        Customer customer = new Customer();
        customer.setCustomerId("AC002");
        customer.setCustomerName("스프링FW");
        //When (실행단계)
        Customer savedCustomer = customerRepository.save(customer);
        //Then (검증단계)
        //등록된 Customer가 null이 아닌지 확인
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getCustomerName()).isEqualTo("스프링FW");
        //assertEquals(expected, actual);
    }
}