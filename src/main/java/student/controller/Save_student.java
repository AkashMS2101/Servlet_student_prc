package student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDAO;
import student.dto.Student;

public class Save_student extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String father_name=req.getParameter("fathername");
		String mother_name=req.getParameter("mothername");
		String email =req.getParameter("email");
		String password = req.getParameter("password");
//		String school = req.getParameter("school");
//		long fees =Long.parseLong(req.getParameter("fees"));
		
		ServletContext context = getServletContext();
		String school = context.getInitParameter("school");
		
		ServletConfig config = getServletConfig();
		long fee = Long.parseLong(config.getInitParameter("fees"));
		
		System.out.println(school);
		System.out.println(fee);
		
		Student student= new Student();
		student.setEmail(email);
		student.setFather_name(father_name);
		student.setMother_name(mother_name);
		student.setName(name);
		student.setPassword(password);
		student.setSchool(school);
		student.setFees(fee);
		
		StudentDAO dao = new StudentDAO();
		dao.saveStudent(student);
		
		RequestDispatcher dispatcher =req.getRequestDispatcher("form2.html");
		dispatcher.forward(req, resp);
	}
}
