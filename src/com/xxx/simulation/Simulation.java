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
 * @date 2016年5月6日 上午7:09:52
 */
public class Simulation {
	

	/**
	 * Name: main
	 * Description: 
	 * @param args
	 *
	 * @author yuan
	 * @throws Exception 
	 * @date 2016年5月6日 上午7:09:52
	 */
	public static void main(String[] args) throws Exception {
		
		//实体声明
		OrderGeneration orderGen = new OrderGeneration();		//商品订单生成实体
		OrderOperation orderOper = new OrderOperation();		//订单操作实体
		
		MachineGeneration machineGen = new MachineGeneration();	//机器生成实体
		
		OrderAllocation orderAlloc = new OrderAllocation();		//订单分配实体
		
		
		System.out.println();
		System.out.println("======>>订单信息<<======");
		System.out.println();
		
		//获取商品订单列表
		ArrayList<GoodsOrder> goodsOrderList = new ArrayList<GoodsOrder>();
		goodsOrderList = orderGen.goodsOrderListGeneration();
		
		System.out.println("======>>产品订单信息<<======");
		System.out.println("产品订单数量 " + goodsOrderList.size());
		System.out.println();

		for(int i=0; i<goodsOrderList.size(); ++i){
			GoodsOrder goods = goodsOrderList.get(i);
			
			System.out.println("产品订单 " + (i+1) + ":");
			
			System.out.println("SPU: " + goods.getSpu());
			System.out.println("总数量: " + goods.getTotalCounts());	
		}
		
		System.out.println();		
		System.out.println();		
		
		
		//商品订单分解为sku订单
		ArrayList<SKUOrder> SKUOrderList = new ArrayList<SKUOrder>();
		SKUOrderList = orderOper.goodsOrder2SKUOrder(goodsOrderList);
		
		System.out.println("======>>SKU订单信息<<======");
		System.out.println("SKU订单数量 " + SKUOrderList.size());
		System.out.println();

		for(int i=0; i<SKUOrderList.size(); ++i){
			SKUOrder sku = SKUOrderList.get(i);
			
			System.out.println("SKU订单 " + (i+1) + ":");
			
			System.out.println("SPU: " + sku.getSpu());	
			System.out.println("SKU: " + sku.getSku());
			System.out.println("数量: " + sku.getCount());
			System.out.println();		

		}
		
		System.out.println();
		System.out.println();
		
		
		//sku订单分解为生产订单
		ArrayList<ProductionOrder> proOrderList = new ArrayList<ProductionOrder>();
		proOrderList = orderOper.SKUOrder2ProductionOrder(SKUOrderList);
		
		System.out.println("======>>生产订单信息<<======");
		System.out.println("生产订单数量 " + proOrderList.size());
		System.out.println();
		
		for(int i=0; i<proOrderList.size(); ++i){
			ProductionOrder pro = proOrderList.get(i);
			
			System.out.println("生产订单 " + (i+1) + ":");
			
			System.out.println("SKU: " + pro.getSku());	
			System.out.println("服装部分(前，后，袖子，领子等)编号: " + pro.getSkuPart());
			System.out.println("数量: " + pro.getCount());
			System.out.println();
			
		}

		
//		//测试是否分解完成
//		for(int i=0; i<proOrderList.size(); ++i){
//			System.out.println(proOrderList.get(i).toString());
//		}
		
		
		//获取机器列表
		ArrayList<Machine> machineList = machineGen.machineListGeneration();
		
//		//测试是否生成成功
//		for(int i=0; i<machineList.size(); ++i){
//			System.out.println(machineList.get(i).toString());
//		}
		
		
		//订单分配（贪心策略）
		orderAlloc.orderAllocation(machineList, proOrderList);
		
		//测试是否分配成功
		//打印当前机器消息
		System.out.println();
		System.out.println("======>>机器信息<<======");
		System.out.println();
		
		System.out.println("机器数量 " + machineList.size());
		System.out.println();

		for(int i=0; i<machineList.size(); ++i){
			Stoll stoll = (Stoll) machineList.get(i);
			
			System.out.println("机器 " + (i+1) + " :");		
			System.out.println("机器品牌:" + stoll.getBrand());
			System.out.println("机器型号:" + stoll.getModelType());		
			System.out.println("机器状态:" + stoll.getStatus());
			
			ArrayList<ProductionOrder> taskQueue = stoll.getTaskQueue();
			System.out.println("共有 " + taskQueue.size() + " 项任务");
			System.out.println("完成当前任务预计所需时间  " +  stoll.getEstimatedFinishTime());
			
			System.out.println();
		}
		
			
	
	}

}
