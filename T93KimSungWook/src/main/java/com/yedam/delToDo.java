package com.yedam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/deltodo.json")
public class delToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public delToDo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");

		int no = Integer.parseInt(request.getParameter("no"));

		ToDoService service = new ToDoServiceImpl();
		boolean result = service.delToDo(no);

		System.out.println(result);

		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(result);

		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
