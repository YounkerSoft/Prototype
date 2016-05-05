package com.xxx.order;

import java.util.ArrayList;

import com.xxx.order.bean.GoodsOrder;

/**
 * @author yuan
 *
 * @date 2016年5月6日 上午7:13:16
 */
public class OrderGeneration {
	
	//生成商品订单列表
	public ArrayList<GoodsOrder> goodsOrderListGeneration(){
		
		ArrayList<GoodsOrder> goodsOrderList = new ArrayList<GoodsOrder>();
		
		goodsOrderList.add(goodsOrderGeneration());
		
		return goodsOrderList;
		
	}
	
	
	//生成商品订单
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
