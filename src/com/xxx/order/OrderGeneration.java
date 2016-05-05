package com.xxx.order;

import java.util.ArrayList;

import com.xxx.order.bean.GoodsOrder;

/**
 * @author yuan
 *
 * @date 2016��5��6�� ����7:13:16
 */
public class OrderGeneration {
	
	//������Ʒ�����б�
	public ArrayList<GoodsOrder> goodsOrderListGeneration(){
		
		ArrayList<GoodsOrder> goodsOrderList = new ArrayList<GoodsOrder>();
		
		goodsOrderList.add(goodsOrderGeneration());
		
		return goodsOrderList;
		
	}
	
	
	//������Ʒ����
	public GoodsOrder goodsOrderGeneration() {
		
		long goodsId = 0;
		String spu = "1";
		String[] sku = {"1", "2", "3"};
		int[] counts = {100, 100, 100};
		int totalCounts = 300;
		
		GoodsOrder goods = new GoodsOrder(goodsId, spu, sku, counts, totalCounts);
		
		return goods;
		
	}
	
	

}
