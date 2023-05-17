package com.yedam.FrontControl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.prod.control.GetProductControl;
import com.yedam.prod.control.ProductFormControl;
import com.yedam.prod.control.ProductListControl;
import com.yedam.prod.control.ProdunctAddControl;
import com.yedam.prod.control.ProdunctUploadControl;
import com.yedam.prod.control.getWithPointControl;

public class FrontController extends HttpServlet{
	String encoding;
	private Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		
		map.put("/main.do", new MainControl());
		
		//전체상품조회
		map.put("/productList.do", new ProductListControl());
		//단일상품페이지
		map.put("/ProductForm.do", new ProductFormControl());
		//단일상품조회
		map.put("/getProduct.do", new GetProductControl());
		//별점순 조회
		map.put("/getWithPoint.do", new getWithPointControl());
		
		//ck editor  관련
		map.put("/productAdd.do", new ProdunctAddControl());
		//ck editor 이미지 업로드 처리
		map.put("/prodUpload.do", new ProdunctUploadControl());
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(encoding);
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path);

		Control control = map.get(path);
		String viewPage = control.execute(req, resp);
		
		if (viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);
			return;
		}
		
		if(viewPage.endsWith(".json")) {
			resp.setContentType("text/json;charset=UTF-8");
			resp.getWriter().print(viewPage.substring(0,viewPage.length()-5));
			return;
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}

	
	
	
}
