package com.yedam.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.mapper.NoticeMapper;

public class SampleExe3 {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = com.yedam.common.DataSource.getInstance();
		try (SqlSession session = sqlSessionFactory.openSession(true)) /* true = 자동커밋 */ {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);

			List<NoticeVO> list = mapper.noticeWithPage(2);
			for(NoticeVO vo : list) {
				System.out.println(vo);
			}
		}

	}
}
