package cn.edu.nuc.movie.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.nuc.movie.entity.Category;
import cn.edu.nuc.movie.entity.Movie;
import cn.edu.nuc.movie.service.CategoryService;
import cn.edu.nuc.movie.service.MovieService;

@Controller
@RequestMapping("index")
public class IndexController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/frontlist",method=RequestMethod.GET)
	public String frontlist(Model model,HttpSession session){
		
		List<Movie> listnew = movieService.listMovieNew();
		
		List<Movie> listhot = movieService.listMovieHot();
		
		List<Category> clist = categoryService.findAll();
		session.setAttribute("clist", clist);
		
		model.addAttribute("listnew", listnew);
		model.addAttribute("listhot", listhot);
		
		return "forward:/main.jsp";
	}
}
