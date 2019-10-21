package com.example.test1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.test1.model.entity.UserInfo;

public interface UserInfoDao extends JpaRepository<UserInfo,String> {       //JPA<T,ID> T:Entity 타입클래스 ID:Pk 타입
}
