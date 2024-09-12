package com.ch07.service;

import com.ch07.dto.User1DTO;
import com.ch07.entity.User1;
import com.ch07.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User1Service {
    // 생성자 주입
    private final User1Repository user1Repository;

    public void insertUser1(User1DTO user1Dto){
        // DTO를 Entity로 변환
        User1 entity = user1Dto.toEntity();

        //Entity 저장(데이터베이스 Insert)
        user1Repository.save(entity);
    }
    public User1DTO selectUser1(String uid){
        /*
            Optional
                - null 체크 검정을 손쉽고 안전하게 처리하기위한 클래스
                - Spring JPA find~ 메서드의 결과 타입
         */
        Optional<User1> opt = user1Repository.findById(uid);
        if(opt.isPresent()){
            User1 user1 = opt.get();    // Optional 타입으로 정의된 Entity를 가져오기
            //Entity를 DTO로 변환해서 반환

            return user1.todto();
        }
        return null;
    }
    public List<User1DTO> selectUser1s(){
        List<User1> user1s = user1Repository.findAll();

        /* for(외부 반복자)를 이용한 Entity 리스트를 DTO 리스트로 변환
        List<User1DTO> user1Dtos = new ArrayList<>();

        for(User1 user1 : user1s){
            user1Dtos.add(user1.todto());
        }
        */

        //List stream(내부 반복자)를 이용한 Entity 리스트를 DTO 리스트로 변환
        List<User1DTO> users = user1s
                .stream()
                .map(entity -> entity.todto())
                .collect(Collectors.toList());
        return users;
    }
    public void updateUser1(User1DTO user1Dto){
        //존재 여부 확인
        boolean result = user1Repository.existsById(user1Dto.getUid());
        if(result){
            //DTO를 Entity로 변환
            User1 entity = user1Dto.toEntity();

            // Entity 수정 (데이터베이스 업데이트)
            user1Repository.save(entity);
        }
    }
    public void deleteUser1(String uid){
        //엔티티 삭제(데이터베이스 delete)
        user1Repository.deleteById(uid);
    }
}
