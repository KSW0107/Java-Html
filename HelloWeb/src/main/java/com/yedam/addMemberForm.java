package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addMemberForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		//화면만 출력하면 됨
		try {
			req.getRequestDispatcher("WEB-INF/views/addMember.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
