package com.yedam.notice.control;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;

public class modifyNoticeFileControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saveDir = req.getServletContext().getRealPath("images");
		int maxSize = 5 * 1024 * 1024; // 5 * 1메가
		String encoding = "UTF-8";
		DefaultFileRenamePolicy rn = new DefaultFileRenamePolicy(); // 같은 이름 파일 등록시 이름변경후 저장
		MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize, encoding, rn);
		
		Enumeration<?> enu = multi.getFileNames();
		while(enu.hasMoreElements()) {
			String file = (String)enu.nextElement();
			System.out.println("file: "+file);
		}
		String nid = multi.getParameter("nid");
		System.out.println(nid);
		
		return "HaHaHa.json";
		
	}

}
