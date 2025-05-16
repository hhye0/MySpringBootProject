package com.basic.myspringboot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
//Non-Owner(종속) 양방향 관계ex
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String studentNumber;

    //1:1 지연 로딩
    // 양방향 Student 에서 StudentDetail 참조할 수 있도록 FK에 해당하는 필드명 mappedBy에 설정
    //Student 와 StudentDetail 의 라이프 사이클이 같음
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
    private StudentDetail studentDetail;
}