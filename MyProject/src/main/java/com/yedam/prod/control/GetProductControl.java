package com.yedam.prod.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.prod.domain.ProductVO;
import com.yedam.prod.service.ProductService;
import com.yedam.prod.service.ProductServiceImpl;

public class GetProductControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int proId = Integer.parseInt(req.getParameter("proId"));
		
		ProductService service = new ProductServiceImpl();
		ProductVO vo = service.getProdect(proId);
		
		
		
//		pro_id number primary key,
//		pro_name varchar2(50) not null,
//		pro_text varchar2(1000),
//		pro_price number not null,
//		pro_sale number,
//		pro_point number
		
		String json="[";
		json += "{\"proName\":\""+vo.getProName()+"\",";
		json += "\"proId\":\"" + vo.getProId() + "\",";
		json += "\"proText\":\"" + vo.getProText() + "\",";
		json += "\"proPrice\":\"" + vo.getProPrice() + "\",";
		json += "\"proPoint\":\"" + vo.getProPoint() + "\",";
		json += "\"proImage\":\"" + vo.getProImage() + "\",";
		json += "\"proSale\":\"" + vo.getProSale() + "\"}";
		json += "]";
		
		
		
		return json+".json";
	}

}
