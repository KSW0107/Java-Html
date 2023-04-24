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
import com.yedam.notice.service.ReplyService;
import com.yedam.notice.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rid =Integer.parseInt(req.getParameter("rid"));
		
		ReplyService service = new ReplyServiceImpl();
		boolean result = service.removeReply(rid);
		
		Map<String, Object> map = new HashMap<>();
		
		String json = "";
		
		if(result) {
			map.put("retCode","Success");
		}else {
			map.put("retCode","Fail");
		}
		Gson gson = new GsonBuilder().create(); //gson 객체 생성 (JSON 생성 라이브러리)
		json = gson.toJson(map);
		
		return json+".json";
	}
}
