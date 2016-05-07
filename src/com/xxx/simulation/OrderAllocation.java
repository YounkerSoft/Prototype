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
 * @date 2016年5月7日 上午11:26:52
 */
public class OrderAllocation {
	
	//订单分配策略
	//机器状态为空闲的优先（status=0）
	//完成当前任务队列中的任务预计所需时间小的优先（estimatedFinishTime）
	public void orderAllocation(ArrayList<Machine> machineList, ArrayList<ProductionOrder> proOrderList){		
		//1
		//获取 status = 0 的机器的列表
		//分配订单到  status = 0 的机器的列表
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
		//按完成当前任务队列中的任务预计所需时间大小排序
		//依次分配生产订单，分配依次排一下序
		
		//比较器
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
		
		//排序
		Collections.sort(machineList, comparator); 		
		
		//分配订单				
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
			
			//排序
			Collections.sort(machineList, comparator); 
			
		}
		
	}

}
