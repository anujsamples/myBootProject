package com.anu.springbootstarter.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anu.springbootstarter.model.Emp;

public interface EmpRepository extends CrudRepository<Emp, Long> {
	//public List<Emp> findAllEmps();
}
