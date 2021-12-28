package com.score.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;//必须声明这个类，建立javabean
@Data //生成get,set方法
@AllArgsConstructor //生成有参构造函数 ctrl+o
@NoArgsConstructor  //生成无参构造函数

public class Course implements Serializable {
    private String coursenum;//课号
    private String semester;//学期
    private String coursename;//课程名
    private Integer tid;//教师工号
    private Integer usualpercent;//平时分占比
    private Integer finalpercent;//期末占比
    private Integer expercent;//实验占比
    private Integer submit;//是否提交
    private Integer check;//是否审核通过
    private Integer withdraw;//是否撤销
    private String fenxi1;
    private String fenxi2;

}
