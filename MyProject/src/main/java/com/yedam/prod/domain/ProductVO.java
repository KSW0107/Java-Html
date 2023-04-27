package com.yedam.prod.domain;

import lombok.Data;

@Data

public class ProductVO {
//	pro_id number primary key,
//	pro_name varchar2(50) not null,
//	pro_text varchar2(1000),
//	pro_price number not null,
//	pro_sale number,
//	pro_point number
	
	private int proId;
	private String proName;
	private String proText;
	private int proPrice;
	private int proSale;
	private int proPoint;
	private String proImage;
}
