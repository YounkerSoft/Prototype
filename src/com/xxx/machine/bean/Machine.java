package com.xxx.machine.bean;

import java.util.ArrayList;

/**
 * @author yuan
 *
 * @date 2016��4��4�� ����4:46:33
 */
public class Machine {
	
	private String brand;							//����Ʒ��
	private String modelType;						//�����ͺ�
	private ArrayList<String> productList;			//�������������Ĳ�Ʒ�б�
	
	
	/**
	 * @param brand
	 * @param modelType
	 * @param productList
	 */
	public Machine(String brand, String modelType, ArrayList<String> productList) {
		super();
		this.brand = brand;
		this.modelType = modelType;
		this.productList = productList;
	}


	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}


	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}


	/**
	 * @return the modelType
	 */
	public String getModelType() {
		return modelType;
	}


	/**
	 * @param modelType the modelType to set
	 */
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}


	/**
	 * @return the productList
	 */
	public ArrayList<String> getProductList() {
		return productList;
	}


	/**
	 * @param productList the productList to set
	 */
	public void setProductList(ArrayList<String> productList) {
		this.productList = productList;
	}
}
