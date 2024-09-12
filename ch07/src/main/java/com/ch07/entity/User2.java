package com.ch07.entity;

import com.ch07.dto.User1DTO;
import com.ch07.dto.User2DTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

//Entity는 Setter사용안함
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity                     // 엔티티 객체 정의
@Table(name = "user2")      // 매핑 테이블 설정
public class User2 {
    @Id // PK 컬럼 설정(엔티티에 반드시 필요)
    private String uid;

    @Column(name = "name")  // 매핑 컬섬 설정(생략가능)
    private String name;

    @Column(name = "birth")
    private String birth;

    @Column(name = "addr")
    private String addr;


    //DTO 변환 메서드
    public User2DTO todto(){
        return User2DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();
    }
}
