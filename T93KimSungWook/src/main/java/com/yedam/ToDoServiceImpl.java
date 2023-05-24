package com.yedam;

import java.util.ArrayList;
import java.util.List;

public class ToDoServiceImpl implements ToDoService {
	ToDoMapper mapper = DataSource.getInstance().openSession(true).getMapper(ToDoMapper.class);

	@Override
	public List<ToDoVO> todoList() {
		return mapper.todoList();
	}

	@Override
	public boolean addToDo(ToDoVO vo) {
		return mapper.addToDo(vo) == 1;
	}

	@Override
	public boolean delToDo(int todoNo) {
		return mapper.delToDo(todoNo) == 1;
	}

	@Override
	public boolean updateToDo(ToDoVO vo) {
		return mapper.updateToDo(vo) == 1;
	}

	@Override
	public ToDoVO getTodo(int todoNo) {
		return mapper.getTodo(todoNo);
	}

}
