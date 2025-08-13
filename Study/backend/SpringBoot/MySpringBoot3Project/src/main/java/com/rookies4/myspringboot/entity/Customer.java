package com.rookies4.myspringboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter @Setter
public class Customer {
    //Primary Key, PK값을 Persistence Provider가 자동으로 생성
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Unique한 값을 가져야하고, Null이 될 수 없다.
    @Column(unique = true, nullable = false)
    private String customerId;

    @Column(nullable = false)
    private String customerName;
}
