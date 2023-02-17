package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDAO;

public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		int sid = Integer.parseInt(req.getParameter("sid"));
		String password = req.getParameter("password");
		
		StudentDAO dao = new StudentDAO();
		
		String dbpasssword=dao.login(sid);
		if(dbpasssword.equals(password)) {
			resp.sendRedirect("https://stackoverflow.com/");
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("logIn.html");
			dispatcher.forward(req, resp);
		}
	}

}
