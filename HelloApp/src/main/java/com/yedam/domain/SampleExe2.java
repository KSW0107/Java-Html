package com.yedam.domain;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.mapper.NoticeMapper;

public class SampleExe2 {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = com.yedam.common.DataSource.getInstance();
		try (SqlSession session = sqlSessionFactory.openSession(true)) /* true = 자동커밋 */ {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			NoticeVO notice = new NoticeVO();
			
			//추가
//			notice.setNoticeWriter("나");
//			notice.setNoticeTitle("제목");
//			notice.setNoticeSubject("내용");
//			mapper.insertNotice(notice);
			
			//삭제
//			notice.setNoticeId(5);
//			mapper.deleteNotice(notice);
			
			//목록조회
//			for (NoticeVO vo : mapper.noticeList()) {
//				System.out.println(vo);
//			}
			
			//단일조회
			NoticeVO not = mapper.searchNotice(3);
			System.out.println(not);

		}
	}
}
