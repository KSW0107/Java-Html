package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/searchMember")
public class GetMemberServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
	  	int id = Integer.parseInt(req.getParameter("id"));
	  	
	  	EmpDAO dao = new EmpDAO();
	  	Employee emp = dao.getEmp(id);
	  	
	  	if(emp != null) {
	  		out.print("<table border='1'>");
	  		out.print("<thead><tr><th>사원번호</th><th>FirstName</th><th>LasttName</th><th>email</th><th>JobId</th><th>HireDate</th></tr></thead>");
	  		out.print("<tbody>");
	  		out.print("<tr><td>"+emp.getEmployeeId()
			+"</td><td>"+emp.getFirstName()
			+"</td><td>"+emp.getLastName()
			+"</td><td>"+emp.getEmail()
			+"</td><td>"+emp.getJobId()
			+"</td><td>"+emp.getHireDate()
			+"</td></tr>");
	  		out.print("</tbody>");
	  		out.print("</table>");
	  	} else {
	  		resp.sendRedirect("searchForm.html");
	  	}
		
	}
	
}
