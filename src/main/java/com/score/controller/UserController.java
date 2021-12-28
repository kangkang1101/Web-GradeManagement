package com.score.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.score.bean.ResultObject;
import com.score.bean.User;
import com.score.service.UserService;
import com.score.util.Constant;

/**
 * @author hmg
 *
 */
@RequestMapping("/user")
@RestController //标识为返回类型为Json的控制器
public class UserController {
	
	//自动注入服务类
	@Autowired
	private UserService userService;
	

	
    //标识请求地址
    @RequestMapping("/login")
    public ResultObject<List<User>> getUsers(User user,HttpServletRequest request) {
    	//查询用户列表
		System.out.print("user为："+user.getUid());
    	List<User> list= userService.getUser(user);
		System.out.print("user为："+user.getUid());
    	ResultObject<List<User>> rs=new ResultObject<List<User>>();
    	if(list.isEmpty()) {
    		//状态码
        	rs.setCode(Constant.FAILURE_RETUEN_CODE);
        	//提示
        	rs.setMsg("登录失败");
    	}else {
    		//状态码
        	rs.setCode(Constant.SUCCESS_RETUEN_CODE);
        	System.out.print("List中的值为");
        	System.out.print(list.get(0).getUid());
        	request.getSession().setAttribute("user", list.get(0));
        	//提示
        	rs.setMsg("登录成功");
    	}    	
    	//数据
    	rs.setData(list);
        return rs;
    }
    @RequestMapping("/loginOut")
    public ResultObject<Object> loginOut(HttpServletRequest request) {
    	//查询用户列表
    	ResultObject<Object> rs=new ResultObject<Object>();
    	//request.getSession().removeAttribute("user");
    	//数据
    	rs.setCode(Constant.SUCCESS_RETUEN_CODE);
    	rs.setMsg("退出成功");
        return rs;
    }
    
    //标识请求地址
    @RequestMapping("/adminlogin")
	public ResultObject<List<User>> getadmin(User user,HttpServletRequest request) {
    	System.out.print("user为："+user.getUid());
		//查询用户列表
		List<User> list= userService.getUser(user);
		System.out.print("user为："+user.getUid());
		ResultObject<List<User>> rs=new ResultObject<List<User>>();
		if(list.isEmpty()) {
			//状态码
			rs.setCode(Constant.FAILURE_RETUEN_CODE);
			//提示
			rs.setMsg("登录失败");
		}else {
			//状态码
			rs.setCode(Constant.SUCCESS_RETUEN_CODE);
			System.out.print("List中的值为");
			System.out.print(list.get(0).getUid());
			request.getSession().setAttribute("user", list.get(0));
			//提示
			rs.setMsg("登录成功");
		}
		//数据
		rs.setData(list);
		return rs;
	}

	@RequestMapping("/studentlogin")
	public ResultObject<List<User>> getStudent(User user,HttpServletRequest request) {
		//查询用户列表
		System.out.print("user为："+user.getUid());
		List<User> list= userService.getUser(user);
		System.out.print("user为："+user.getUid());
		ResultObject<List<User>> rs=new ResultObject<List<User>>();
		if(list.isEmpty()) {
			//状态码
			rs.setCode(Constant.FAILURE_RETUEN_CODE);
			//提示
			rs.setMsg("登录失败");
		}else {
			//状态码
			rs.setCode(Constant.SUCCESS_RETUEN_CODE);
			System.out.print("List中的值为");
			System.out.print(list.get(0).getUid());
			request.getSession().setAttribute("user", list.get(0));
			//提示
			rs.setMsg("登录成功");
		}
		//数据
		rs.setData(list);
		return rs;
	}

    @RequestMapping("/studentloginOut")
    public ResultObject<Object> studentloginOut(HttpServletRequest request) {
    	//查询用户列表
    	ResultObject<Object> rs=new ResultObject<Object>();
    	request.getSession().removeAttribute("student");	
    	//数据
    	rs.setCode(Constant.SUCCESS_RETUEN_CODE);
    	rs.setMsg("退出成功");
        return rs;
    }
    
    
 
}
