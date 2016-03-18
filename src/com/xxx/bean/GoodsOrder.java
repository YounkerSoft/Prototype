package com.xxx.bean;

/**
 * @author yuan
 *
 * @date 2016��3��18�� ����3:00:04
 */
public class GoodsOrder extends Order{
	
	private long goodsId;
	
	private String spu;				//SPU����Ʒ���� SKU����Ʒ�µ�һ����������
	private String[] sku[];			//��Ʒ�ľ��������ɫ���ߴ��
	private int[] counts[];			//ÿ��sku��Ӧ�Ķ�������
	private int totalCounts;		//��ǰ�����ܵ�����
	
	private int status;				//����״̬��0��δ������ 1�������У� 2��������ɣ� 3����������
	
	private int orderTime;			//�µ�ʱ�䣬����intģ�⣬�����޸�Ϊdate
	private int deadLine;			//������ֹʱ��
	
	private int startTime;			//������ʼ����ʱ��
	private int estimatedFinishTime;//Ԥ�����ʱ��
	private int endTime;			//�������ʱ��
	
	
	/**
	 * @param goodsId
	 * @param spu
	 * @param sku
	 * @param counts
	 * @param totalCounts
	 */
	public GoodsOrder(long goodsId, String spu, String[][] sku, int[][] counts,
			int totalCounts) {
		super();
		this.goodsId = goodsId;
		this.spu = spu;
		this.sku = sku;
		this.counts = counts;
		this.totalCounts = totalCounts;
		this.status = 0;
	}


	/**
	 * @param goodsId
	 * @param spu
	 * @param sku
	 * @param counts
	 * @param totalCounts
	 * @param status
	 * @param orderTime
	 * @param deadLine
	 */
	public GoodsOrder(long goodsId, String spu, String[][] sku, int[][] counts,
			int totalCounts, int status, int orderTime, int deadLine) {
		super();
		this.goodsId = goodsId;
		this.spu = spu;
		this.sku = sku;
		this.counts = counts;
		this.totalCounts = totalCounts;
		this.status = status;
		this.orderTime = orderTime;
		this.deadLine = deadLine;
	}


	/**
	 * @return the goodsId
	 */
	public long getGoodsId() {
		return goodsId;
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
	public String[][] getSku() {
		return sku;
	}


	/**
	 * @param sku the sku to set
	 */
	public void setSku(String[][] sku) {
		this.sku = sku;
	}


	/**
	 * @return the counts
	 */
	public int[][] getCounts() {
		return counts;
	}


	/**
	 * @param counts the counts to set
	 */
	public void setCounts(int[][] counts) {
		this.counts = counts;
	}


	/**
	 * @return the totalCounts
	 */
	public int getTotalCounts() {
		return totalCounts;
	}


	/**
	 * @param totalCounts the totalCounts to set
	 */
	public void setTotalCounts(int totalCounts) {
		this.totalCounts = totalCounts;
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
