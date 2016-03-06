package com.gem.babyplan.web.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.babyplan.entity.Student;
import com.gem.babyplan.entity.Teacher;
import com.gem.babyplan.service.StudentService;
import com.gem.babyplan.service.TeacherService;

/**
 * Servlet implementation class StudentListServlet
 * 学生展示页面
 */
@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StudentService service = new StudentService();
		List<Student> list = service.getAllStudent();
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/page/user/studentList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
