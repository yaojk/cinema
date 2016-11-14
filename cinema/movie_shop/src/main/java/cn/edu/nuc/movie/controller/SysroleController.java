package cn.edu.nuc.movie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.nuc.movie.entity.Sysrole;
import cn.edu.nuc.movie.service.SysroleService;

//@Controller
//@RequestMapping("sysrole")
//public class SysroleController {
//
//	@Autowired
//	private SysroleService sysroleService;
//	
//	@RequestMapping(value="/list",method=RequestMethod.GET)
//	public String listrole(Model model){
//		List<Sysrole> sysroles = sysroleService.allList();
//		model.addAttribute("sysroles", sysroles);
//		return "sysrole/list";
//	}
//	
//	@RequestMapping(value="/add",method=RequestMethod.GET)
//	public String toaddrole(){
//		
//		return "sysrole/add";
//	}
//	
//	@RequestMapping(value="/add",method=RequestMethod.POST)
//	public String addrole(Sysrole role,HttpServletRequest request){
//		int row  =  sysroleService.insert(role);
//		if(row>0){
//			return "redirect:list";
//		}else{
//			request.setAttribute("msg","增加角色失败");
//			return "forward:add";
//		}
//	}
//	
//	
//}
