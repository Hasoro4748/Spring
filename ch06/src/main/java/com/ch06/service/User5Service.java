package com.ch06.service;

import com.ch06.dao.User5Mapper;
import com.ch06.dto.User5DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User5Service {
    private final User5Mapper user5Mapper;
    public void insertUser5(User5DTO user5DTO) {
        user5Mapper.insertUser5(user5DTO);
    }
    public User5DTO selectUser5(String seq) {
        return user5Mapper.selectUser5(seq);
    }
    public List<User5DTO> selectUser5s() {
        return user5Mapper.selectUser5s();
    }
    public void updateUser5(User5DTO user5DTO) {
        user5Mapper.updateUser5(user5DTO);
    }
    public void deleteUser5(String seq) {
        user5Mapper.deleteUser5(seq);
    }
}
