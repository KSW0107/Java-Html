package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/addtodo.json")
public class addToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addToDo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		ToDoService service = new ToDoServiceImpl();
		ToDoVO vo = new ToDoVO();
		
		String title = request.getParameter("title");
		vo.setTodoTitle(title);

		boolean result = service.addToDo(vo);
		
		System.out.println(result);
		
		Gson gson = new GsonBuilder().create();
		Map<String, Object> map = new HashMap<>();
		map.put("boolean", result);
		map.put("vo", vo);
		
		
		String json = gson.toJson(map);
		
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
