package com.xxx.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import com.xxx.product.bean.SKUProduct;
import com.xxx.util.DTOPopulator;
import com.xxx.util.Database;

/**
 * @author yuan
 *
 * @date 2016年4月4日 下午2:15:53
 */
public class ProductOperation {
	
	//SQL connection
	static Connection connection = null;
		
	
	//从产品库中获取信息
	@SuppressWarnings("unchecked")
	public static SKUProduct getSKUProduct(String sku) throws Exception{
		SKUProduct SKUPro = null;
		
		/******************************************/
		/***********产品库构建实现（采用MySql）***********/
		/******************************************/
		
		//========>>未分割<<========
		
		connection = Database.getConnection();
		String sql = "select * from sku where sku=" + sku;
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<SKUProduct> list = DTOPopulator.populate(rs, SKUProduct.class);
		
		if(list.size()!=0 && list!=null){
			SKUPro = list.get(0);
		} else {
			System.out.println("产品库中无该产品信息！");
		}
		
		rs.close();
		ps.close();	
		
		return SKUPro;
	}

}
