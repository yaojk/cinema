package cn.edu.nuc.movie.controller;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.nuc.movie.entity.User;
import cn.edu.nuc.movie.service.UserService;

@Controller
@RequestMapping("userfront")
public class UserFrontController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage(){
		
		return "redirect:/login.jsp";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,Model model,HttpSession session){
		User existUser = userService.login(user.getUsername(), user.getPassword());
		if(existUser == null){
			model.addAttribute("msg","登录失败，请重新登录");
			return "forward:/login.jsp";
		}else{
			session.setAttribute("existUser", existUser);
			return "redirect:/index/frontlist";
		}
	}
	
	@RequestMapping("/destory")
	public String quit(HttpSession session){
		 session.invalidate();
		 return "redirect:/index/frontlist";
	}
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public String regist(){
		return "redirect:/regist.jsp";
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(User user,String checkcode,HttpSession session){
		String checkcode1 = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);// 生成的验证码
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			session.setAttribute("msg","验证码输入不正确,请重新输入");
			return "redirect:/regist.jsp";
		}
		userService.insert(user);
		session.setAttribute("msg","成功注册，请去登录");
		return "redirect:/msg.jsp";
	}
	
	@RequestMapping(value="/byname",method=RequestMethod.GET)
	public @ResponseBody Object findByName(User user,HttpServletResponse response) throws Exception{
		User existUser = userService.findByUname(user);
		//获得response对象，项目页面输出:
		response.setContentType("text/html;charset=UTF-8");
		if(existUser != null){
			//查询到该用户：用户名已经存在
			return "<font color='red'>用户名已经存在</font>";
		}else{
			return "<font color='green'>用户名可以使用</font>";
		}
	}
	
	
}
