package com.xxx.machine.bean;

import java.util.ArrayList;

import com.xxx.order.bean.ProductionOrder;

/**
 * @author yuan
 *
 * @date 2016��4��4�� ����4:49:21
 */
public class Stoll extends Machine{
	
	private long machineId;				//�������
	
//	private String brand;				//����Ʒ��
//	private String modelType;			//�����ͺ�
//	
//	private String productList;			//����������Ʒ�б�
	
	private String location;			//��������λ�ã��Ƿ���һ�������磩
	private String factory;				//�������ڹ���
	
	private int status;					//������ǰ״̬��0�����У�1����ת��2�����ϣ�
	private ArrayList<ProductionOrder> taskQueue;		//�������
	private ArrayList<ProductionOrder> comTaskQueue;	//������������
	private ArrayList<ProductionOrder> curTaskQueue;	//��ǰ�������
	private int estimatedFinishTime;					//��ɵ�ǰ��������е�����Ԥ������ʱ��
	private String history;				//��ʷ||��־
	


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
