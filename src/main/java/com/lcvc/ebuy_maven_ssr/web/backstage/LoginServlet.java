package com.lcvc.ebuy_maven_ssr.web.backstage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lcvc.ebuy_maven_ssr.dao.AdminDao;
import  com.lcvc.ebuy_maven_ssr.dao.DBHelper;
@WebServlet(urlPatterns="/backstage/login")
public class LoginServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		AdminDao adminDao=new AdminDao();
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		
		
		String username=request.getParameter("name");
		String password=request.getParameter("pass");
		System.out.println("name");
		System.out.println("pass");
		
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		
		if (adminDao.login(username, password)) {
			
			
			System.out.println("登录成功");
			response.sendRedirect(basePath+"jsp/admin/main.html");
		} else {
			System.out.println("登录失败");
			response.sendRedirect(basePath+"jsp/admin/login.jsp");

		}
		
		
		
	
		

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
