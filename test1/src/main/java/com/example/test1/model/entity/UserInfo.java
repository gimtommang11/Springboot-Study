package com.example.test1.model.entity;

import com.example.test1.model.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {
    @Id
    @Autowired
    private String userId;

    private String userPw;

    private String region;
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public UserInfo(){}

    public UserInfo(SignupRequest request) {
        userId = request.getId();
        userPw = request.getPw();
        region = request.getRegion();
    }

}
