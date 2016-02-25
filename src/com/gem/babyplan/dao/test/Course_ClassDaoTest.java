package com.gem.babyplan.dao.test;

import java.util.List;

import org.junit.Test;

import com.gem.babyplan.dao.Course_ClassDao;
import com.gem.babyplan.entity.Classes;
import com.gem.babyplan.entity.Course;
import com.gem.babyplan.entity.Course_Class;

public class Course_ClassDaoTest {
	private Course_ClassDao dao = new Course_ClassDao();
	
	//插入
	@Test
	public void saveTest(){
		Classes classes = new Classes();
		classes.setClassNumber("A02");
		Course course = new Course();
		course.setCourseId(2);
		Course_Class course_class = new Course_Class();
		course_class.setClasses(classes);
		course_class.setCourse(course);
		course_class.setDayNumber("第三节");
		course_class.setWeekDay("星期二");
		dao.save(course_class);
	}
	
	//刪除，批量刪除
	@Test
	public void deleteTest(){
		int[] courseClassId = {3};
		dao.delete(courseClassId);
	}
	
	//修改
	@Test
	public void updateTest(){
		Classes classes = new Classes();
		classes.setClassNumber("A03");
		Course course = new Course();
		course.setCourseId(3);
		Course_Class course_class = new Course_Class();
		course_class.setClasses(classes);
		course_class.setCourse(course);
		course_class.setDayNumber("第yi节");
		course_class.setWeekDay("星期天");
		dao.save(course_class);
	}
	
	//查询
	@Test
	public void selectAllTest(){
		List<Course_Class> list = dao.selectAll();
		for (Course_Class course_Class : list) {
			System.out.println(course_Class.getCourse().getCourseId()+","+
					course_Class.getClasses().getClassNumber());
		}
	}
	
	// 根据班级id查询班级所有课程
	@Test
	public void getCourse_ClassByClassIdTest(){
		String classNumber = "A03";
		List<Course_Class> list = dao.getCourse_ClassByClassNumber(classNumber);
		for (Course_Class course_Class : list) {
			System.out.println(course_Class.getCourse().getCourseId()+","+
					course_Class.getClasses().getClassNumber());
		}
	}
}
