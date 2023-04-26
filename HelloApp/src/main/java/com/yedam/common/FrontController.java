package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.member.control.LoginControl;
import com.yedam.member.control.LoginFormControl;
import com.yedam.member.control.LogoutControl;
import com.yedam.member.control.ModifyMember;
import com.yedam.member.control.ModifyMemberForm;
import com.yedam.member.control.addEventControl;
import com.yedam.member.control.eventListControl;
import com.yedam.member.control.removeEventControl;
import com.yedam.notice.control.AddNoticeControl;
import com.yedam.notice.control.AddReplyControl;
import com.yedam.notice.control.DeleteNoticeControl;
import com.yedam.notice.control.GetNoticeControl;
import com.yedam.notice.control.ModifyNoticeControl;
import com.yedam.notice.control.ModifyReplyControl;
import com.yedam.notice.control.NoticeAddForm;
import com.yedam.notice.control.NoticeListControl;
import com.yedam.notice.control.RemoveReplyControl;
import com.yedam.notice.control.ReplyListControl;

public class FrontController extends HttpServlet {
	String encoding;

	private Map<String, Control> map;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override // 초기화 (생성자랑 비슷한 역할 )
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		// 첫페이지
		map.put("/main.do", new MainControl());
		// 공지사항
		map.put("/noticeList.do", new NoticeListControl());
		// 공지사항등록 폼
		map.put("/noticeAddForm.do", new NoticeAddForm());
		// 공지사항등록
		map.put("/addNotice.do", new AddNoticeControl());
		//공지사항단독조회
		map.put("/getNotice.do", new GetNoticeControl());
		//공지사항수정
		map.put("/modifyNotice.do", new ModifyNoticeControl());
		//공지사항삭제
		map.put("/deleteNotice.do", new DeleteNoticeControl());
		
		
		//회원관련
		//로그인화면
		map.put("/loginForm.do", new LoginFormControl());
		//로그인
		map.put("/login.do", new LoginControl());
		//로그아웃
		map.put("/logout.do", new LogoutControl());
		//회원정보수정 폼
		map.put("/modifyMemberForm.do", new ModifyMemberForm());
		//회원정보수정
		map.put("/modifyMember.do", new ModifyMember());
		
		//댓글관련
		map.put("/replyList.do", new ReplyListControl());
		//댓글등록
		map.put("/addReply.do", new AddReplyControl());
		//댓글삭제
		map.put("/removeReply.do", new RemoveReplyControl());
		//댓글수정
		map.put("/modifyReply.do", new ModifyReplyControl());
		
		//차트행성
		map.put("/chart.do", new ChartFormControl());
		map.put("/chartData.do" , new ChartDataControl());
		
		//fullcan
		map.put("/fullCalendar.do", new FullCalendarControl());
		//목록 json 형태 data
		map.put("/eventList.do", new eventListControl());
		//등록 json 형태 retCode:Success/ Fail
		map.put("/addEvent.do", new addEventControl());
		//삭제 json 형태 retCode:Success/ Fail
		map.put("/removeEvent.do", new removeEventControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(encoding);

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path);

		Control control = map.get(path);
		String viewPage = control.execute(req, resp);
		System.out.println(viewPage);

		if (viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);
			return;
		}
		
		if(viewPage.endsWith(".json")) {
			resp.setContentType("text/json;charset=UTF-8");
			resp.getWriter().print(viewPage.substring(0,viewPage.length()-5));
			return;
		}

		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}

}
