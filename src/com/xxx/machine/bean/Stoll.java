package com.xxx.machine.bean;

import java.util.ArrayList;

import com.xxx.order.bean.ProductionOrder;

/**
 * @author yuan
 *
 * @date 2016年4月4日 下午4:49:21
 */
public class Stoll extends Machine{
	
	private long machineId;				//机器编号
	
//	private String brand;				//机器品牌
//	private String modelType;			//机器型号
//	
//	private String productList;			//所能生产产品列表
	
	private String location;			//机器所处位置（是否处于一个市县乡）
	private String factory;				//机器所在工厂
	
	private int status;					//机器当前状态（0：空闲；1：运转；2：故障）
	private ArrayList<ProductionOrder> taskQueue;		//任务队列
	private ArrayList<ProductionOrder> comTaskQueue;	//已完成任务队列
	private ArrayList<ProductionOrder> curTaskQueue;	//当前任务队列
	private int estimatedFinishTime;					//完成当前任务队列中的任务预计所需时间
	private String history;				//历史||日志
	


	/**
	 * @param machineId
	 * @param modelType
	 * @param productList
	 * @param location
	 * @param factory
	 * @param status
	 * @param taskQueue
	 * @param comTaskQueue
	 * @param curTaskQueue
	 * @param estimatedIdleTime
	 * @param history
	 */
	public Stoll(long machineId, String brand, String modelType,
			String productList, String location, String factory,
			int status, ArrayList<ProductionOrder> taskQueue,
			ArrayList<ProductionOrder> comTaskQueue,
			ArrayList<ProductionOrder> curTaskQueue, int estimatedFinishTime,
			String history) {
		super(brand, modelType, productList);
		this.machineId = machineId;
		this.location = location;
		this.factory = factory;
		this.status = status;
		this.taskQueue = taskQueue;
		this.comTaskQueue = comTaskQueue;
		this.curTaskQueue = curTaskQueue;
		this.estimatedFinishTime = estimatedFinishTime;
		this.history = history;
	}


	/**
	 * @param machineId
	 * @param modelType
	 * @param productList
	 * @param location
	 * @param factory
	 * @param status
	 */
	public Stoll(long machineId, String brand, String modelType,
			String productList, String location, String factory,
			int status) {
		super(brand, modelType, productList);
		this.machineId = machineId;
		this.location = location;
		this.factory = factory;
		this.status = status;
	}


	/**
	 * @param machineId
	 * @param modelType
	 * @param productList
	 */
	public Stoll(long machineId, String brand, String modelType, String productList) {
		super(brand, modelType, productList);
		this.machineId = machineId;
	}


	/**
	 * @return the machineId
	 */
	public long getMachineId() {
		return machineId;
	}


	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * @return the factory
	 */
	public String getFactory() {
		return factory;
	}


	/**
	 * @param factory the factory to set
	 */
	public void setFactory(String factory) {
		this.factory = factory;
	}


	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}


	/**
	 * @return the taskQueue
	 */
	public ArrayList<ProductionOrder> getTaskQueue() {
		return taskQueue;
	}


	/**
	 * @param taskQueue the taskQueue to set
	 */
	public void setTaskQueue(ArrayList<ProductionOrder> taskQueue) {
		this.taskQueue = taskQueue;
	}


	/**
	 * @return the comTaskQueue
	 */
	public ArrayList<ProductionOrder> getComTaskQueue() {
		return comTaskQueue;
	}


	/**
	 * @param comTaskQueue the comTaskQueue to set
	 */
	public void setComTaskQueue(ArrayList<ProductionOrder> comTaskQueue) {
		this.comTaskQueue = comTaskQueue;
	}


	/**
	 * @return the curTaskQueue
	 */
	public ArrayList<ProductionOrder> getCurTaskQueue() {
		return curTaskQueue;
	}


	/**
	 * @param curTaskQueue the curTaskQueue to set
	 */
	public void setCurTaskQueue(ArrayList<ProductionOrder> curTaskQueue) {
		this.curTaskQueue = curTaskQueue;
	}


	/**
	 * @return the estimatedFinishTime
	 */
	public int getEstimatedFinishTime() {
		return estimatedFinishTime;
	}


	/**
	 * @param estimatedFinishTime the estimatedFinishTime to set
	 */
	public void setEstimatedFinishTime(int estimatedFinishTime) {
		this.estimatedFinishTime = estimatedFinishTime;
	}


	/**
	 * @return the history
	 */
	public String getHistory() {
		return history;
	}


	/**
	 * @param history the history to set
	 */
	public void setHistory(String history) {
		this.history = history;
	}
	
	
	
	
	
	
	
	

}
