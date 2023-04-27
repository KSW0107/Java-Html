package com.yedam.prod.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.prod.domain.ProductVO;
import com.yedam.prod.service.ProductService;
import com.yedam.prod.service.ProductServiceImpl;

public class getWithPointControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.getWithPoint();
		
		String json="[";
		for (int i=0; i<list.size();i++) {
			json += "{\"proId\":\""+list.get(i).getProId()+"\",";
			json += "\"proName\":\""+list.get(i).getProName()+"\",";
			json += "\"proPoint\":\"" + list.get(i).getProPoint() + "\",";
			json += "\"proPrice\":\"" + list.get(i).getProPrice() + "\",";
			json += "\"proImage\":\"" + list.get(i).getProImage() + "\",";
			json += "\"proSale\":\"" + list.get(i).getProSale() + "\"}";
			
			if (i + 1 != list.size()) {
				json += ",";
			}
		}
		
		json += "]";
		return json+".json";
	}

}
