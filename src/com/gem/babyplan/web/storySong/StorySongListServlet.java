package com.gem.babyplan.web.storySong;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.babyplan.entity.StorySong;
import com.gem.babyplan.service.StorySongService;

/**
 * Servlet implementation class StorySongListServlet
 */
//用于展示数据
@WebServlet("/StorySongListServlet")
public class StorySongListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//得到所有对象
		StorySongService sss = new StorySongService();
		List<StorySong> list =sss.getList();
		//System.out.println(list);
		request.setAttribute("mlist", list);
		request.getRequestDispatcher("/page/amusement/storySongList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
