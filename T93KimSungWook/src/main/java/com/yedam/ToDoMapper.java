package com.yedam;

import java.util.List;

public interface ToDoMapper {
	public List<ToDoVO> todoList();
	public int addToDo(ToDoVO vo);
	public int delToDo(int todoNo);
	public int updateToDo(ToDoVO vo);
	public ToDoVO getTodo(int todoNo);

}
