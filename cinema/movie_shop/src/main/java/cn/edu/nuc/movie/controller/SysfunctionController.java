package cn.edu.nuc.movie.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.nuc.movie.entity.Sysfunction;
import cn.edu.nuc.movie.service.SysfunctionService;

@Controller
@RequestMapping("/sysfunctionController")
public class SysfunctionController {

	@Autowired
	private SysfunctionService sysfunctionService;
	
	@RequestMapping(value = "/selectAllFunction", method = RequestMethod.POST)
	public String selectAllFunction(HttpServletRequest request){
		request.setAttribute("funList", sysfunctionService.selectAll());
		return "index";
	}
	
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public String selectAll(HttpServletRequest request){		
		request.setAttribute("funList", sysfunctionService.selectAll());
		return "sysfunction/list";
	}
	/**
	 * 按功能名称查询
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/load1",method = RequestMethod.POST)
	public String load1(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		request.setAttribute("fun", sysfunctionService.findByFun(request.getParameter("funname")));
		return "sysfunction/list";
	}
	
	/**
	 * 按id查找角色信息
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/load",method = RequestMethod.GET)
	public String load(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		request.setAttribute("item", sysfunctionService.selectByPrimaryKey(Integer.parseInt(request.getParameter("id"))));
		return "sysfunction/edit";
	}
	
	/**
	 * 编辑角色
	 * @param sysrole
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(Sysfunction sysfunction,HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		sysfunctionService.updateByPrimaryKey(sysfunction);
		return "redirect:selectAll";
	}
	
	/**
	 * 添加页面的跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ad",method = RequestMethod.GET)
	public String ad(HttpServletRequest request){
		return "sysfunction/add";
	}
	/**
	 * 添加功能
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String add(Sysfunction sysfunction,HttpServletRequest request){
		sysfunctionService.insert(sysfunction);
		return "redirect:selectAll";
	}
}
