package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.member.domain.MemberVO;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;

public class ModifyMemberForm implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("info");
		
		MemberService service = new MemberServiceImpl();
		vo = service.loginCheck(vo);
		
		session.setAttribute("info", vo);
		
		return "member/modifyMemberForm.tiles";
	}

}
