package com.yedam.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.notice.domain.ReplyVO;
import com.yedam.notice.mapper.NoticeMapper;
import com.yedam.notice.mapper.ReplyMapper;

public class ReplyServiceImpl implements ReplyService{

	SqlSession session = DataSource.getInstance().openSession(true); // true = 자동커밋
	ReplyMapper mapper = session.getMapper(ReplyMapper.class);
	
	@Override
	public List<ReplyVO> getReplies(int noticeId) {
		return mapper.replyList(noticeId);
	}

	@Override
	public boolean addReply(ReplyVO vo) {
		return mapper.insertReply(vo)==1;
	}

	@Override
	public boolean removeReply(int replyId) {
		return mapper.removeRelpy(replyId)==1;
	}

	@Override
	public boolean UpdateReply(ReplyVO vo) {
		return mapper.updateReply(vo)==1;
	}

	@Override
	public ReplyVO getReply(int replyId) {
		return mapper.getReply(replyId);
	}

}
