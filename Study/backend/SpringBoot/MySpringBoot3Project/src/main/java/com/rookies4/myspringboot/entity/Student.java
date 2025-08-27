package com.rookies4.myspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Student
@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    //PK (Sequential Value)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    //이름
    @Column(nullable = false)
    private String name;
    //학번
    @Column(nullable = false, unique = true)
    private String studentNumber;

    //양방향관계 Student에서 StudentDetail을 참조할 수 있도록 FK에 해당하는 필드명을 mappedBy로 설정한다
    //1:1 관계 지연로딩

    @OneToOne(fetch =  FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
    private StudentDetail studentDetail;

    //N:1 관계 지연로딩
    //department 변수는 테이블의 FK와 매핑되는 필드
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}