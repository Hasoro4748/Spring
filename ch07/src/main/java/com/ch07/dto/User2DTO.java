package com.ch07.dto;

import com.ch07.entity.User2;
import lombok.*;

//Entity는 Setter사용안함
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User2DTO {
    private String uid;

    private String name;

    private String birth;

    private String addr;

    // Entity 변환 메서드
    public User2 toEntity(){
        return User2.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();
    }
}
