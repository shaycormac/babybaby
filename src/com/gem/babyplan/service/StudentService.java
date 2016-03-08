package com.gem.babyplan.service;

import java.util.ArrayList;
import java.util.List;

import com.gem.babyplan.dao.ClassesDao;
import com.gem.babyplan.dao.StudentDao;
import com.gem.babyplan.entity.Classes;
import com.gem.babyplan.entity.Student;

/**
* @author 炳华儿 E-mail: 574583006@qq.com
* @date  创建时间：2016年3月6日 下午3:36:30 
* @parameter   
* @return 
*/
public class StudentService 
{
	StudentDao sDao = new StudentDao();
	
	//根据学生的num查找学生
	public Student getStudentByNum (String studentNum)
	{
		return sDao.getStudentByNumber(studentNum);
	}
	//返回所有的学生对象,需要展示班级名称，取出来
	public List<Student> getAllStudent()
	{
		List<Student> list =sDao.getAllStudent();
		List<Student> list2 = new ArrayList<>();
		ClassesDao cDao = new ClassesDao();
		Classes classes =null;
		for (Student student : list)
		{
			classes =cDao.getClassesByClassNumber(student.getClasses().getClassNumber());
			student.setClasses(classes);
			list2.add(student);
		}
		return list2;
	}
	//储存学生对象
	public void addStudent(Student student)
	{
		sDao.addStudent(student);
	}

}
