package cn.edu.nuc.movie.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.nuc.movie.entity.Sysadmin;
import cn.edu.nuc.movie.service.SysadminService;


@Controller
@RequestMapping("/admin")
public class SysadminController {

	@Autowired
	private SysadminService sysadminService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(HttpSession session){
		
		if(session.getAttribute("admintruename")==null ){
			
			session.setAttribute("msg", "用户还没有登录");
			
			return "login";
		}
		
		return "home";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String tologin(){
		
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Sysadmin sysadmin,HttpSession session){
		try {
			Sysadmin existadmin = sysadminService.login(sysadmin.getAdminname(), sysadmin.getAdminpwd());
		
			session.setAttribute("admintruename", existadmin.getAdmintruename());
			
			session.removeAttribute("msg");
			
			return "redirect:/admin/";
		
		} catch (Exception e) {
			
			session.setAttribute("msg", "用户或密码错误");
		}
		
		return "redirect:/admin/login";
	}
}
