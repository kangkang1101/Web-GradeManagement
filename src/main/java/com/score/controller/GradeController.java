package com.score.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.score.bean.Grade;
import com.score.bean.Count;
import com.score.bean.Course;
import com.score.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.score.service.GradeService;
@RequestMapping("/grade")
@RestController //标识为返回类型为Json的控制器
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @RequestMapping("/find")
    public Map<String, Object> findAll(Integer page,Integer limit ,String name,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String uid = user.getUid();
        String  cid=  (String)request.getSession().getAttribute("coursenum");
        System.out.print("获取的值为：");
        System.out.print(cid);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");

        result.put("count", gradeService.getCount(name,cid));
        result.put("data", gradeService.findAll(page,limit,name,cid));
        return result;
    }
    @RequestMapping("/find1")
    public Map<String, Object> findAll1(Integer page,Integer limit ,String name,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String uid = user.getUid();
        String  cid=  (String)request.getSession().getAttribute("coursenum");
        System.out.print("获取的值为：");
        System.out.print(cid);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");

        result.put("count", gradeService.getCount(name,cid));
        result.put("data", gradeService.findAll1(page,limit,name,cid));
        return result;
    }
    @RequestMapping("/find2")
    public Map<String, Object> findAll2(Integer page,Integer limit ,String name,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String uid = user.getUid();
        String  cid=  (String)request.getSession().getAttribute("coursenum");
        System.out.print("获取的值为：");
        System.out.print(cid);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");

        result.put("count", gradeService.getCount(name,cid));
        result.put("data", gradeService.findAll2(page,limit,name,cid));
        return result;
    }
    @RequestMapping("/find3")
    public Map<String, Object> findAll3(Integer page,Integer limit ,String name,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String uid = user.getUid();
        String  cid=  (String)request.getSession().getAttribute("coursenum");
        System.out.print("获取的值为：");
        System.out.print(cid);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");

        result.put("count", gradeService.getCount(name,cid));
        result.put("data", gradeService.findAll3(page,limit,name,cid));
        return result;
    }
    @RequestMapping("/find5")
    public Map<String, Object> findAll5(Integer page,Integer limit ,String coursename,String semester,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String sid = user.getUid();
        String  cid=  (String)request.getSession().getAttribute("coursenum");
        System.out.print("获取的值为：");
        System.out.print(sid);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");

        result.put("count", gradeService.getCount(coursename,cid));
        result.put("data", gradeService.findAll5(page,limit,sid,semester,coursename));
        return result;
    }
    @RequestMapping("/find4")
    public Map<String, Object> findAll4(Integer page,Integer limit ,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String uid = user.getUid();
        String  cid=  (String)request.getSession().getAttribute("coursenum");
        System.out.print("获取的值为：");
        System.out.print(cid);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");

        result.put("count", gradeService.findAll4(page,limit,cid));
        result.put("data", gradeService.findAll4(page,limit,cid));
        return result;
    }
    @RequestMapping("/pass")
    public boolean pass(HttpServletRequest request){
        String cid=(String)request.getSession().getAttribute("coursenum");
        return this.gradeService.pass(cid);
    }

    @RequestMapping("/update")
    public boolean update(Grade grade,HttpServletRequest request){
       int usualpercent=(int)request.getSession().getAttribute("usualpercent");
        int expercent=(int)request.getSession().getAttribute("expercent");
        int finalpercent=(int)request.getSession().getAttribute("finalpercent");
        int total=usualpercent*grade.getUsuallyScore()/100+expercent*grade.getExperimentScore()/100+finalpercent*grade.getEndTermScore()/100;
        grade.setTotalScore(total);
        return this.gradeService.update(grade);
    }
    @RequestMapping("/update1")
    public boolean update1(Grade grade){

        if(grade.getMakeUpScore()>60)
        {
            grade.setMakeUpScore(60);
            grade.setFinallyScore(60);
        }
        else{
            grade.setFinallyScore(grade.getMakeUpScore());
        }
        return this.gradeService.update1(grade);
    }

    @RequestMapping("/update2")
    public boolean update2(Grade grade){

        if(grade.getRebuildScore()>60)
        {
            grade.setRebuildScore(60);
            grade.setFinallyScore(60);
        }
        else{
            grade.setFinallyScore(grade.getRebuildScore());
        }
        return this.gradeService.update2(grade);
    }

    @RequestMapping("/update3")
    public boolean update3(HttpServletRequest request){

    String cid=(String)request.getSession().getAttribute("coursenum");
        return this.gradeService.update3(cid);
    }
    @RequestMapping("/update4")
    public boolean update4(HttpServletRequest request){

        String cid=(String)request.getSession().getAttribute("coursenum");
        return this.gradeService.update4(cid);
    }
    @RequestMapping("/chart")
    public Integer[] chart(HttpServletRequest request){
       String cid=(String)request.getSession().getAttribute("coursenum");
       int a1=this.gradeService.select1(cid);
       System.out.print(a1);
       Integer[] a={this.gradeService.select1(cid),this.gradeService.select2(cid),this.gradeService.select3(cid),this.gradeService.select4(cid),this.gradeService.select5(cid),};
       return a;
    }
    @RequestMapping("/chart1")
    public Count[] chart1(HttpServletRequest request)
    {
        String cid=(String)request.getSession().getAttribute("coursenum");
        Count c1=new Count();
        c1.setName("60以下");
        c1.setValue(this.gradeService.select1(cid));
        Count c2=new Count();
        c2.setName("60-70");
        c2.setValue(this.gradeService.select2(cid));
        Count[] count={c1,c2};
        return count;

        //List<Count> count=new ArrayList<Count>();
        //count.add(c1);
        //count.add(c2);
        //return count;


    }
    }


