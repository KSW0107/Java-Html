package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	//key & value 저장할 수 있는 컬렉션 Map
	Map<String, Control> map;
	public FrontController() {
		System.out.println("FrontController() call");
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() call");
		map.put("/main.do", new Maincontrol());
		map.put("/first.do", new FisrtControl());
		map.put("/second.do", new SecondControl());
		//사원 정보 상세 페이지(getMember.jsp)
		map.put("/getMember.do", new GetMemberControl());
		
		//사원정보 수정 페이지(modifyMember.jsp)
		map.put("/modifyMember.do", new ModifyMemberControl());
		
		//사원추가 페이지
		map.put("/addMemberForm.do", new addMemberForm());
		map.put("/addMember.do", new addMemberControl());
		
		//사원삭제
		map.put("/delMemberForm.do", new delMemberForm());
		map.put("/delMember.do", new delMemberControl());
		
		//로그인
		map.put("/loginForm.do", new loginFormControl());
		
		//로그인 처리
		map.put("/login.do", new loginControl());
		
		//로그아웃 처리
		map.put("/logout.do",new logoutControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charser=utf-8");
		
		System.out.println("service() call");
		//url에서 호스트, 포트 부분 외 부분 = uri
		//http://localhost:8081/HelloWeb/empList.jsp - url
		String uri = req.getRequestURI(); // /HelloWeb/empList.jsp - uri
		String context = req.getContextPath(); //context : 프로젝트 이름 (/HelloWeb)
		String page = uri.substring(context.length());
		
		System.out.println(page);
		System.out.println(map.get(page));
		
		Control control = map.get(page);
		control.exec(req, resp);
		
//		Object control = map.get(page);
//		if(page.equals("/first.do"))
//		(InitServlet) Object).service(req, resp);
//		else if(page.equals("/second.do"))
//			Emp
	}

}
