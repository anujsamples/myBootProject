package com.anu.springbootstarter.service;

import java.util.List;

import com.anu.springbootstarter.model.Emp;

public interface IEmpService {
	public List<Emp> findAllEmps();
}
