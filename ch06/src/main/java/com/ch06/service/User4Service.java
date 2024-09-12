package com.ch06.service;

import com.ch06.dao.User4Mapper;
import com.ch06.dto.User4DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User4Service {
    private final User4Mapper user4Mapper;
    public void insertUser4(User4DTO user4DTO) {
        user4Mapper.insertUser4(user4DTO);
    }
    public User4DTO selectUser4(String uid) {
        return user4Mapper.selectUser4(uid);
    }
    public List<User4DTO> selectUser4s() {
        return user4Mapper.selectUser4s();
    }
    public void updateUser4(User4DTO user4DTO) {
        user4Mapper.updateUser4(user4DTO);
    }
    public void deleteUser4(String uid) {
        user4Mapper.deleteUser4(uid);
    }
}
