package com.example.test1.dao;   //dao:  DB등에서 읽어온 객체 처리

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.test1.model.entity.Hello;

public interface HelloDao extends JpaRepository<Hello, Integer>{

}