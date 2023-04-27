package com.yedam.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.prod.domain.ProductVO;
import com.yedam.prod.mapper.ProductMapper;

public class ProductServiceImpl implements ProductService{
	SqlSession session = DataSource.getInstance().openSession(true); // true = 자동커밋
	ProductMapper mapper = session.getMapper(ProductMapper.class);
	
	@Override
	public List<ProductVO> productList() {
		return mapper.productList();
	}

	@Override
	public ProductVO getProdect(int proID) {
		// TODO Auto-generated method stub
		return mapper.getProdect(proID);
	}

	@Override
	public List<ProductVO> getWithPoint() {
		return mapper.getWithPoint();
	}

}
