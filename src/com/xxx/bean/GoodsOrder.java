package com.xxx.bean;

/**
 * @author yuan
 *
 * @date 2016年3月18日 下午3:00:04
 */
public class GoodsOrder extends Order{
	
	private long goodsId;
	
	private String spu;				//SPU是商品编码 SKU是商品下的一个分类属性
	private String[] sku[];			//商品的具体分类颜色，尺寸等
	private int[] counts[];			//每个sku对应的订单数量
	private int totalCounts;		//当前订单总的数量
	
	private int status;				//订单状态：0：未生产； 1：生产中； 2：生产完成； 3：不可生产
	
	private int orderTime;			//下单时间，先用int模拟，后期修改为date
	private int deadLine;			//订单截止时间
	
	private int startTime;			//订单开始生产时间
	private int estimatedFinishTime;//预计完成时间
	private int endTime;			//订单完成时间
	
	
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
