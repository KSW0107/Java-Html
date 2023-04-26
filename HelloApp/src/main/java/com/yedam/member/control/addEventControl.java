package com.yedam.member.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.member.domain.EventVO;
import com.yedam.member.service.EventService;
import com.yedam.member.service.EventServiceImpl;

public class addEventControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		System.out.println(title);
		String start = req.getParameter("start_date");
		System.out.println(start);
		String end = req.getParameter("end_date");
		System.out.println(end);
		EventVO vo = new EventVO();
		vo.setTitle(title);
		vo.setStartDate(start);
		vo.setEndDate(end);
		
		String json = "";
		
		Map<String,Object> map = new HashMap<>();
		
		EventService service = new EventServiceImpl();
		boolean result = service.addEvent(vo);
		
		if(result) {
			map.put("retCode", "Success");
		}else {
			map.put("retCode", "Fail");
		}
		
		Gson gson = new GsonBuilder().create(); //gson 객체 생성 (JSON 생성 라이브러리)
		json = gson.toJson(map);
		
		return json+".json";
	}

}
