package com.xxx.simulation;

import java.util.ArrayList;

import com.xxx.machine.MachineGeneration;
import com.xxx.machine.bean.Machine;
import com.xxx.machine.bean.Stoll;
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
		
		MachineGeneration machineGen = new MachineGeneration();	//��������ʵ��
		
		OrderAllocation orderAlloc = new OrderAllocation();		//��������ʵ��
		
		
		System.out.println();
		System.out.println("======>>������Ϣ<<======");
		System.out.println();
		
		//��ȡ��Ʒ�����б�
		ArrayList<GoodsOrder> goodsOrderList = new ArrayList<GoodsOrder>();
		goodsOrderList = orderGen.goodsOrderListGeneration();
		
		System.out.println("======>>��Ʒ������Ϣ<<======");
		System.out.println("��Ʒ�������� " + goodsOrderList.size());
		System.out.println();

		for(int i=0; i<goodsOrderList.size(); ++i){
			GoodsOrder goods = goodsOrderList.get(i);
			
			System.out.println("��Ʒ���� " + (i+1) + ":");
			
			System.out.println("SPU: " + goods.getSpu());
			System.out.println("������: " + goods.getTotalCounts());	
		}
		
		System.out.println();		
		System.out.println();		
		
		
		//��Ʒ�����ֽ�Ϊsku����
		ArrayList<SKUOrder> SKUOrderList = new ArrayList<SKUOrder>();
		SKUOrderList = orderOper.goodsOrder2SKUOrder(goodsOrderList);
		
		System.out.println("======>>SKU������Ϣ<<======");
		System.out.println("SKU�������� " + SKUOrderList.size());
		System.out.println();

		for(int i=0; i<SKUOrderList.size(); ++i){
			SKUOrder sku = SKUOrderList.get(i);
			
			System.out.println("SKU���� " + (i+1) + ":");
			
			System.out.println("SPU: " + sku.getSpu());	
			System.out.println("SKU: " + sku.getSku());
			System.out.println("����: " + sku.getCount());
			System.out.println();		

		}
		
		System.out.println();
		System.out.println();
		
		
		//sku�����ֽ�Ϊ��������
		ArrayList<ProductionOrder> proOrderList = new ArrayList<ProductionOrder>();
		proOrderList = orderOper.SKUOrder2ProductionOrder(SKUOrderList);
		
		System.out.println("======>>����������Ϣ<<======");
		System.out.println("������������ " + proOrderList.size());
		System.out.println();
		
		for(int i=0; i<proOrderList.size(); ++i){
			ProductionOrder pro = proOrderList.get(i);
			
			System.out.println("�������� " + (i+1) + ":");
			
			System.out.println("SKU: " + pro.getSku());	
			System.out.println("��װ����(ǰ�������ӣ����ӵ�)���: " + pro.getSkuPart());
			System.out.println("����: " + pro.getCount());
			System.out.println();
			
		}

		
//		//�����Ƿ�ֽ����
//		for(int i=0; i<proOrderList.size(); ++i){
//			System.out.println(proOrderList.get(i).toString());
//		}
		
		
		//��ȡ�����б�
		ArrayList<Machine> machineList = machineGen.machineListGeneration();
		
//		//�����Ƿ����ɳɹ�
//		for(int i=0; i<machineList.size(); ++i){
//			System.out.println(machineList.get(i).toString());
//		}
		
		
		//�������䣨̰�Ĳ��ԣ�
		orderAlloc.orderAllocation(machineList, proOrderList);
		
		//�����Ƿ����ɹ�
		//��ӡ��ǰ������Ϣ
		System.out.println();
		System.out.println("======>>������Ϣ<<======");
		System.out.println();
		
		System.out.println("�������� " + machineList.size());
		System.out.println();

		for(int i=0; i<machineList.size(); ++i){
			Stoll stoll = (Stoll) machineList.get(i);
			
			System.out.println("���� " + (i+1) + " :");		
			System.out.println("����Ʒ��:" + stoll.getBrand());
			System.out.println("�����ͺ�:" + stoll.getModelType());		
			System.out.println("����״̬:" + stoll.getStatus());
			
			ArrayList<ProductionOrder> taskQueue = stoll.getTaskQueue();
			System.out.println("���� " + taskQueue.size() + " ������");
			System.out.println("��ɵ�ǰ����Ԥ������ʱ��  " +  stoll.getEstimatedFinishTime());
			
			System.out.println();
		}
		
			
	
	}

}
