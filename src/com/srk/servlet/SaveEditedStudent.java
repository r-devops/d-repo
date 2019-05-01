package com.srk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.srk.dao.StudentDAO;

import vo.Student;

@WebServlet("/editStudent2")
public class SaveEditedStudent extends HttpServlet{
	final static Logger logger = Logger.getLogger(SaveEditedStudent.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException { 
			logger.info("Host : " + request.getRemoteHost()+ "  Ip Address : " + request.getRemoteAddr() + " Start");
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String sid=request.getParameter("stdId");  
	        int studentId=Integer.parseInt(sid);  
	        String studentName = request.getParameter("stdname");  
	        String studentAddrs = request.getParameter("stdaddrs");  
	        String studentAge = request.getParameter("stdage");  
	        String studentQual = request.getParameter("stdqual");  
	        String studentPercent = request.getParameter("stdpercent");
	        String studentYearPass = request.getParameter("stdyearpass");
	          
	        Student  student = new Student();  
	        student.setStudentId(studentId); 
	        student.setStudentName(studentName);
        	student.setStudentAddr(studentAddrs);
        	student.setAge(studentAge);
        	student.setQualification(studentQual);
        	student.setPercentage(studentPercent);
        	student.setYearPassed(studentYearPass);  
	          
	        int status=StudentDAO.updateStudent(student);  
	        if(status>0){  
	            response.sendRedirect("viewStudents");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        out.close();  
	    }  
}
