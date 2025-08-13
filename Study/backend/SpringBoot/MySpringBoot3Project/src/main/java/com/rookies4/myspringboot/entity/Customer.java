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
}
