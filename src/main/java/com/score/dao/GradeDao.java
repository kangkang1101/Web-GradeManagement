package com.score.dao;

import java.util.List;

import com.score.bean.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.score.bean.Grade;
@Mapper
@Repository
public interface GradeDao {

    //通过用户ID或课程号在最终成绩表中查找课程成绩
    List<Grade> findAll(@Param("offset") int offset,
                        @Param("limit") int limit,
                        @Param("name")String name,
                        @Param("cid")String cid);
    //通过课程号或用户ID在临时成绩表中查找课程成绩
    List<Grade> findAll1(@Param("offset") int offset,
                        @Param("limit") int limit,
                        @Param("name")String name,
                        @Param("cid")String cid);
    //通过课号查找正考不及格成绩填写补考成绩
    List<Grade> findAll2(@Param("offset") int offset,
                         @Param("limit") int limit,
                         @Param("name")String name,
                         @Param("cid")String cid);
    //通过课号查找补考不及格成绩填写重修成绩
    List<Grade> findAll3(@Param("offset") int offset,
                         @Param("limit") int limit,
                         @Param("name")String name,
                         @Param("cid")String cid);
    //
    List<Grade> findAll4(@Param("offset") int offset,
                         @Param("limit") int limit,
                         @Param("cid")String cid);
    //通过学期和课程号查找最终成绩
    List<Grade> findAll5(@Param("offset") int offset,
                         @Param("limit") int limit,
                         @Param("sid")String sid,
                         @Param("semester")String semester,
                         @Param("cid")String cid);
    //审核通过将成绩有临时成绩表中更新至最终表
    int pass(String cid);
    //查找符合条件的成绩条数
    int getCount(String name,String cid);
    //更新或录入正考成绩
    int update(Grade grade);
    //更新或录入补考成绩
    int update1(Grade grade);
    //更新或录入重修成绩
    int update2(Grade grade);
    //撤销成绩后将最终表相关项置空
    int update3(String cid);
    //撤销成绩后将临时表相关项置空
    int update4(String cid);
    //选择总分小于60的成绩
    int select1(String cid);
    //选择总分在60-70的成绩
    int select2(String cid);
    //选择总分在70-80的成绩
    int select3(String cid);
    //选择总分在80-90的成绩
    int select4(String cid);
    //选择总分在90以上的成绩
    int select5(String cid);
}
