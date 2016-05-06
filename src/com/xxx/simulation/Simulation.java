package com.xxx.simulation;

import java.util.ArrayList;

import com.xxx.order.OrderGeneration;
import com.xxx.order.OrderOperation;
import com.xxx.order.bean.GoodsOrder;
import com.xxx.order.bean.ProductionOrder;
import com.xxx.order.bean.SKUOrder;

/**
 * @author yuan
 *
 * @date 2016��5��6�� ����7:09:52
 */
public class Simulation {
	

	/**
	 * Name: main
	 * Description: 
	 * @param args
	 *
	 * @author yuan
	 * @throws Exception 
	 * @date 2016��5��6�� ����7:09:52
	 */
	public static void main(String[] args) throws Exception {
		
		//ʵ������
		OrderGeneration orderGen = new OrderGeneration();		//��Ʒ��������ʵ��
		OrderOperation orderOper = new OrderOperation();		//��������ʵ��
		
		
		//��ȡ��Ʒ�����б�
		ArrayList<GoodsOrder> goodsOrderList = new ArrayList<GoodsOrder>();
		goodsOrderList = orderGen.goodsOrderListGeneration();
		
		
		//��Ʒ�����ֽ�Ϊsku����
		ArrayList<SKUOrder> SKUOrderList = new ArrayList<SKUOrder>();
		SKUOrderList = orderOper.goodsOrder2SKUOrder(goodsOrderList);
		
		
		//sku�����ֽ�Ϊ��������
		ArrayList<ProductionOrder> proOrderList = new ArrayList<ProductionOrder>();
		proOrderList = orderOper.SKUOrder2ProductionOrder(SKUOrderList);
		
		
		//�����Ƿ�ֽ����
		for(int i=0; i<proOrderList.size(); ++i){
			System.out.println(proOrderList.get(i).toString());
		}	

	}

}