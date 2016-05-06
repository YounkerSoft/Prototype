package com.xxx.machine;

import java.sql.SQLException;
import java.util.ArrayList;

import com.xxx.machine.bean.Machine;
import com.xxx.machine.bean.Stoll;

/**
 * @author yuan
 *
 * @date 2016年5月6日 下午7:07:30
 */
public class MachineGeneration {
	
	
	//生成机器列表
	public ArrayList<Machine> machineListGeneration() throws SQLException{
		
		ArrayList<Machine> machineList = new ArrayList<Machine>();
		
		//添加一台机器
		machineList.add(machineGeneration());		
		
		return machineList;
		
	}
	
	
	//====>>单一机器<<====
	//生成指定机器
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
