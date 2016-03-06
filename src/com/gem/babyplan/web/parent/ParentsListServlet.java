package com.gem.babyplan.web.parent;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.babyplan.entity.Parent;
import com.gem.babyplan.entity.Teacher;
import com.gem.babyplan.service.ParentsService;
import com.gem.babyplan.service.TeacherService;

/**
 * Servlet implementation class ParentsListServlet
 */
@WebServlet("/ParentsListServlet")
//家长显示页面
public class ParentsListServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//返回所有家长信息
		ParentsService pService = new ParentsService();
		List<Parent> list =pService.getAllParents() ;
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/page/user/parentList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
