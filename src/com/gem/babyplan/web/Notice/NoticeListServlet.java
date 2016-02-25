package com.gem.babyplan.web.Notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.babyplan.entity.Classes;
import com.gem.babyplan.entity.Notice;
import com.gem.babyplan.service.ClassesService;
import com.gem.babyplan.service.NoticeService;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/NoticeListServlet")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String teacherNumber = request.getParameter("teacherNumber");
		String className = request.getParameter("className");
		
		ClassesService cservice = new ClassesService();
		List<Classes> classes = cservice.selectAll();
		
		NoticeService nservice = new NoticeService();
		List<Notice> notice = nservice.selectAll();
		System.out.println(notice);
		request.setAttribute("teacherNumber", teacherNumber);
		System.out.println(teacherNumber);

		request.setAttribute("classes", classes);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/page/classes/noticeList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
