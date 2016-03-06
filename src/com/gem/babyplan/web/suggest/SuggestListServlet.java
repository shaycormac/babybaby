package com.gem.babyplan.web.suggest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.babyplan.dao.SuggestDao;
import com.gem.babyplan.entity.Suggest;
import com.gem.babyplan.service.SuggestService;

/**
 * Servlet implementation class SuggestListServlet
 */
@WebServlet("/SuggestListServlet")
public class SuggestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//展示通知，存在list中
		SuggestService suggestService = new SuggestService();
		//得到集合
		List<Suggest> list =suggestService.getSuggestList();
		//将所有的通知发送出去
		request.setAttribute("list", list);
		request.getRequestDispatcher("/page/suggest/suggestList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
