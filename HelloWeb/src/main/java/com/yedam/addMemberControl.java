package com.yedam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class addMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		Employee emp = new Employee();

		int id = Integer.parseInt(req.getParameter("id"));
		String lname = req.getParameter("lname");
		String fname = req.getParameter("fname");
		String email = req.getParameter("email");
		String hire = req.getParameter("hire");
		String job = req.getParameter("job");

		emp.setEmployeeId(id);
		emp.setFirstName(fname);
		emp.setLastName(lname);
		emp.setEmail(email);
		emp.setHireDate(hire);
		emp.setJobId(job);

		EmpDAO dao = new EmpDAO();
		boolean result = dao.insertEmployee(emp);

		try {
			if (result) {
				resp.sendRedirect("main.do");
			} else {
				resp.sendRedirect("addMemberForm.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
