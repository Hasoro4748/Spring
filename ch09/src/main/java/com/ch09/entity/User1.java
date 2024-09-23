package com.ch09.entity;

import com.ch09.dto.User1DTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user1")
public class User1 {
    @Id
    private String uid;

    @Column(name = "name")  // 매핑 컬섬 설정(생략가능)
    private String name;

    @Column(name = "birth")
    private String birth;

    @Column(name = "hp")
    private String hp;

    @Column(name = "age")
    private int age;

    //DTO 변환 메서드
    public User1DTO todto(){
        return User1DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }
}
