package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wendao.pojo.Log;
import com.wendao.service.LogService;
import com.wendao.service.impl.LogServiceImpl;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private LogService ls = new LogServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Log log = new Log();
		log.setAccIn(req.getParameter("accin"));
		log.setAccOut(req.getParameter("accout"));
		log.setMoney(Double.parseDouble(req.getParameter("money")));
		
		int index = ls.ins(log);
		if(index > 0) {
			resp.sendRedirect("success.jsp");
			return;
			
		} else {
			resp.sendRedirect("error.jsp");
			return;
		}
		
	}

}










