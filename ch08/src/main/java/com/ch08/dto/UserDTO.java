package com.ch08.dto;

import com.ch08.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String uid;
    private String pass;
    private String name;
    private String birth;
    private String rdate;
    private String role;

    public User toEntity() {
        return User.builder()
                .uid(uid)
                .pass(pass)
                .name(name)
                .birth(birth)
                .rdate(rdate)
                .role(this.role)
                .build();
    }
}
