package com.yedam.notice.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class getNoticeJsonControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//id를 조회해서 json 결과 반환
		int id = Integer.parseInt(req.getParameter("nid"));
		
		NoticeService service = new NoticeServiceImpl();
		NoticeVO notice = service.getNotice(id);
		
		Gson gson = new GsonBuilder().create();
		
		return gson.toJson(notice)+".json";
	}

}
