package com.yedam.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.mapper.NoticeMapper;

import freemarker.core.ReturnInstruction.Return;

public class NoticeServiceImpl implements NoticeService {
	SqlSession session = DataSource.getInstance().openSession(true); //자동커밋
	NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	
//	@Override
//	public List<NoticeVO> noticeList() {
//		return mapper.noticeList();
//	}
	
	@Override
	public List<NoticeVO> noticeListJson() {
		return mapper.noticeList();
	}
	
	@Override
	public List<NoticeVO> noticeList(int page) {
		return mapper.noticeWithPage(page);
	}

	@Override
	public boolean addNotice(NoticeVO vo) {
		return mapper.insertNotice(vo) == 1;
	}

	@Override
	public boolean modifyNotice(NoticeVO vo) {
		return mapper.updateNotice(vo) == 1;
	}
	
	@Override
	public boolean modifyNoticeFile(NoticeVO vo) {
		return mapper.updateNoticeFile(vo) == 1;
	}


	@Override
	public boolean removeNotice(int noticeId) {
		return mapper.deleteNotice(noticeId) == 1;
	}

	@Override
	public NoticeVO getNotice(int noticeId) {
		//조회수 증가.
		mapper.updateCount(noticeId);
		return mapper.searchNotice(noticeId);
	}
	
	@Override
	public int totalCount() {
		return mapper.getCount();
	}


	

}
