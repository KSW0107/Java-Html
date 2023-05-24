package com.yedam;

import java.util.List;

public interface ToDoService {
	public List<ToDoVO> todoList();
	public boolean addToDo(ToDoVO vo);
	public boolean delToDo(int todoNo);
	public boolean updateToDo(ToDoVO vo);
	public ToDoVO getTodo(int todoNo);


}
