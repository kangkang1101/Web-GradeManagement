package com.score.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户实体类
 * @author hmg
 *
 */
@Component
@Data
@AllArgsConstructor //生成有参构造函数 ctrl+o
@NoArgsConstructor
public class User implements Serializable{
	private Integer rid;//用户类型
	private String name;//姓名
	private String password;//密码
	private String uid;//用户id

}
