package com.xxx.order;

import java.util.ArrayList;
import java.util.HashMap;

import com.xxx.order.bean.GoodsOrder;
import com.xxx.order.bean.ProductionOrder;
import com.xxx.order.bean.SKUOrder;
import com.xxx.product.ProductOperation;
import com.xxx.product.bean.SKUProduct;

/**
 * @author yuan
 *
 * @date 2016年3月19日 上午9:44:08
 */
public class OrderOperation {
	
	//商品订单分解为SKU订单：批量分解
	public ArrayList<SKUOrder> goodsOrder2SKUOrder(ArrayList<GoodsOrder> goodsOrders){
		
		//参数检查
		if(goodsOrders==null||goodsOrders.equals(null)||goodsOrders.size()==0){
			System.out.println("无效订单队列，队列为空！");
			return null;
		}
		
		
		ArrayList<SKUOrder> skuOrders = new ArrayList<SKUOrder>();
		
		//逐个分解GoodsOrder
		for(int i=0; i<goodsOrders.size(); i++){
			ArrayList<SKUOrder> singleSkuOrder = new ArrayList<SKUOrder>();
			singleSkuOrder = goodsOrder2SKUOrder(goodsOrders.get(i));
			
			skuOrders.addAll(singleSkuOrder);
		}
		
		//double check
		if(skuOrders==null||skuOrders.equals(null)||skuOrders.size()==0){
			System.out.println("商品订单分解失败！！！");
			return null;
		}
		
		return skuOrders;
		
	}
	
	
	//商品订单分解为SKU订单：单个分解
	public ArrayList<SKUOrder> goodsOrder2SKUOrder(GoodsOrder goodsOrder){
		
		ArrayList<SKUOrder> skuOrders = new ArrayList<SKUOrder>();
		
		if(goodsOrder != null && !goodsOrder.equals(null)){
			String[] skus = goodsOrder.getSku();
			int[] counts = goodsOrder.getCounts();
			
			if(skus.length != counts.length){
				System.out.println("Error: sku.length != counts.length");
				return null;
			}
			
			SKUOrder skuOrder;
			for(int i=0; i<skus.length; i++){
				skuOrder = new SKUOrder(i, goodsOrder.getSpu(), skus[i], counts[i], goodsOrder.getStatus(), goodsOrder.getOrderTime(), goodsOrder.getDeadLine());
				skuOrders.add(skuOrder);
			}
		}		
		
		return skuOrders;	
	}
	
	
	//SKU订单分解为生产订单：SKU包含前后袖子等 ：单个分解
	public ArrayList<ProductionOrder> SKUOrder2ProductionOrder(ArrayList<SKUOrder> skuOrders) throws Exception{
		
		//参数检查
		if(skuOrders==null||skuOrders.equals(null)||skuOrders.size()==0){
			System.out.println("无效SKU订单队列，队列为空！");
			return null;
		}
		
		
		ArrayList<ProductionOrder> proOrders = new ArrayList<ProductionOrder>();
		
		//逐个分解SKUOrders
		for(int i=0; i<skuOrders.size(); i++){
			ArrayList<ProductionOrder> singleProOrder = new ArrayList<ProductionOrder>();
			singleProOrder = SKUOrder2ProductionOrder(skuOrders.get(i));
			
			proOrders.addAll(singleProOrder);			
		}
		
		//double check
		if(proOrders==null||proOrders.equals(null)||proOrders.size()==0){
			System.out.println("商品订单分解失败！！！");
			return null;
		}	
		
		return proOrders;
	}
	
	
	//SKU订单分解为生产订单：SKU包含前后袖子等 ：单个分解
	public ArrayList<ProductionOrder> SKUOrder2ProductionOrder(SKUOrder skuOrder) throws Exception{
		
		ArrayList<ProductionOrder> proOrders = new ArrayList<ProductionOrder>();
		
		if(skuOrder != null && !skuOrder.equals(null)){
			
			//从产品库中查询对应SKU的相应部分所需要的原料、时间等信息，构建产品订单
			SKUProduct skuPro = null;
			skuPro = ProductOperation.getSKUProduct(skuOrder.getSku());
			
			if(skuPro!=null && !skuPro.equals(null)){
				String[] skuParts = skuPro.getSkuParts();
				String[][] materials = skuPro.getMaterials();
				double[][] materialsAmount = skuPro.getMaterialsAmount();
				HashMap<String, String> requiredTime = skuPro.getRequiredTime();
				//根据机器获取时间
				String reqTime[] = requiredTime.get("").split(",");
				
				//====>>需要增加校验<<====
				if(skuParts.length <= 0){
					System.out.println("该产品基本信息读取有误！");
					return null;
				}
				
				for(int i=0; i<skuParts.length; i++){
					//====>>一般袖子有两个<<====
					ProductionOrder proOrder = new ProductionOrder(i, skuOrder.getSku(), skuParts[i], skuOrder.getCount(),
							0, materials[i], materialsAmount[i], Integer.valueOf(reqTime[i])*skuOrder.getCount());
					
					proOrders.add(proOrder);
				}
												
			}
			
		}
		
		return proOrders;
	}
	

}
