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

@WebServlet("/modifytodo.json")
public class updateToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updateToDo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		
		ToDoVO vo = new ToDoVO();
		ToDoService service = new ToDoServiceImpl();
		
		int no =Integer.parseInt( request.getParameter("no"));
		vo = service.getTodo(no);
		
		System.out.println(vo);
		
		boolean result = service.updateToDo(vo);	
		
		System.out.println(result);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(result);
		
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
