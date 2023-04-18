package com.yedam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

public class delMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		int id =Integer.parseInt(req.getParameter("id"));
		
		EmpDAO dao =new EmpDAO();
		boolean result = dao.deleteEmp(id);
		
		try {
			if(result) {
			resp.sendRedirect("main.do");
		}else {
			resp.sendRedirect("modifyMember.do?id="+id);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
