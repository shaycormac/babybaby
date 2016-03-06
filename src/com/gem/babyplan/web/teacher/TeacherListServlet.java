package com.gem.babyplan.web.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.babyplan.entity.Teacher;
import com.gem.babyplan.service.TeacherService;

@WebServlet("/TeacherListServlet")
//教师端的展示列表
public class TeacherListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//返回所有教师信息
		TeacherService tService = new TeacherService();
		List<Teacher> list = tService.getAllTeachers();
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/page/user/teacherList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
