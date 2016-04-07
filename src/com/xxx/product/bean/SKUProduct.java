package com.xxx.product.bean;

import java.util.HashMap;

/**
 * @author yuan
 *
 * @date 2016年3月18日 下午4:01:54
 */
public class SKUProduct extends Product{
	
	private long skuProductId;
	
	private String sku;
	private String spu;
	private String[] skuParts;
	private String[][] materials;
	private double[][] materialsAmount;
	private HashMap<String, Integer> requiredTime;
	


	/**
	 * @param skuProductId
	 * @param sku
	 * @param spu
	 * @param skuParts
	 * @param materials
	 * @param materialsAmount
	 * @param requiredTime
	 */
	public SKUProduct(long skuProductId, String sku, String spu,
			String[] skuParts, String[][] materials,
			double[][] materialsAmount, HashMap<String, Integer> requiredTime) {
		super();
		this.skuProductId = skuProductId;
		this.sku = sku;
		this.spu = spu;
		this.skuParts = skuParts;
		this.materials = materials;
		this.materialsAmount = materialsAmount;
		this.requiredTime = requiredTime;
	}


	/**
	 * @return the skuProductId
	 */
	public long getSkuProductId() {
		return skuProductId;
	}


	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}


	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}


	/**
	 * @return the spu
	 */
	public String getSpu() {
		return spu;
	}


	/**
	 * @param spu the spu to set
	 */
	public void setSpu(String spu) {
		this.spu = spu;
	}


	/**
	 * @return the skuParts
	 */
	public String[] getSkuParts() {
		return skuParts;
	}


	/**
	 * @param skuParts the skuParts to set
	 */
	public void setSkuParts(String[] skuParts) {
		this.skuParts = skuParts;
	}


	/**
	 * @return the materials
	 */
	public String[][] getMaterials() {
		return materials;
	}


	/**
	 * @param materials the materials to set
	 */
	public void setMaterials(String[][] materials) {
		this.materials = materials;
	}


	/**
	 * @return the materialsAmount
	 */
	public double[][] getMaterialsAmount() {
		return materialsAmount;
	}


	/**
	 * @param materialsAmount the materialsAmount to set
	 */
	public void setMaterialsAmount(double[][] materialsAmount) {
		this.materialsAmount = materialsAmount;
	}


	/**
	 * @return the requiredTime
	 */
	public HashMap<String, Integer> getRequiredTime() {
		return requiredTime;
	}


	/**
	 * @param requiredTime the requiredTime to set
	 */
	public void setRequiredTime(HashMap<String, Integer> requiredTime) {
		this.requiredTime = requiredTime;
	}
	

}
