package com.ch07.service;

import com.ch07.dto.User2DTO;
import com.ch07.entity.User2;
import com.ch07.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User2Service {
    // 생성자 주입
    private final User2Repository user2Repository;

    public void insertUser2(User2DTO user2DTO) {
        User2 entity = user2DTO.toEntity();

        user2Repository.save(entity);
    }
    public User2DTO selectUser2(String uid){
        Optional<User2> opt = user2Repository.findById(uid);
        if(opt.isPresent()){
            User2 entity = opt.get();

            return entity.todto();
        }
        return null;
    }
    public List<User2DTO> selectUser2s(){
        List<User2> user2s = user2Repository.findAll();

        List<User2DTO> users = user2s.stream().map(entity -> entity.todto()).collect(Collectors.toList());
        return users;
    }
    public void deleteUser2(String uid){
        user2Repository.deleteById(uid);
    }
    public  void updateUser2(User2DTO user2DTO){
        boolean result = user2Repository.existsById(user2DTO.getUid());
        if(result){
            User2 entity = user2DTO.toEntity();
            user2Repository.save(entity);
        }
    }

}
