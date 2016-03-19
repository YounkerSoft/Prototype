package com.xxx.order.bean;

/**
 * @author yuan
 *
 * @date 2016��3��18�� ����3:16:43
 */
public class SKUOrder extends Order{
	
	private long skuOrderId;
	
	private String spu;
	private String sku;
	private int count;
	
	private int status;				//����״̬��0��δ������ 1�������У� 2��������ɣ� 3����������
	
	private int orderTime;			//�µ�ʱ�䣬����intģ�⣬�����޸�Ϊdate
	private int deadLine;			//������ֹʱ��
	
	private int startTime;			//������ʼ����ʱ��
	private int estimatedFinishTime;//Ԥ�����ʱ��
	private int endTime;			//�������ʱ��
	
	
	/**
	 * @param skuOrderId
	 * @param spu
	 * @param sku
	 * @param count
	 */
	public SKUOrder(long skuOrderId, String spu, String sku, int count) {
		super();
		this.skuOrderId = skuOrderId;
		this.spu = spu;
		this.sku = sku;
		this.count = count;
		this.status = 0;
	}


	/**
	 * @param skuOrderId
	 * @param spu
	 * @param sku
	 * @param count
	 * @param status
	 */
	public SKUOrder(long skuOrderId, String spu, String sku, int count,
			int status) {
		super();
		this.skuOrderId = skuOrderId;
		this.spu = spu;
		this.sku = sku;
		this.count = count;
		this.status = status;
	}


	/**
	 * @param skuOrderId
	 * @param spu
	 * @param sku
	 * @param count
	 * @param status
	 * @param orderTime
	 * @param deadLine
	 */
	public SKUOrder(long skuOrderId, String spu, String sku, int count,
			int status, int orderTime, int deadLine) {
		super();
		this.skuOrderId = skuOrderId;
		this.spu = spu;
		this.sku = sku;
		this.count = count;
		this.status = status;
		this.orderTime = orderTime;
		this.deadLine = deadLine;
	}


	/**
	 * @return the skuOrderId
	 */
	public long getSkuOrderId() {
		return skuOrderId;
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
	 * @return the orderTime
	 */
	public int getOrderTime() {
		return orderTime;
	}


	/**
	 * @param orderTime the orderTime to set
	 */
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}


	/**
	 * @return the deadLine
	 */
	public int getDeadLine() {
		return deadLine;
	}


	/**
	 * @param deadLine the deadLine to set
	 */
	public void setDeadLine(int deadLine) {
		this.deadLine = deadLine;
	}


	/**
	 * @return the startTime
	 */
	public int getStartTime() {
		return startTime;
	}


	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
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
	 * @return the endTime
	 */
	public int getEndTime() {
		return endTime;
	}


	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	
	
	

}
