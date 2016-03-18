package com.xxx.order;

/**
 * @author yuan
 *
 * @date 2016年3月18日 下午3:29:09
 */
public class ProductionOrder extends Order{
	
	private long productionOrderId;
	
	private String sku;
	private String skuPart;				//sku所包含的部分：前，后，袖子，领子等
	private int count;					//数量
	
	private int status;					//订单状态：0：未生产； 1：生产中； 2：生产完成； 3：不可生产
	
	private String material;			//生产所需原料：线的种类
	private double[] materialAmount;	//原料使用量（单位：g）
	
	private int estimatedFinishTime;	//预计完成时间=单件所需时间*count

	
	/**
	 * @param productionOrderId
	 * @param sku
	 * @param skuPart
	 * @param count
	 */
	public ProductionOrder(long productionOrderId, String sku, String skuPart,
			int count) {
		super();
		this.productionOrderId = productionOrderId;
		this.sku = sku;
		this.skuPart = skuPart;
		this.count = count;
		this.status = 0;
	}


	/**
	 * @param productionOrderId
	 * @param sku
	 * @param skuPart
	 * @param count
	 * @param status
	 */
	public ProductionOrder(long productionOrderId, String sku, String skuPart,
			int count, int status) {
		super();
		this.productionOrderId = productionOrderId;
		this.sku = sku;
		this.skuPart = skuPart;
		this.count = count;
		this.status = status;
	}


	/**
	 * @param productionOrderId
	 * @param sku
	 * @param skuPart
	 * @param count
	 * @param status
	 * @param material
	 */
	public ProductionOrder(long productionOrderId, String sku, String skuPart,
			int count, int status, String material) {
		super();
		this.productionOrderId = productionOrderId;
		this.sku = sku;
		this.skuPart = skuPart;
		this.count = count;
		this.status = status;
		this.material = material;
	}


	/**
	 * @return the productionOrderId
	 */
	public long getProductionOrderId() {
		return productionOrderId;
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
	 * @return the skuPart
	 */
	public String getSkuPart() {
		return skuPart;
	}


	/**
	 * @param skuPart the skuPart to set
	 */
	public void setSkuPart(String skuPart) {
		this.skuPart = skuPart;
	}


	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}


	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
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
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}


	/**
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}


	/**
	 * @return the materialAmount
	 */
	public double[] getMaterialAmount() {
		return materialAmount;
	}


	/**
	 * @param materialAmount the materialAmount to set
	 */
	public void setMaterialAmount(double[] materialAmount) {
		this.materialAmount = materialAmount;
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
	

}
