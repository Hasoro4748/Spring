package com.ch07.entity.board;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity                     // 엔티티 객체 정의
@Table(name = "board_User")
public class User {
    @Id
    private String uid;
    private String name;
    private String nick;
    private String email;

    @CreationTimestamp
    private LocalDateTime regDate;
}
