package com.score.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.score.bean.Course;
import com.score.bean.Grade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface GradeService {
    List<Grade> findAll(int offset, int limit,String name,String cid);
    List<Grade> findAll1(int offset, int limit,String name,String cid);
    List<Grade> findAll2(int offset, int limit,String name,String cid);
    List<Grade> findAll3(int offset, int limit,String name,String cid);
    List<Grade> findAll4(int offset, int limit,String cid);
    List<Grade> findAll5(int offset, int limit,String sid,String semester,String cid);
    int getCount(String name,String cid);
    boolean update(Grade grade);
    boolean pass(String cid);
    boolean update1(Grade grade);
    boolean update2(Grade grade);
    boolean update3(String cid);
    boolean update4(String cid);
    int select1(String cid);
    int select2(String cid);
    int select3(String cid);
    int select4(String cid);
    int select5(String cid);
}
