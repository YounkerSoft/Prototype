package com.xxx.machine;

import java.sql.SQLException;
import java.util.ArrayList;

import com.xxx.machine.bean.Machine;
import com.xxx.machine.bean.Stoll;

/**
 * @author yuan
 *
 * @date 2016��5��6�� ����7:07:30
 */
public class MachineGeneration {
	
	
	//���ɻ����б�
	public ArrayList<Machine> machineListGeneration() throws SQLException{
		
		ArrayList<Machine> machineList = new ArrayList<Machine>();
		
		//���һ̨����
		machineList.add(machineGeneration());		
		
		return machineList;
		
	}
	
	
	//====>>��һ����<<====
	//����ָ������
	public Machine machineGeneration() throws SQLException{
		
		MachineOperation machineOper = new MachineOperation();
		
		long machineId = 0;
		String brand = "stoll";
		String modelType = "stoll_1";	
		ArrayList<String> productList = machineOper.getProductList(modelType);
		String location = "TX";
		String factory = "RedAnt";
		int status = 0;
		
		Machine machine = new Stoll(machineId, brand, modelType, productList, location, factory, status);
	
		return machine;
	}
	

}
