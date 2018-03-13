package com.anu.springbootstarter.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anu.springbootstarter.dao.EmpRepository;
import com.anu.springbootstarter.model.Emp;
import com.anu.springbootstarter.service.EmpService;

@Controller
public class JspController {
	@Autowired
	private EmpService ser;
	
	@Autowired
	private EmpRepository empRep;
	
	@GetMapping("/")
	public String getData(HttpServletRequest req){
		req.setAttribute("emps", empRep.findAll());
		req.setAttribute("mode", "DATA_VIEW");
		//System.out.println("Inside controller");
		return "index";
		
		
	}
	@GetMapping("/updateEmp")
	public String getIt(@RequestParam Long id, HttpServletRequest req){
		req.setAttribute("emp", empRep.findOne(id));
		req.setAttribute("mode", "DATA_EDIT");
		
		return "index";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-DD"), true));
		
	}
	@PostMapping("/save")
	public void newEmp(@ModelAttribute Emp emp1,BindingResult result, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		empRep.save(emp1);
		req.setAttribute("emp", empRep.findAll());
		req.setAttribute("mode", "DATA_VIEW");
		resp.sendRedirect("/");
	//return "index";
	}

	@GetMapping("/newdata")
	public String newData(HttpServletRequest req){
		req.setAttribute("mode", "DATA_NEW");
		return "index";
	}
	@GetMapping("/deletedata")
	public void deleteData( @RequestParam long id, HttpServletRequest req, HttpServletResponse resp) throws IOException{
		empRep.delete(id);
		
		req.setAttribute("emp", empRep.findAll());
		req.setAttribute("mode", "DATA_VIEW");
		resp.sendRedirect("/");
	    //return "index";
	}
}
