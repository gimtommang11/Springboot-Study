package com.example.test1.controller;

import com.example.test1.dao.HelloDao;
import com.example.test1.dao.UserInfoDao;
import com.example.test1.exception.AlreadyExistException;
import com.example.test1.exception.NotFoundException;
import com.example.test1.model.SignupRequest;
import com.example.test1.model.entity.Hello;
import com.example.test1.model.LoginRequest;
import com.example.test1.model.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WebController {

    @Autowired      //자동 빈 주임(뭔진모르겠음)
    private HelloDao helloDao;
    @Autowired
    private UserInfoDao userInfoDao;

    @RequestMapping("/add")
    public Hello add(Hello hello) {
        return helloDao.save(hello);
    }

    @RequestMapping("/list")
    public List<Hello> list(Model model) {       //hello타입의 list이름의 list 만들어줌
        List<Hello> helloList = helloDao.findAll();
        return helloList;
    }

    @GetMapping("/")
    public String mainPage() {
        return "hello SpringBoot!";
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody SignupRequest request) {
        Optional<UserInfo> userInfo = userInfoDao.findById(request.getId());
        if (userInfo.isPresent()) {
            throw new AlreadyExistException("중복되는 아이디입니다");
        } else {
            userInfoDao.save(new UserInfo(request));
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        Optional<UserInfo> userInfo = userInfoDao.findById(request.getId());        //userinfo 변수에 request로 온 아이디와 같은 아이디를 찾아 넣음
        if(!userInfo.isPresent()) {      //ispresent() : null인지 아닌지 확인 false일때 null 반환
            throw new NotFoundException("Account is not found");

        }

        return "로그인에 성공했어요";

    }
}


