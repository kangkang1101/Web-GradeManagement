package com.score.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.score.bean.Course;
@Mapper
@Repository
public interface CourseDao {

    //根据教师编号、学期或课程名查询课程
    List<Course> findAll(@Param("uid")String uid,@Param("cid")String cid,@Param("semester")String semester);
    //查找以及设置过课程比例的课程
    List<Course> findIsSet(String uid);
   //查找还未提交的课程
    List<Course>findNoSubmit(String uid);
   //查找已经提交的课程
    List<Course>findIsSubmit();
   //查找申请撤销的课程
    List<Course>findwithdraw();
    //更新课程的通过字段为1表示课程审核通过
    int pass(String cid);
    //更新课程的通过字段位0表示课程审核未通过
    int fail(String cid);
    //更新课程的比例
    int update(Course course);
    //更新课程提交字段表示课程已提交审核
    int updatefinal(String coursenum);
    //更新课程撤销字段表示课程申请撤销
    int setwithdraw(String cid);
    //撤销成功将撤销字段提交字段审核通过字段置为1
    int withdrawok(String cid);
    //撤销失败将撤销字段置为0
    int withdrawfail(String cid);
    //获取课程数目
    int getCount(String cid,String semester,String uid);
    List<String>findSemester();
    List<Course>fenxi(String cid);
    int updatefenxi(Course course);
}
