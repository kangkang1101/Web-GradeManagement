package com.score.service.impl;

import com.score.bean.Course;
import com.score.dao.CourseDao;
import com.score.service.GradeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.score.bean.Grade;
import com.score.dao.GradeDao;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeDao gradeDao;
    @Override
    public List<Grade> findAll(int offset, int limit,String name,String cid)
    { return gradeDao.findAll((offset-1)*limit, limit,name,cid);}
    @Override
    public List<Grade> findAll1(int offset, int limit,String name,String cid)
    { return gradeDao.findAll1((offset-1)*limit, limit,name,cid);}
    @Override
    public List<Grade> findAll2(int offset, int limit,String name,String cid)
    { return gradeDao.findAll2((offset-1)*limit, limit,name,cid);}
    @Override
    public List<Grade> findAll3(int offset, int limit,String name,String cid)
    { return gradeDao.findAll3((offset-1)*limit, limit,name,cid);}
    @Override
    public List<Grade> findAll5(int offset, int limit,String name,String semester,String cid)
    { return gradeDao.findAll5((offset-1)*limit, limit,name,semester,cid);}
    @Override
    public List<Grade> findAll4(int offset, int limit,String cid)
    { return gradeDao.findAll4((offset-1)*limit, limit,cid);}
    @Override

    public boolean update(Grade grade) {
        return this.gradeDao.update(grade)>0;
    }
    @Override
    public boolean pass(String cid){
        return this.gradeDao.pass(cid)>0;
    }
    @Override

    public boolean update1(Grade grade) {
        return this.gradeDao.update1(grade)>0;
    }
    @Override

    public boolean update2(Grade grade) {
        return this.gradeDao.update2(grade)>0;
    }
    @Override

    public boolean update3(String cid) {
        return this.gradeDao.update3(cid)>0;
    }
    @Override
    public int getCount(String name,String cid) {
        return gradeDao.getCount(name,cid);
    }
    @Override
    public boolean update4(String cid) {
        return this.gradeDao.update4(cid)>0;
    }
    @Override
    public int select1(String cid) {
        return gradeDao.select1(cid);
    }
    @Override
    public int select2(String cid) {
        return gradeDao.select2(cid);
    }
    @Override
    public int select3(String cid) {
        return gradeDao.select3(cid);
    }
    @Override
    public int select4(String cid) {
        return gradeDao.select4(cid);
    }
    @Override
    public int select5(String cid) {
        return gradeDao.select5(cid);
    }
}
