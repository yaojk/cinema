package cn.edu.nuc.movie.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.nuc.movie.entity.User;
import cn.edu.nuc.movie.service.UserService;
import cn.edu.nuc.movie.utils.PageBean;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String listUser(
			@RequestParam(name="page",defaultValue="1") int page,Model model
			){
		PageBean<User> pageBean = userService.findByPage(page);
		model.addAttribute("pageBean", pageBean);
		
		return "user/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAddUser(Model model){
		
		return "user/add";
	}
	

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String AddUser(User user) throws IOException {
			
		userService.insert(user);
		return "redirect:list";
	}

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteUser(User user){
		
		userService.deleteByPrimaryKey(user.getUid());
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String toedit(User user,ModelMap map){
		
		User users = userService.selectByPrimaryKey(user.getUid());
		
		map.addAttribute("users", users);
	
		return "user/edit";
	}
	

	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(User user) throws IOException{
	
		userService.updateByPrimaryKey(user);
	
		return "redirect:list";
	}
	
	@RequestMapping(value="/find",method=RequestMethod.POST)
	public String findByUname(User user,Model model){
		
		User u = userService.findByUname(user);
		
		model.addAttribute("user", u);
		
		return "user/list";
	}
	
	
}
