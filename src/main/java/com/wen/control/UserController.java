package com.wen.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wen.po.User;
import com.wen.service.SendService;
import com.wen.service.UserService;

@Controller
public class UserController {
	@Resource
	UserService userService;
	@Resource
	SendService sendService;
	
	@RequestMapping("/register")
	public String UserRegister(Model model,User user){
		userService.addUser(user);
		model.addAttribute("msg", "�û�ע��ɹ������¼���������֤��");
		sendService.send(user);
		
		
		return "/";
		
	}
	
	@RequestMapping("/activate")
	public String activate(Model model,User user){
		int n = userService.updateUser(user);
		System.out.println(n);
		if(n>0){
		model.addAttribute("msg", "�û�����ɹ�����ӭʹ�ã�");
		}
		return "/";
	}
}
