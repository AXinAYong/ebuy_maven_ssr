package com.lcvc.ebuy_maven_ssr.web;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns="/hello")
public class HelloServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
		session.setAttribute("name","三三");
		response.sendRedirect("hello.jsp");
		
		/*request.setAttribute("name", "阿四");
		request.getRequestDispatcher("hello.jsp").forward(request, response);*/
		
		
		
	}

	

}
