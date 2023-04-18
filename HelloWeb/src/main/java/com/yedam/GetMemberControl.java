package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class GetMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		//매개값으로 사원번호
		String id = req.getParameter("id");
		EmpDAO dao = new EmpDAO();
		Employee emp = dao.getEmp(Integer.parseInt(id));
		req.setAttribute("empInfo", emp); // 재정의되는 페이지에 정보를 넘기기위해 요청(req)에 저장 (이름,보낼값)
		
		//페이지를 재지정. control -> getMember.jsp
		try {
			req.getRequestDispatcher("WEB-INF/views/getMember.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
