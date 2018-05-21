package com.wang.dao;

import java.util.List;

import com.jason.annotations.Select;
import com.wang.beans.Student;

public interface StudentDao {

	@Select("select * from student")
	public List<Student> queryStudent();
	
}
