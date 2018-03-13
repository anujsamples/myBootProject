package com.anu.springbootstarter.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu.springbootstarter.dao.EmpRepository;
import com.anu.springbootstarter.model.Emp;

@Service
public class EmpService {
	@Autowired
	DataSource dataSource;
    @Autowired
	private EmpRepository empRep;
    
    public List<Emp> findAllEmps()
    {
    	
    	return (List<Emp>) empRep.findAll();
    	 //System.out.println("DATASOURCE = " + dataSource);

        // System.out.println("\n1.findAll()...");
    	//List<Emp> e = new ArrayList<Emp>();
    	//empRep.findAll().forEach(e::add);
    	/*for(Emp  emp1: empRep.findAll())
    	{
    		System.out.println(emp1);
    		e.add(emp1);
    	}*/
    	//System.out.println("inside service");
    	
    }
    
    public Emp getOne(long id)
    {
    	return empRep.findOne(id);
    }
    
    public void delete(Long id){
    	empRep.delete(id);
    	
    }
 
}
