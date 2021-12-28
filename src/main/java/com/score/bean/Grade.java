package com.score.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;//必须声明这个类，建立javabean
@Data //生成get,set方法
@AllArgsConstructor //生成有参构造函数 ctrl+o
@NoArgsConstructor  //生成无参构造函数
public class Grade implements Serializable {
    private String studentId;
    //    学期
    private String semester;
    //    课程号
    private String name;
    private String subjectId;
    //    平时分
    private Integer  usuallyScore;
    //    期末分
    private Integer  endTermScore;
    //    实验分
    private Integer  experimentScore;
    //    总分
    private Integer  totalScore;
    //    补考分
    private Integer  makeUpScore;
    //    重修分
    private Integer  rebuildScore;
    //    最后总分
    private Integer  finallyScore;
    private String coursename;
}