package com.score.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.score.bean.Course;
import org.springframework.stereotype.Service;


public interface CourseService {
    List<Course> findAll(String uid,String cid,String semester);
    List<Course> findIsSet(String uid);
    List<Course>findNoSubmit(String uid);
    List<Course>findIsSubmit();
    List<Course>findwithdraw();
    List<String>findSemester();
    boolean update(Course course);
    boolean setwithdraw(String cid);
    boolean withdrawok(String cid);
    boolean withdrawfail(String cid);
    boolean pass(String cid);
    boolean fail(String cid);
    boolean updatefinal(String coursenum);
    int getCount(String cid,String semester,String uid);
    List<Course>fenxi(String cid);
    boolean updatefenxi(Course course);
}
