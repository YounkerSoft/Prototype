package com.xxx.machine;

import java.util.ArrayList;
import java.util.HashMap;

import com.xxx.machine.bean.Stoll;
import com.xxx.order.bean.ProductionOrder;
import com.xxx.product.bean.SPUProduct;

/**
 * @author yuan
 *
 * @date 2016��4��4�� ����7:37:00
 */
public class MachineOperation {
	
	//���ݻ����ͺŻ�ȡ����������Ʒ�б�productList
	public ArrayList<SPUProduct> getProductList(String modelType){
		
		ArrayList<SPUProduct> productList = new ArrayList<SPUProduct>();
		
		/******************************************/
		/***************�����⹹��δʵ��****************/
		/******************************************/
		//���ݻ����ͺŻ�ȡ����������Ʒ�б�productList
		//��������������ݿ⣬Ҳ�������ı���������
		
		return productList;
	}
	
	
	//���ݻ�����Ż�ȡ����״̬
	public int getMachineStatus(long machineId, HashMap<Long, Stoll> machineList){
		
		//�������
		if(machineList.size()==0 || machineList==null || machineList.equals(null)){
			System.out.println("�����б�Ϊ�գ�����");
			return -2;
		}
		
		
		int status = 0;
		
		Stoll machine = null;		
		machine = machineList.get(machineId);
		
		if(machine == null){
			System.out.println("�޸ñ�Ŷ�Ӧ����������");
			return -1;
		}
		
		status = machine.getStatus();
		
		
		return status;		
	}
	
	
	//���ݻ�����Ż�ȡ�����������
	public ArrayList<ProductionOrder> getTaskQueue(long machineId, HashMap<Long, Stoll> machineList){
		
		//�������
		if(machineList.size()==0 || machineList==null || machineList.equals(null)){
			System.out.println("�����б�Ϊ�գ�����");
			return null;
		}
		
		
		ArrayList<ProductionOrder> taskQueue;
		
		Stoll machine = null;		
		machine = machineList.get(machineId);
		
		if(machine == null){
			System.out.println("�޸ñ�Ŷ�Ӧ����������");
			return null;
		}
		
		taskQueue = machine.getTaskQueue();		
		
		return taskQueue;		
	}
	
	
	//���ݻ�����Ż�ȡ����������������
	public ArrayList<ProductionOrder> getComTaskQueue(long machineId, HashMap<Long, Stoll> machineList){
		
		//�������
		if(machineList.size()==0 || machineList==null || machineList.equals(null)){
			System.out.println("�����б�Ϊ�գ�����");
			return null;
		}
		
		
		ArrayList<ProductionOrder> comTaskQueue;
		
		Stoll machine = null;		
		machine = machineList.get(machineId);
		
		if(machine == null){
			System.out.println("�޸ñ�Ŷ�Ӧ����������");
			return null;
		}
		
		comTaskQueue = machine.getTaskQueue();		
		
		return comTaskQueue;		
	}
	
	
	//���ݻ�����Ż�ȡ����δ����������
	public ArrayList<ProductionOrder> getCurTaskQueue(long machineId, HashMap<Long, Stoll> machineList){
		
		//�������
		if(machineList.size()==0 || machineList==null || machineList.equals(null)){
			System.out.println("�����б�Ϊ�գ�����");
			return null;
		}
		
		
		ArrayList<ProductionOrder> curTaskQueue;
		
		Stoll machine = null;		
		machine = machineList.get(machineId);
		
		if(machine == null){
			System.out.println("�޸ñ�Ŷ�Ӧ����������");
			return null;
		}
		
		curTaskQueue = machine.getTaskQueue();		
		
		return curTaskQueue;		
	}
	
	
	//���ݻ�����Ż�ȡ������ɵ�ǰ��������е�����Ԥ������ʱ��
	public int getEstimatedFinishTime(long machineId, HashMap<Long, Stoll> machineList){
		
		//�������
		if(machineList.size()==0 || machineList==null || machineList.equals(null)){
			System.out.println("�����б�Ϊ�գ�����");
			return -2;
		}
		
		
		int estimatedFinishTime;
		
		Stoll machine = null;		
		machine = machineList.get(machineId);
		
		if(machine == null){
			System.out.println("�޸ñ�Ŷ�Ӧ����������");
			return -1;
		}
		
		estimatedFinishTime = machine.getEstimatedFinishTime();		
		
		return estimatedFinishTime;		
	}
	

}
