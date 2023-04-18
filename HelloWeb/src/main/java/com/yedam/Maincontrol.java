package com.yedam;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class Maincontrol implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			EmpDAO dao = new EmpDAO();
			List<Employee> list = dao.getEmpList();
			
			req.setAttribute("listInfo", list);
				
			//페이지 재지정 (,resp.sendRedirect();)
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/empList.jsp");
			rd.forward(req, resp);
//			req.getRequestDispatcher("WEB-INF/views/empList.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
