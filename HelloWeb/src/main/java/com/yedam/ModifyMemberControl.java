package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class ModifyMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// view에서 요청한 method를 구분 GET/POST
//		req.getMethod();
		if (req.getMethod().equals("GET")) {

			// id 파라미터
			// MVC 패턴 -> 컨트롤러에서는DB의 처리, view 화면으로 정보 전송
			// emp 변수에 조회결과를 담아서 empInfo의 속성으로 modifyMember.jsp 재지정

			String id = req.getParameter("id");
			EmpDAO dao = new EmpDAO();
			Employee result = dao.getEmp(Integer.parseInt(id));

			req.setAttribute("empInfo", result);

			try {
				req.getRequestDispatcher("WEB-INF/views/modifyMember.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else if (req.getMethod().equals("POST")) {
			// DB에 업데이트 처리, 수정 완료시 목록 이동
			String id = req.getParameter("id");
			String fname = req.getParameter("fname");
			String lname = req.getParameter("lname");
			String email = req.getParameter("email");

			Employee emp = new Employee();
			emp.setEmployeeId(Integer.parseInt(id));
			emp.setFirstName(fname);
			emp.setLastName(lname);
			emp.setEmail(email);

			EmpDAO dao = new EmpDAO();
			boolean result = dao.modifyMember(emp);
			try {
				if (result) {
					resp.sendRedirect("main.do");
				} else {
					resp.sendRedirect("modifyMember.do");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
