package com.yedam.member.service;

import java.util.Map;

import com.yedam.member.domain.MemberVO;

public interface MemberService {
	public MemberVO loginCheck(MemberVO vo);
	public boolean updateMember (MemberVO vo);
	
	//부서별 인원 현황
	public Map<String, Object> memberByDept();
}
