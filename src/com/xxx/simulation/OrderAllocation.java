package com.xxx.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.xxx.machine.bean.Machine;
import com.xxx.machine.bean.Stoll;
import com.xxx.order.bean.ProductionOrder;

/**
 * @author yuan
 *
 * @date 2016��5��7�� ����11:26:52
 */
public class OrderAllocation {
	
	//�����������
	//����״̬Ϊ���е����ȣ�status=0��
	//��ɵ�ǰ��������е�����Ԥ������ʱ��С�����ȣ�estimatedFinishTime��
	public void orderAllocation(ArrayList<Machine> machineList, ArrayList<ProductionOrder> proOrderList){		
		//1
		//��ȡ status = 0 �Ļ������б�
		//���䶩����  status = 0 �Ļ������б�
		for(int i=0; i<machineList.size(); ++i){
			Stoll stoll = (Stoll) machineList.get(i);
			if(stoll.getStatus() == 0){
				
				for(int j=0; j<proOrderList.size(); ++j){
					ProductionOrder pro = proOrderList.get(j);
					if(stoll.getProductList().contains(pro.getSku())){
						ArrayList<ProductionOrder> taskQueue = stoll.getTaskQueue();
						
						if(taskQueue == null){
							taskQueue = new ArrayList<ProductionOrder>();
						}
						
						taskQueue.add(pro);
						stoll.setStatus(1);
						
						stoll.setTaskQueue(taskQueue);
						stoll.setEstimatedFinishTime(stoll.getEstimatedFinishTime() + pro.getEstimatedFinishTime());
						
						machineList.set(i, stoll);
						proOrderList.remove(pro);
						break;
					}
					
					
				}
				
			}
		}
		
		//2
		//����ɵ�ǰ��������е�����Ԥ������ʱ���С����
		//���η�����������������������һ����
		
		//�Ƚ���
		Comparator<Machine> comparator = new Comparator<Machine>(){
			public int compare(Machine s1, Machine s2) {
				int flag = ((Stoll)s1).getEstimatedFinishTime() - ((Stoll)s2).getEstimatedFinishTime();
			
				if(flag > 0){
					return 1;
				} else if(flag < 0) {
					return -1;
				} else {
					return 0;
				}
			}
		};
		
		//����
		Collections.sort(machineList, comparator); 		
		
		//���䶩��				
		for(int j=0; j<proOrderList.size(); ++j){
			
			for(int i=0; i<machineList.size(); ++i){
				
				Stoll stoll = (Stoll) machineList.get(i);
				ProductionOrder pro = proOrderList.get(j);
				
				if(stoll.getProductList().contains(pro.getSku())){
					ArrayList<ProductionOrder> taskQueue = stoll.getTaskQueue();
					
					if(taskQueue == null){
						taskQueue = new ArrayList<ProductionOrder>();
					}
					
					taskQueue.add(pro);
					stoll.setStatus(1);
					
					stoll.setTaskQueue(taskQueue);
					stoll.setEstimatedFinishTime(stoll.getEstimatedFinishTime() + pro.getEstimatedFinishTime());
					
					machineList.set(i, stoll);
				}
				
			}
			
			//����
			Collections.sort(machineList, comparator); 
			
		}
		
	}

}
