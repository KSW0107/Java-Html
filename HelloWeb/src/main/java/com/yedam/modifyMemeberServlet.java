package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/modifyMemberServlet")
public class modifyMemeberServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmpDAO dao = new EmpDAO();
		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(req.getParameter("id")));
		emp.setFirstName(req.getParameter("fname"));
		emp.setLastName(req.getParameter("lname"));
		emp.setEmail(req.getParameter("email"));
		
		boolean result = dao.modifyMember(emp);
		
		if(result) {
			resp.sendRedirect("empList.jsp");
		}else {
			resp.sendRedirect("modifyMember.jsp");
		}

	}
	
}
