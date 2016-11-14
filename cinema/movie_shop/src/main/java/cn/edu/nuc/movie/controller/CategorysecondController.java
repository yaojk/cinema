package cn.edu.nuc.movie.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.nuc.movie.entity.Category;
import cn.edu.nuc.movie.entity.Categorysecond;
import cn.edu.nuc.movie.service.CategoryService;
import cn.edu.nuc.movie.service.CategorysecondService;
import cn.edu.nuc.movie.utils.PageBean;

@Controller
@RequestMapping("categorysecond")
public class CategorysecondController {

	@Autowired
	private CategorysecondService categorysecondService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String listCategorysecondByPage(
			@RequestParam(name="page",defaultValue="1") int page,Model model
			){
		PageBean<Categorysecond> pageBean = categorysecondService.findByPage(page);
		
		model.addAttribute("pageBean", pageBean);
	
		return "categorysecond/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAddCategorysecond(Model model){
		//准备一级分类数据
		List<Category> cList = categoryService.findAll();
		model.addAttribute("cList", cList);
		return "categorysecond/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String AddCategorysecond(Categorysecond categorysecond) throws IOException {
			
		categorysecondService.insert(categorysecond);
		
		return "redirect:list";
	}

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteCategorysecond(Categorysecond categorysecond){
		
		categorysecondService.deleteByPrimaryKey(categorysecond.getCsid());
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String toedit(Categorysecond categorysecond,ModelMap map){
		
		Categorysecond  cs = categorysecondService.selectByPrimaryKey(categorysecond.getCsid());
		
		map.addAttribute("categorysecond", cs);
		
		//准备一级分类数据
		List<Category> cList = categoryService.findAll();
		map.addAttribute("cList", cList);
		
		return "categorysecond/edit";
	}
	
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		dateFormat.setLenient(false);  
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(Categorysecond categorysecond) throws IOException{
		categorysecondService.updateByPrimaryKey(categorysecond);
		return "redirect:list";
	}
	
}
