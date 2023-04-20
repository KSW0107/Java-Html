package com.yedam.notice.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class AddNoticeControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파일 업로드, db 입력처리, 목록이동 기능
		//멀티파트요청 : 요청정보, 저장경로, 최대파일크기, 인코딩방식, 리네임정책 인스턴스 => 매개변수
		String saveDir = req.getServletContext().getRealPath("images");
		int maxSize = 5 * 1024 * 1024; //5 * 1메가
		String encoding = "UTF-8";
		DefaultFileRenamePolicy rn = new DefaultFileRenamePolicy(); //같은 이름 파일 등록시 이름변경후 저장
		MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize,encoding,rn);
		
		String writer = multi.getParameter("writer"); //파일이동 시 multi의 getparameter 써야함
		String subject = multi.getParameter("subject");
		String title = multi.getParameter("title");
		String attach = multi.getFilesystemName("attach"); //이름이 바뀌게되는데 바뀐 이름가져오기
		
		//입력값 VO에 입력
		NoticeVO vo = new NoticeVO();
		
		vo.setNoticeTitle(title);
		vo.setAttachFile(attach);
		vo.setNoticeSubject(subject);
		vo.setNoticeWriter(writer);
		
		NoticeService service = new NoticeServiceImpl();
		//정상처리 -> 목록이동
		//정상처리X -> 메인이동
		if(service.addNotice(vo)) {
			return "noticeList.do";
		}else {
			return "main.do";
		}
		
	}

}
