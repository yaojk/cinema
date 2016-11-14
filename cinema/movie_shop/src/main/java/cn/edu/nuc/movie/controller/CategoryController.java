package cn.edu.nuc.movie.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import cn.edu.nuc.movie.entity.Category;
import cn.edu.nuc.movie.service.CategoryService;


@Controller
@RequestMapping("category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// 查询所有一级分类
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String findAllCategory(Model model){
		
		List<Category> list = categoryService.findAll();
		model.addAttribute("categorys",list);
		
		return "category/list";
	}

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAddCategory(){
		return "category/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String AddCategory(Category category) throws IOException {
			
		categoryService.insert(category);
		
		return "redirect:list";
	}

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteCategory(Category category){
		
		categoryService.deleteByPrimaryKey(category.getCid());
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String toedit(Category category,ModelMap map){
		
		Category cg = categoryService.selectByPrimaryKey(category.getCid());
		
		map.addAttribute("category", cg);
		
		return "category/edit";
	}
	
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		dateFormat.setLenient(false);  
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(Category category) throws IOException{
	
		categoryService.updateByPrimaryKey(category);
	
		return "redirect:list";
	}
	
}
