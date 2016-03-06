package com.gem.babyplan.web.cartoon;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.babyplan.entity.Cartoon;
import com.gem.babyplan.service.CartoonService;
import com.google.gson.Gson;

/**
 * Servlet implementation class CarToonListServlet
 * 返回所有的动漫列表
 */
@WebServlet("/CarToonListServlet")
public class CarToonListServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		CartoonService cService = new CartoonService();
		List<Cartoon> list = cService.selectAll();
		//进行判断
		if (list.size()==0)
		{
			request.setAttribute("empty", "当前没有任何动漫，请添加！！");
			request.getRequestDispatcher("").forward(request, response);
		}else {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/page/amusement/cartoonList.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
