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
import com.yedam.notice.domain.ReplyVO;
import com.yedam.notice.service.ReplyService;
import com.yedam.notice.service.ReplyServiceImpl;

public class AddReplyControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 댓글 등록 컨트롤 ... ing
		String id = req.getParameter("id");
		String reply = req.getParameter("reply");
		String noticeId = req.getParameter("notice_id");

		ReplyVO vo = new ReplyVO();
		vo.setReplyWriter(id);
		vo.setReply(reply);
		vo.setNoticeId(Integer.parseInt(noticeId));

		ReplyService service = new ReplyServiceImpl();
		boolean result = service.addReply(vo);

		String json = "";
		
		Map<String, Object> map = new HashMap<>();
		
		if (result) {
			// {"retCode":"Success"} -> json 형식
			//json = "{\"retCode\":\"Success\"}";
			//라이브러리 사용{"retCode:"Success", "date" : vo};
			map.put("retCode","Success");
			map.put("data",vo);
		} else {
			// {"retCode":"Fail"}
			map.put("retCode","Fail");
		}
		
		Gson gson = new GsonBuilder().create(); //gson 객체 생성 (JSON 생성 라이브러리)
		json = gson.toJson(map);
		
		return json + ".json";
	}

}
