package cn.edu.nuc.movie.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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
import org.springframework.web.multipart.MultipartFile;

import cn.edu.nuc.movie.entity.Categorysecond;
import cn.edu.nuc.movie.entity.Movie;
import cn.edu.nuc.movie.service.CategorysecondService;
import cn.edu.nuc.movie.service.MovieService;
import cn.edu.nuc.movie.utils.IPTimeStamp;
import cn.edu.nuc.movie.utils.PageBean;

@Controller
@RequestMapping("movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CategorysecondService categorysecondService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String listMovie(
			@RequestParam(name="page",defaultValue="1") int page,Model model
			){
		PageBean<Movie> pageBean = movieService.findByPage(page);
		model.addAttribute("pageBean", pageBean);
		
		return "movie/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAddMovie(Model model){
		
		//准备二级分类数据

		List<Categorysecond> cList = categorysecondService.findAll();
		model.addAttribute("cList", cList);
		return "movie/add";
	}
	

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String AddMovie(Movie movie, @RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws IOException {
			
			//获取文件 存储位置
			String realPath = request.getSession().getServletContext()
					.getRealPath("/upload");
			File pathFile = new File(realPath);
			
			if (!pathFile.exists()) {
				//文件夹不存 创建文件
				pathFile.mkdirs();
			}
				System.out.println("文件类型："+file.getContentType());
				System.out.println("文件名称："+file.getOriginalFilename());
				System.out.println("文件大小:"+file.getSize());
				System.out.println(".................................................");
				//将文件copy上传到服务器
				//file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
				
			IPTimeStamp ip = new IPTimeStamp();
				
			System.out.println(ip.getTimeStamp());
				
			String ext =FilenameUtils.getExtension(file.getOriginalFilename());
				
			String newfilename= ip.getTimeStamp() + "."+ ext;
				
			FileUtils.copyInputStreamToFile(file.getInputStream(), 
						new File(realPath, newfilename));
			//获取modelandview对象

		movie.setMimage(newfilename);
		
		movieService.insert(movie);
		
		return "redirect:list";
	}

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteMovie(Movie movie){
		
		movieService.deleteByPrimaryKey(movie.getMovieid());
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String toedit(Movie movie,ModelMap map){
		
		Movie mv = movieService.selectByPrimaryKey(movie.getMovieid());
		
		map.addAttribute("movie", mv);
		
		//准备二级分类数据

		List<Categorysecond> cList = categorysecondService.findAll();
		map.addAttribute("cList", cList);
		
		return "movie/edit";
	}
	
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		dateFormat.setLenient(false);  
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(Movie movie, @RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws IOException{
	
		Movie mv = movieService.selectByPrimaryKey(movie.getMovieid());
		//获取文件 存储位置
		if(file.getOriginalFilename()!=null && !file.getOriginalFilename().equals("")){
			String realPath = request.getSession().getServletContext()
					.getRealPath("/upload");
			
			File oldfile = new File(realPath +"/"+ mv.getMimage());
			oldfile.delete();
			
			File pathFile = new File(realPath);
			
			if (!pathFile.exists()) {
				//文件夹不存 创建文件
				pathFile.mkdirs();
			}
				System.out.println("文件类型："+file.getContentType());
				System.out.println("文件名称："+file.getOriginalFilename());
				System.out.println("文件大小:"+file.getSize());
				System.out.println(".................................................");
				//将文件copy上传到服务器
				//file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
				
				IPTimeStamp ip = new IPTimeStamp();
				String ext =FilenameUtils.getExtension(file.getOriginalFilename());
				
				String newfilename= ip.getTimeStamp() + "."+ ext;
				
				
				FileUtils.copyInputStreamToFile(file.getInputStream(), 
						new File(realPath, newfilename));
			//获取modelandview对象
				
				movie.setMimage(newfilename);
		}	
		
		if(file.getOriginalFilename()==null || "".equals(file.getOriginalFilename())){
		  movie.setMimage(movieService.selectByPrimaryKey(movie.getMovieid()).getMimage());
		}
		movieService.updateByPrimaryKey(movie);
	
		return "redirect:list";
	}
	
//	@RequestMapping(value="/find",method=RequestMethod.POST)
//	public String findByPname(@Param("pname") String pname,Model model){
//		
//		System.out.println(pname+"---------------------------");
//		
//		List<Product> li = productService.findByName(pname);
//		
//		model.addAttribute("list", li);
//		
//		return "product/list";
//	}
	
	//前台
	
	
	//前台
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(Movie movie,Model model){
			
	    Movie mv = movieService.selectByPrimaryKey(movie.getMovieid());
			
		model.addAttribute("movie", mv);
			
		return "forward:/detail.jsp";
    }
	
}
