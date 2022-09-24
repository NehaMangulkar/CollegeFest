package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.dao.StudentDao;
import com.gl.model.Student;

@Controller
@RequestMapping("students")
public class StudentController {
	@Autowired
	StudentDao studentDao;
	
	@GetMapping("list")
	public String showStudents(Model model)
	{
		List<Student> students=studentDao.findAll();
		model.addAttribute("students", students);
		return "student-list";
		
	}

}
