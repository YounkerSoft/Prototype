package com.xxx.simulation;

import java.util.ArrayList;

import com.xxx.machine.MachineGeneration;
import com.xxx.machine.bean.Machine;
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
		
		
		//获取商品订单列表
		ArrayList<GoodsOrder> goodsOrderList = new ArrayList<GoodsOrder>();
		goodsOrderList = orderGen.goodsOrderListGeneration();
		
		
		//商品订单分解为sku订单
		ArrayList<SKUOrder> SKUOrderList = new ArrayList<SKUOrder>();
		SKUOrderList = orderOper.goodsOrder2SKUOrder(goodsOrderList);
		
		
		//sku订单分解为生产订单
		ArrayList<ProductionOrder> proOrderList = new ArrayList<ProductionOrder>();
		proOrderList = orderOper.SKUOrder2ProductionOrder(SKUOrderList);
		
		
		//测试是否分解完成
		for(int i=0; i<proOrderList.size(); ++i){
			System.out.println(proOrderList.get(i).toString());
		}
		
		
		//获取机器列表
		ArrayList<Machine> machineList = machineGen.machineListGeneration();
		
		//测试是否生成成功
		for(int i=0; i<machineList.size(); ++i){
			System.out.println(machineList.get(i).toString());
		}
		
		
		//订单分配
		orderAlloc.orderAllocation(machineList, proOrderList);
		
		
		//测试是否生成成功
		for(int i=0; i<machineList.size(); ++i){
			System.out.println(machineList.get(i).toString());
		}
		
	
	}

}
