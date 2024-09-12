package com.ch07.entity;

import com.ch07.dto.User2DTO;
import jakarta.persistence.*;
import lombok.*;

//Entity는 Setter사용안함
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity                     // 엔티티 객체 정의
@Table(name = "user5")      // 매핑 테이블 설정
public class User5 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 필드(컬럼)값이 자동 1증가 (auto_Increament)
    private int seq;

    private String name;
    private String gender;
    private int age;
    private String addr;
}
