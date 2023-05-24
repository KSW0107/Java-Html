package com.yedam.notice.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class modifyNoticeJsonControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//id, title, subject 받아와서 값을 변경
		
		//id 를 기준으로 변경된 값 조회
		int id = Integer.parseInt(req.getParameter("id")) ;
		String title = req.getParameter("title");
		String subject = req.getParameter("subject");
		
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(id);
		vo.setNoticeTitle(title);
		vo.setNoticeSubject(subject);
		
		NoticeService service = new NoticeServiceImpl();
		Map<String, Object> map = new HashMap<>();
		if(service.modifyNotice(vo)) {
			vo = service.getNotice(id);
			
			map.put("retCode", "Success");
			map.put("retVal", vo);
		}else {
			map.put("retCode", "Fail");
			map.put("retVal", null);
		}
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		
		return json+".json";
	}

}
