package com.yedam;

import lombok.Data;

@Data

public class ToDoVO {
	private int todoNo; //번호
	private String todoTitle; // 목록
	private char todoStatus; // 취소 여부 (Y/N)
	//목록, 등록, 삭제, 변경
}
