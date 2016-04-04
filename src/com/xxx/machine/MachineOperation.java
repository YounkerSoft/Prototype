package com.xxx.machine;

import java.util.ArrayList;
import java.util.HashMap;

import com.xxx.machine.bean.Stoll;
import com.xxx.order.bean.ProductionOrder;
import com.xxx.product.bean.SPUProduct;

/**
 * @author yuan
 *
 * @date 2016年4月4日 下午7:37:00
 */
public class MachineOperation {
	
	//根据机器型号获取所能生产产品列表：productList
	public ArrayList<SPUProduct> getProductList(String modelType){
		
		ArrayList<SPUProduct> productList = new ArrayList<SPUProduct>();
		
		/******************************************/
		/***************机器库构建未实现****************/
		/******************************************/
		//根据机器型号获取所能生产产品列表productList
		//机器库可能是数据库，也可能是文本（待定）
		
		return productList;
	}
	
	
	//根据机器编号获取机器状态
	public int getMachineStatus(long machineId, HashMap<Long, Stoll> machineList){
		
		//参数检查
		if(machineList.size()==0 || machineList==null || machineList.equals(null)){
			System.out.println("机器列表为空！！！");
			return -2;
		}
		
		
		int status = 0;
		
		Stoll machine = null;		
		machine = machineList.get(machineId);
		
		if(machine == null){
			System.out.println("无该编号对应机器！！！");
			return -1;
		}
		
		status = machine.getStatus();
		
		
		return status;		
	}
	
	
	//根据机器编号获取机器任务队列
	public ArrayList<ProductionOrder> getTaskQueue(long machineId, HashMap<Long, Stoll> machineList){
		
		//参数检查
		if(machineList.size()==0 || machineList==null || machineList.equals(null)){
			System.out.println("机器列表为空！！！");
			return null;
		}
		
		
		ArrayList<ProductionOrder> taskQueue;
		
		Stoll machine = null;		
		machine = machineList.get(machineId);
		
		if(machine == null){
			System.out.println("无该编号对应机器！！！");
			return null;
		}
		
		taskQueue = machine.getTaskQueue();		
		
		return taskQueue;		
	}
	
	
	//根据机器编号获取机器已完成任务队列
	public ArrayList<ProductionOrder> getComTaskQueue(long machineId, HashMap<Long, Stoll> machineList){
		
		//参数检查
		if(machineList.size()==0 || machineList==null || machineList.equals(null)){
			System.out.println("机器列表为空！！！");
			return null;
		}
		
		
		ArrayList<ProductionOrder> comTaskQueue;
		
		Stoll machine = null;		
		machine = machineList.get(machineId);
		
		if(machine == null){
			System.out.println("无该编号对应机器！！！");
			return null;
		}
		
		comTaskQueue = machine.getTaskQueue();		
		
		return comTaskQueue;		
	}
	
	
	//根据机器编号获取机器未完成任务队列
	public ArrayList<ProductionOrder> getCurTaskQueue(long machineId, HashMap<Long, Stoll> machineList){
		
		//参数检查
		if(machineList.size()==0 || machineList==null || machineList.equals(null)){
			System.out.println("机器列表为空！！！");
			return null;
		}
		
		
		ArrayList<ProductionOrder> curTaskQueue;
		
		Stoll machine = null;		
		machine = machineList.get(machineId);
		
		if(machine == null){
			System.out.println("无该编号对应机器！！！");
			return null;
		}
		
		curTaskQueue = machine.getTaskQueue();		
		
		return curTaskQueue;		
	}
	
	
	//根据机器编号获取机器完成当前任务队列中的任务预计所需时间
	public int getEstimatedFinishTime(long machineId, HashMap<Long, Stoll> machineList){
		
		//参数检查
		if(machineList.size()==0 || machineList==null || machineList.equals(null)){
			System.out.println("机器列表为空！！！");
			return -2;
		}
		
		
		int estimatedFinishTime;
		
		Stoll machine = null;		
		machine = machineList.get(machineId);
		
		if(machine == null){
			System.out.println("无该编号对应机器！！！");
			return -1;
		}
		
		estimatedFinishTime = machine.getEstimatedFinishTime();		
		
		return estimatedFinishTime;		
	}
	

}
