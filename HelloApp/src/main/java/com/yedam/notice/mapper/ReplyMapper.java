package com.yedam.notice.mapper;

import java.util.List;

import com.yedam.notice.domain.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> replyList(int noticeId);
	//댓글등록
	public int insertReply(ReplyVO vo);	
	public int removeRelpy(int replyId);
	//public int UpdateReply(@Param("replyId") int replyId, @Param("reply")String reply);
	//위에 처럼 지정 시 xml에서 파라미터 타입 선언 안 해도 사용가능
	public int updateReply(ReplyVO vo);
	public ReplyVO getReply(int replyId);
}