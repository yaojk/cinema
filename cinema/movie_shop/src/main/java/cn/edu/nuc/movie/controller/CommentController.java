package cn.edu.nuc.movie.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.nuc.movie.entity.Comment;
import cn.edu.nuc.movie.service.CommentService;
import cn.edu.nuc.movie.utils.PageBean;

@Controller
@RequestMapping("comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String listComment(
			@RequestParam(name="page",defaultValue="1") int page,Model model
			){
		PageBean<Comment> pageBean = commentService.findByPage(page);
		model.addAttribute("pageBean", pageBean);
		
		return "comment/list";
	}
	
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		dateFormat.setLenient(false);  
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteComment(Comment comment){
		
		commentService.deleteByPrimaryKey(comment.getCommentid());
		
		return "redirect:list";
	}
}
