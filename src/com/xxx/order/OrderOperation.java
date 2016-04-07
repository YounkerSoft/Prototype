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
 * @date 2016��3��19�� ����9:44:08
 */
public class OrderOperation {
	
	//��Ʒ�����ֽ�ΪSKU�����������ֽ�
	public ArrayList<SKUOrder> goodsOrder2SKUOrder(ArrayList<GoodsOrder> goodsOrders){
		
		//�������
		if(goodsOrders==null||goodsOrders.equals(null)||goodsOrders.size()==0){
			System.out.println("��Ч�������У�����Ϊ�գ�");
			return null;
		}
		
		
		ArrayList<SKUOrder> skuOrders = new ArrayList<SKUOrder>();
		
		//����ֽ�GoodsOrder
		for(int i=0; i<goodsOrders.size(); i++){
			ArrayList<SKUOrder> singleSkuOrder = new ArrayList<SKUOrder>();
			singleSkuOrder = goodsOrder2SKUOrder(goodsOrders.get(i));
			
			skuOrders.addAll(singleSkuOrder);
		}
		
		//double check
		if(skuOrders==null||skuOrders.equals(null)||skuOrders.size()==0){
			System.out.println("��Ʒ�����ֽ�ʧ�ܣ�����");
			return null;
		}
		
		return skuOrders;
		
	}
	
	
	//��Ʒ�����ֽ�ΪSKU�����������ֽ�
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
	
	
	//SKU�����ֽ�Ϊ����������SKU����ǰ�����ӵ� �������ֽ�
	public ArrayList<ProductionOrder> SKUOrder2ProductionOrder(ArrayList<SKUOrder> skuOrders) throws Exception{
		
		//�������
		if(skuOrders==null||skuOrders.equals(null)||skuOrders.size()==0){
			System.out.println("��ЧSKU�������У�����Ϊ�գ�");
			return null;
		}
		
		
		ArrayList<ProductionOrder> proOrders = new ArrayList<ProductionOrder>();
		
		//����ֽ�SKUOrders
		for(int i=0; i<skuOrders.size(); i++){
			ArrayList<ProductionOrder> singleProOrder = new ArrayList<ProductionOrder>();
			singleProOrder = SKUOrder2ProductionOrder(skuOrders.get(i));
			
			proOrders.addAll(singleProOrder);			
		}
		
		//double check
		if(proOrders==null||proOrders.equals(null)||proOrders.size()==0){
			System.out.println("��Ʒ�����ֽ�ʧ�ܣ�����");
			return null;
		}	
		
		return proOrders;
	}
	
	
	//SKU�����ֽ�Ϊ����������SKU����ǰ�����ӵ� �������ֽ�
	public ArrayList<ProductionOrder> SKUOrder2ProductionOrder(SKUOrder skuOrder) throws Exception{
		
		ArrayList<ProductionOrder> proOrders = new ArrayList<ProductionOrder>();
		
		if(skuOrder != null && !skuOrder.equals(null)){
			
			//�Ӳ�Ʒ���в�ѯ��ӦSKU����Ӧ��������Ҫ��ԭ�ϡ�ʱ�����Ϣ��������Ʒ����
			SKUProduct skuPro = null;
			skuPro = ProductOperation.getSKUProduct(skuOrder.getSku());
			
			if(skuPro!=null && !skuPro.equals(null)){
				String[] skuParts = skuPro.getSkuParts();
				String[][] materials = skuPro.getMaterials();
				double[][] materialsAmount = skuPro.getMaterialsAmount();
				HashMap<String, String> requiredTime = skuPro.getRequiredTime();
				//���ݻ�����ȡʱ��
				String reqTime[] = requiredTime.get("").split(",");
				
				//====>>��Ҫ����У��<<====
				if(skuParts.length <= 0){
					System.out.println("�ò�Ʒ������Ϣ��ȡ����");
					return null;
				}
				
				for(int i=0; i<skuParts.length; i++){
					//====>>һ������������<<====
					ProductionOrder proOrder = new ProductionOrder(i, skuOrder.getSku(), skuParts[i], skuOrder.getCount(),
							0, materials[i], materialsAmount[i], Integer.valueOf(reqTime[i])*skuOrder.getCount());
					
					proOrders.add(proOrder);
				}
												
			}
			
		}
		
		return proOrders;
	}
	

}
