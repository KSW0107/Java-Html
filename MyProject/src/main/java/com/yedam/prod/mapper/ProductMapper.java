package com.yedam.prod.mapper;

import java.util.List;

import com.yedam.prod.domain.ProductVO;

public interface ProductMapper {
		public List<ProductVO> productList();
		public ProductVO getProdect(int proID);
		public List<ProductVO> getWithPoint();
}
