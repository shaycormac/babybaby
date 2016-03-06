package com.gem.babyplan.web.android;

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
 * Servlet implementation class AndroidCartoonServlert
 */
@WebServlet("/AndroidCartoonServlert")
public class AndroidCartoonServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
				CartoonService cService = new CartoonService();
				List<Cartoon> list = cService.selectAll();
				
				//将集合写成json
				Gson gson = new Gson();
				String cartoonList = gson.toJson(list);
				response.getWriter().write(cartoonList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
