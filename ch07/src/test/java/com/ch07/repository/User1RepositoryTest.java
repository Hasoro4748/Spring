package com.ch07.repository;

import com.ch07.entity.User1;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    @Test
    void findUser1ByUid() {
        User1 entity = user1Repository.findUser1ByUid("a101");
        System.out.println(entity);
    }

    @Test
    void findUser1ByName() {
        List<User1> entity = user1Repository.findUser1ByName("김유싱");
        System.out.println(entity);

    }

    @Test
    void findUser1ByNameNot() {
        List<User1> entity = user1Repository.findUser1ByNameNot("김유싱");
        System.out.println(entity);
    }

    @Test
    void findUser1ByUidAndName() {
        User1 entity = user1Repository.findUser1ByUidAndName("a101","김유싱");
        System.out.println(entity);
    }
    @Test
    void findUSer1ByUidOrName(){
        List<User1> entity = user1Repository.findUSer1ByUidOrName("a101","홍길동");
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeGreaterThan(){
        List<User1> entity = user1Repository.findUser1ByAgeGreaterThan(30);
        System.out.println(entity);
    }
    @Test
    void findUser1ByAgeGreaterThanEqual(){
        List<User1> entity = user1Repository.findUser1ByAgeGreaterThanEqual(30);
        System.out.println(entity);
    }
    @Test
    void findUser1ByAgeLessThan(){
        List<User1> entity = user1Repository.findUser1ByAgeLessThan(30);
        System.out.println(entity);
    }
    @Test
    void findUser1ByAgeLessThanEqual(){
        List<User1> entity = user1Repository.findUser1ByAgeLessThanEqual(30);
        System.out.println(entity);
    }
    @Test
    void findUser1ByAgeBetween(){
        List<User1> entity = user1Repository.findUser1ByAgeBetween(20, 30);
        System.out.println(entity);
    }
    @Test
    void findUser1ByNameLike() {
        List<User1> entity = user1Repository.findUser1ByNameLike("홍");
        System.out.println(entity);
    }
    @Test
    void findUser1ByNameContains(){
        List<User1> entity = user1Repository.findUser1ByNameContains("홍길동");
        System.out.println(entity);
    }
    @Test
    void findUser1ByNameStartsWith(){
        List<User1> entity = user1Repository.findUser1ByNameStartsWith("김");
        System.out.println(entity);
    }
    @Test
    void findUser1ByNameEndsWith(){
        List<User1> entity = user1Repository.findUser1ByNameEndsWith("동");
        System.out.println(entity);
    }
    @Test
    void findUser1ByOrderByName(){
        List<User1> entity = user1Repository.findUser1ByOrderByName();
        System.out.println(entity);
    }
    @Test
    void findUser1ByOrderByAgeAsc(){
        List<User1> entity = user1Repository.findUser1ByOrderByAgeAsc();
        System.out.println(entity);
    }
    @Test
    void findUser1ByOrderByAgeDesc(){
        List<User1> entity = user1Repository.findUser1ByOrderByAgeDesc();
        System.out.println(entity);
    }
    @Test
    void findUser1ByAgeGreaterThanOrderByAgeAsc(){
        List<User1> entity = user1Repository.findUser1ByAgeGreaterThanOrderByAgeAsc(30);
        System.out.println(entity);
    }
    @Test
    void countUser1ByUid(){
        int entity = user1Repository.countUser1ByUid("a101");
        System.out.println(entity);
    }
    @Test
    void countUser1ByName() {
        int entity = user1Repository.countUser1ByName("홍길동");
        System.out.println(entity);
    }

    void findUser1ByAgeLessThan30(){

    }

    void findUser1WhereName(){

    }

    void findUser1WhereNameParam(){

    }

    @Test
    void selectFromParentJoinChild() {
        List<Object[]> list = user1Repository.selectFromParentJoinChild("P101");
        for (Object[] obj : list) {
            String strUser1 = obj[0].toString();
            String strUser2 = obj[1].toString();

            System.out.println(strUser1);
            System.out.println(strUser2);
        }
    }
}