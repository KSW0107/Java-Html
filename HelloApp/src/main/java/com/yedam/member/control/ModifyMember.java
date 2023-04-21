package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.member.domain.MemberVO;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;

public class ModifyMember implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		
		MemberVO vo = new MemberVO();
		
		vo.setEmail(email);
		vo.setPassword(pass);
		vo.setPhone(phone);
		vo.setAddress(address);
		
		MemberService service = new MemberServiceImpl();
		boolean result = service.updateMember(vo);
		if(result) {
			return "main.do";
		}else {
			return "modifyMemberForm.do";
		}
	}

}
