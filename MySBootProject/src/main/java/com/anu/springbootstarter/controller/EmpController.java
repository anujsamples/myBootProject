package com.anu.springbootstarter.controller;

import java.util.Collection;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu.springbootstarter.dao.EmpRepository;
import com.anu.springbootstarter.model.Emp;
import com.anu.springbootstarter.service.EmpService;
import com.anu.springbootstarter.service.IEmpService;

@RestController
@RequestMapping("/api")
public class EmpController {
	
	@Autowired
	private EmpRepository empRep;
	
	@Autowired
	private EmpService empSer;
	//private IEmpService empSer;
	
	/*public void setIEmpService(IEmpService empSer)
	{
		this.empSer = empSer;
	}*/
	
	@GetMapping("/list")
	public List<Emp> listAll(Model model){
		//model.addAttribute("emp1", empSer.findAllEmps());
		
		return empSer.findAllEmps();
	}
	@RequestMapping("/list/{id}")
	public Emp getone(@PathVariable long id){
		return empSer.getOne(id);
		
	}
	
	
	@GetMapping("/emp")
	public List<Emp> getAllEmps(){
		System.out.println("inside controller");
		return  (List<Emp>) empRep.findAll();
		
	}
	
	@GetMapping("/emp/{id}")
	public Emp getEmp(@PathVariable Long id){
		return empRep.findOne(id);
		
	}
	
	@DeleteMapping("/emp/{id}")
	public boolean deleteEmp(@PathVariable Long id){
		empRep.delete(id);
		return true;
	}
	@PostMapping("/emp")
	public Emp createEmp(Emp emp){
		System.out.println("create new emp");
		return empRep.save(emp);
		
		
		
	}

}
