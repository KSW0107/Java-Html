package com.yedam.notice.control;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class modifyNoticeFileControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saveDir = req.getServletContext().getRealPath("images");
		int maxSize = 5 * 1024 * 1024; // 5 * 1메가
		String encoding = "UTF-8";
		DefaultFileRenamePolicy rn = new DefaultFileRenamePolicy(); // 같은 이름 파일 등록시 이름변경후 저장
		MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize, encoding, rn);
		
		String nid = multi.getParameter("nid");
		String attach = "";
		
		Enumeration<?> enu = multi.getFileNames();
		while(enu.hasMoreElements()) {
			String file = (String)enu.nextElement();
			System.out.println("file: "+file);
			attach = multi.getFilesystemName(file);
		}
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.parseInt(nid));
		vo.setAttachFile(attach);
		
		//공지사항 글번호 - 이미지 => 변경
		String json = "";
		Gson gson = new GsonBuilder().create();
		NoticeService service = new NoticeServiceImpl();
		if (service.modifyNoticeFile(vo)) {
			json = gson.toJson(vo);
		}
		
		
		System.out.println(nid);
		
		return json+".json";
		
	}

}
