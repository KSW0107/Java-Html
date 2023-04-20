package com.yedam.notice.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class ModifyNoticeControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equals("POST")) {

			NoticeVO vo = new NoticeVO();
			String title = req.getParameter("title");
			String subject = req.getParameter("subject");
			int nid = Integer.parseInt(req.getParameter("nid"));

			vo.setNoticeTitle(title);
			vo.setNoticeSubject(subject);
			vo.setNoticeId(nid);

			NoticeService service = new NoticeServiceImpl();
			boolean result = service.modifyNotice(vo);

			return "noticeList.do";

		} else if (req.getMethod().equals("GET")) {

			String nid = req.getParameter("nid");

			NoticeService service = new NoticeServiceImpl();
			req.setAttribute("noticeInfo", service.getNotice(Integer.parseInt(nid)));

			return "notice/noticeModify.tiles";
		}
		return null;
	}
}
