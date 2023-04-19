package com.yedam.notice.domain;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {
	//DTO와 같은 역할
	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	private Date noticeDate;
	private int hitCount;
	private String attachFile;
}
