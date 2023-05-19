package com.yedam.notice.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class NoticeDelJsonControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int nid =Integer.parseInt( req.getParameter("nid"));

		NoticeService service = new NoticeServiceImpl();
		String json = "Fail"; 
		if(service.removeNotice(nid)) {
			json="Success";
		}

		return json+".json";
	}

}
