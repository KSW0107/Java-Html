package com.yedam.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.member.mapper.MemberMapper;
import com.yedam.notice.domain.NoticeVO;

public class SampleExe2 {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = com.yedam.common.DataSource.getInstance();
		try (SqlSession session = sqlSessionFactory.openSession(true)) /* true = 자동커밋 */ {
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			List<Map<String, Object>> list = mapper.memberByDept();
			// [{Adminstration, 1},{Accounting,2} ...{}]

			for (Map<String, Object> map : list) {
				Set<String> set = map.keySet(); // key 값만 set에 저장
//			for(String key : set) {
				System.out.println(map.get("DEPARTMENT_NAME" + "," + map.get("CNT")));
			}
		}

//			NoticeVO notice = new NoticeVO();

		// 추가
//			notice.setNoticeWriter("나");
//			notice.setNoticeTitle("제목");
//			notice.setNoticeSubject("내용");
//			mapper.insertNotice(notice);

		// 삭제
//			notice.setNoticeId(5);
//			mapper.deleteNotice(notice);

		// 목록조회
//			for (NoticeVO vo : mapper.noticeList()) {
//				System.out.println(vo);
//			}

		// 단일조회
//			NoticeVO not = mapper.searchNotice(3);
//			System.out.println(not);

	}
}
