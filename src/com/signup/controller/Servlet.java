package com.signup.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.signup.entity.Entity;
import com.signup.service.Service;
import com.signup.service.ServiceInterface;

public class Servlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter io=response.getWriter();
		io.println("<html><body>");
		
		String option=request.getParameter("ac");
		
		if (option.equals("register")) {
			String name=request.getParameter("Name");
			String email=request.getParameter("Email");
			String username=request.getParameter("Username");
			String address=request.getParameter("Address");
			String password=request.getParameter("Password");
			
			Entity e=new Entity();
			e.setName(name);
			e.setEmail(email);
			e.setAddress(address);
			e.setUsername(username);
			e.setPassword(password);
			
			ServiceInterface si=Service.createServiceObject("si");
			int i=si.createProfile(e);
			
			if (i>0) {
				io.println("Profile created ");
			} 
			else {
				io.println("Profile not created ");
			}
		}
		io.println("</body></html>");
	}

}
