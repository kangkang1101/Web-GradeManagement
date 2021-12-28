package com.score.service.impl;
import java.util.List;

import com.score.dao.CourseDao;
import com.score.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.score.bean.Course;
import com.score.dao.CourseDao;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> findAll(String uid,String cid,String semester)
    { return courseDao.findAll(uid,cid,semester);}
    @Override
    public List<Course> findIsSet(String uid)
    {
        return courseDao.findIsSet(uid);
    }
    @Override

    public boolean update(Course course) {
        return this.courseDao.update(course)>0;
    }
    @Override
    public boolean pass(String cid){return this.courseDao.pass(cid)>0;}
    @Override

    public boolean updatefinal(String coursenum) {
        return this.courseDao.updatefinal(coursenum)>0;
    }
    @Override
    public List<Course>findNoSubmit(String uid)
    {
        return courseDao.findNoSubmit(uid);
    };
    @Override
    public boolean fail(String cid){ return this.courseDao.fail(cid)>0;}
    @Override
    public List<Course>findIsSubmit()
    {
        return courseDao.findIsSubmit();
    }
    @Override
    public List<Course>findwithdraw()
    {
        return courseDao.findwithdraw();
    }
    @Override
    public List<String>findSemester()
    {
        return courseDao.findSemester();
    }
    @Override
    public boolean setwithdraw(String cid){
        return this.courseDao.setwithdraw(cid)>0;
    }
    @Override
    public boolean withdrawok(String cid){
        return this.courseDao.withdrawok(cid)>0;
    }
    @Override
    public boolean withdrawfail(String cid){
        return this.courseDao.withdrawfail(cid)>0;
    }
    @Override
    public int getCount(String cid,String semester,String uid)
    {
        return this.courseDao.getCount(cid,semester,uid);
    }
    @Override
    public List<Course>fenxi(String cid){ return this.courseDao.fenxi(cid);}
    @Override

    public boolean updatefenxi(Course course) {
        return this.courseDao.updatefenxi(course)>0;
    }
}
