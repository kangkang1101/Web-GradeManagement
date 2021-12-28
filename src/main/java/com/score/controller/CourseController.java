package com.score.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.score.bean.Course;
import com.score.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.score.service.CourseService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RequestMapping("/course")
@RestController //标识为返回类型为Json的控制器
public class CourseController {

     @Autowired
    private CourseService courseService;
    @RequestMapping("/find")
    public Map<String,Object> findAll(HttpServletRequest request,String coursename,String semester){
        User user= (User)request.getSession().getAttribute("user");
        String uid=user.getUid();
        System.out.print("获取的值为：");
        System.out.print(uid);
        Map<String,Object> result=new HashMap<>();
        result.put("code",0);
        result.put("msg","");

        result.put("count",courseService.getCount(coursename,semester,uid));
        result.put("data",courseService.findAll(uid,coursename,semester));
        return result;
    }
    @RequestMapping("/find1")
    public Map<String,Object> findIsSet(HttpServletRequest request){
        User user= (User)request.getSession().getAttribute("user");
        String uid=user.getUid();
        System.out.print("获取的值为：");
        System.out.print(uid);
        Map<String,Object> result=new HashMap<>();
        result.put("code",0);
        result.put("msg","");

        result.put("count",courseService.findIsSet(uid));
        result.put("data",courseService.findIsSet(uid));
        return result;
    }
    @RequestMapping("/find2")
    public Map<String,Object> findNoSubmit(HttpServletRequest request){
        User user= (User)request.getSession().getAttribute("user");
        String uid=user.getUid();
        System.out.print("获取的值为：");
        System.out.print(uid);
        Map<String,Object> result=new HashMap<>();
        result.put("code",0);
        result.put("msg","");

        result.put("count",courseService.findNoSubmit(uid));
        result.put("data",courseService.findNoSubmit(uid));
        return result;
    }
    @RequestMapping("/findsemester")
    public Map<String,Object>findSemester()
    {
        Map<String,Object> result=new HashMap<>();
        result.put("code",0);
        result.put("msg","");
        result.put("count",courseService.findSemester());
        result.put("data",courseService.findSemester());
        return result;
    }
    @RequestMapping("/findSubmit")
    public Map<String,Object> findIsSubmit(HttpServletRequest request){
        User user= (User)request.getSession().getAttribute("user");
        String uid=user.getUid();
        System.out.print("获取的值为：");
        System.out.print(uid);
        Map<String,Object> result=new HashMap<>();
        result.put("code",0);
        result.put("msg","");

        result.put("count",courseService.findIsSubmit());
        result.put("data",courseService.findIsSubmit());
        return result;
    }
    @RequestMapping("/findwithdraw")
    public Map<String,Object> findwithdraw(HttpServletRequest request){
        User user= (User)request.getSession().getAttribute("user");
        String uid=user.getUid();
        System.out.print("获取的值为：");
        System.out.print(uid);
        Map<String,Object> result=new HashMap<>();
        result.put("code",0);
        result.put("msg","");

        result.put("count",courseService.findwithdraw());
        result.put("data",courseService.findwithdraw());
        return result;
    }
    @RequestMapping("/update")
    public boolean update(Course course){
System.out.print("课程的值为"+course.getFinalpercent());
        System.out.print("课程的ID为"+course.getCoursenum());
        return this.courseService.update(course);
    }
    @RequestMapping("/pass")
    public boolean pass(HttpServletRequest request){
         String cid=(String)request.getSession().getAttribute("coursenum");
        return this.courseService.pass(cid);
    }
    @RequestMapping("/fail")
    public boolean fail(HttpServletRequest request){
        String cid=(String)request.getSession().getAttribute("coursenum");
        return this.courseService.fail(cid);
    }
    @RequestMapping("/updateisset")
    public boolean updatefinal(HttpServletRequest request){

        String coursenum=(String)request.getSession().getAttribute("coursenum");
        return this.courseService.updatefinal(coursenum);
    }



    @RequestMapping("/setcourse")
    public void set(HttpServletRequest request,@RequestParam("cnum[]") String []cnum) {
        String cid=cnum[0];
        request.getSession().setAttribute("coursenum",cid);
        System.out.print("获取的值为"+cid);

    }
    @RequestMapping("/setcourse1")
    public void set1(HttpServletRequest request,@RequestParam("cnum[]") String []cnum,@RequestParam("up[]") int []up,@RequestParam("ep[]") int []ep,@RequestParam("fp[]") int []fp) {
        String cid=cnum[0];
        int usualpercent=up[0];
        int expercent=ep[0];
        int finalpercent=fp[0];
        request.getSession().setAttribute("coursenum",cid);
        request.getSession().setAttribute("usualpercent",usualpercent);
        request.getSession().setAttribute("expercent",expercent);
        request.getSession().setAttribute("finalpercent",finalpercent);
        System.out.print("获取的值为"+cid);
        System.out.print("获取的值为"+usualpercent);
        System.out.print("获取的值为"+expercent);
        System.out.print("获取的值为"+finalpercent);

    }
    @RequestMapping("/setwithdraw")
    public boolean setwithdraw(HttpServletRequest request) {
        String cid=(String)request.getSession().getAttribute("coursenum");
        return this.courseService.setwithdraw(cid);

    }
    @RequestMapping("/withdrawok")
    public boolean withdrawok(HttpServletRequest request) {
        String cid=(String)request.getSession().getAttribute("coursenum");
        return this.courseService.withdrawok(cid);
    }
    @RequestMapping("/withdrawfail")
    public boolean withdrawfail(HttpServletRequest request) {
        String cid=(String)request.getSession().getAttribute("coursenum");
        return this.courseService.withdrawfail(cid);
    }
    @RequestMapping("/fenxi")
    public Map<String,Object> fenxi(HttpServletRequest request){
        String cid= (String)request.getSession().getAttribute("coursenum");
        System.out.print("获取的值为：");
        System.out.print(cid);
        Map<String,Object> result=new HashMap<>();
        result.put("code",0);
        result.put("msg","");

        result.put("count",courseService.fenxi(cid));
        result.put("data",courseService.fenxi(cid));
        return result;
    }
    @RequestMapping("/updatefenxi")
    public boolean updatefenxi(Course course){

        System.out.print("课程号为"+course.getCoursenum());
        System.out.print("分析1为"+course.getFenxi1());
        return this.courseService.updatefenxi(course);
    }
}
