package com.yedam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class loginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// 사원번호(100), 이메일(SKING) 입력시 조회
		String empId = req.getParameter("uname");
		String email = req.getParameter("psw");

		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(empId));
		emp.setEmail(email);
		System.out.println("1: " + emp);

		EmpDAO dao = new EmpDAO();
		emp = dao.loginCheck(emp);
		System.out.println("2: " + emp);

		try {
			if (emp == null) {
				resp.sendRedirect("loginForm.do");
			} else {
				// request 객체 / session 객체
				// session 객체는 웹브라우저 닫기 전까지 데이터유지
				req.setAttribute("reqInfo", emp.getFirstName());

				HttpSession session = req.getSession();
				session.setAttribute("sesInfo", emp.getLastName());

				resp.sendRedirect("main.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
