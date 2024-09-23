package com.ch04.controller;

import com.ch04.dto.User2DTO;
import com.ch04.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User2Controller {

    @Autowired
    public User2Service service;

    //view resolver가 "/WEB-INF/views  ~~  .jsp로 변환해준다.
    @GetMapping("/user2/register")
    public String register(){
        return "/user2/register";
    }
    @PostMapping("/user2/register")
    public String register(User2DTO dto){
        System.out.println(dto);

        //등록
        service.insertUser2(dto);

        //리다이렉트
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/list")
    public String list(Model model){

        //조회
        List<User2DTO> users = service.selectUser2s();
        System.out.println(users);

        //모델 참조(Controller 데이터를 View에서 참조)
        model.addAttribute("users", users);
        return "/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(@RequestParam("uid") String uid, Model model){
        System.out.println("uid : " + uid);

        // 수정회원조회
        User2DTO user = service.selectUser2(uid);
        //모델 참조
        model.addAttribute(user); // 타입명으로 저장(소문자 시작 -> user2DTO

        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(@ModelAttribute User2DTO dto){

        System.out.println(dto);

        service.updateUser2(dto);

        return "redirect:/user2/list";

    }

    @GetMapping("/user2/delete")
    public String delete(@RequestParam("uid") String uid){

        System.out.println("delete : " + uid);

        service.deleteUser2(uid);

        return "redirect:/user2/list";
    }



}
