package com.srk.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.srk.dao.StudentDAO;

@WebServlet("/deleteStudent") 
public class DeleteStudent extends HttpServlet {
	final static Logger logger = Logger.getLogger(DeleteStudent.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
		logger.info("Host : " + request.getRemoteHost()+ "  Ip Address : " + request.getRemoteAddr() + " Start");
       String sid=request.getParameter("stdId");  
       int id=Integer.parseInt(sid);  
       StudentDAO.deleteStudent(id);  
       response.sendRedirect("viewStudents");  
   }  
}
