package com.xxx.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;





import com.xxx.product.bean.SKUProduct;
import com.xxx.util.DTOPopulator;
import com.xxx.util.Database;

/**
 * @author yuan
 *
 * @date 2016��4��4�� ����2:15:53
 */
public class ProductOperation {
	
	//SQL connection
	static Connection connection = null;
		
	
	//�Ӳ�Ʒ���л�ȡ��Ϣ
	public static SKUProduct getSKUProduct(String sku) throws Exception{
		SKUProduct SKUPro = null;
		
		/******************************************/
		/***********��Ʒ�⹹��ʵ�֣�����MySql��***********/
		/******************************************/
		
		//========>>δ�ָ�<<========
		
		connection = Database.getConnection();
		String sql = "select * from sku where sku=" + sku;
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		long skuProductId = 0;		
		//String sku;
		String spu = null;
		String[] skuParts = new String[3];
		
		String[][] materials = new String[3][3];
		String[] material = new String[3];
		
		String[][] materialsAmount = new String[3][3];
		String[] materialAmount = new String[3];
		
		HashMap<String, String> requiredTime = new HashMap<String, String>();
		String[] requiredTimes = new String[1];
		
		
		while(rs.next()){
			skuProductId = rs.getLong(1);
			sku = rs.getString(2);
			spu = rs.getString(3);
			skuParts = (rs.getString(4)).trim().split(";");
			material = (rs.getString(5)).trim().split(";");
			materialAmount = (rs.getString(6)).trim().split(";");
			requiredTimes = (rs.getString(7)).trim().split(";");
	    }   
		
		
		//�ֽ�material
		for(int i=0; i<material.length; ++i){
			materials[i] = material[i].trim().split(",");
		}
		
		//�ֽ�materialAmount
		for(int i=0; i<materialAmount.length; ++i){
			materialsAmount[i] = materialAmount[i].trim().split(",");
		}
		
		//�ֽ�requiredTimes
		for(int i=0; i<requiredTimes.length; ++i){
			String[] tmp = requiredTimes[i].trim().split(":");
			requiredTime.put(tmp[0], tmp[1]); 
		}
		
		SKUPro = new SKUProduct(skuProductId, sku, spu, skuParts, materialsAmount, materialsAmount, requiredTime);
		
		if(SKUPro == null || SKUPro.equals(null)){
			System.out.println("��Ʒ�����޸ò�Ʒ��Ϣ��");
		}
		
		rs.close();
		ps.close();	
		
		return SKUPro;
	}

}
