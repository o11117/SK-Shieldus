### [수업중 2-5] Spring Boot와 JPA(Java Persistence API)

* Student 와 StudentDetail 1:1 관계
* Student 와 Department N:1 관계
  * FetchType.LAZY vs FetchType.EAGER
  * @JoinColumn, mappedBy
  * 연관관계의 주인 (owner)과 비주인(non-owner)
    * Owner(StudentDetail) , Non-owner(Student)
* DTO
* Controller
* Service
* Repository
* DataInsertRunner
* N+1 문제 해결
  * 성능개선
  * HibernateModule 사용하여 BatchSize 설정

Service 만들기
