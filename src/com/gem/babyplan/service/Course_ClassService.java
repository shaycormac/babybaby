package com.gem.babyplan.service;

import java.util.List;

import com.gem.babyplan.dao.Course_ClassDao;
import com.gem.babyplan.entity.Course_Class;

public class Course_ClassService {
	private Course_ClassDao dao = new Course_ClassDao();
	
	// 插入
	public void save(Course_Class course_class) {
		dao.save(course_class);
	}
	
	// 删除,批量删除
	public void delete(int[] courseClassId) {
		dao.delete(courseClassId);
	}
	
	
	
	// 查询所有课程
	public List<Course_Class> selectAll() {
		return dao.selectAll();
	}
	
	// 根据班级id查询班级所有课程
	public List<Course_Class> getCourse_ClassByClassId(String classNumber) {
		return dao.getCourse_ClassByClassNumber(classNumber);
	}
}
