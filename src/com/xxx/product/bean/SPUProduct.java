package com.xxx.product.bean;

/**
 * @author yuan
 *
 * @date 2016年3月18日 下午3:50:03
 */
public class SPUProduct extends Product{
	
	private long spuId;
	
	private String spu;
	private String[] skus;
	
	private String machine;
	
	
	/**
	 * @param spuId
	 * @param spu
	 * @param skus
	 */
	public SPUProduct(long spuId, String spu, String[] skus) {
		super();
		this.spuId = spuId;
		this.spu = spu;
		this.skus = skus;
	}


	/**
	 * @param spuId
	 * @param spu
	 * @param skus
	 * @param machine
	 */
	public SPUProduct(long spuId, String spu, String[] skus, String machine) {
		super();
		this.spuId = spuId;
		this.spu = spu;
		this.skus = skus;
		this.machine = machine;
	}


	/**
	 * @return the spuId
	 */
	public long getSpuId() {
		return spuId;
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
	 * @return the skus
	 */
	public String[] getSkus() {
		return skus;
	}


	/**
	 * @param skus the skus to set
	 */
	public void setSkus(String[] skus) {
		this.skus = skus;
	}


	/**
	 * @return the machine
	 */
	public String getMachine() {
		return machine;
	}


	/**
	 * @param machine the machine to set
	 */
	public void setMachine(String machine) {
		this.machine = machine;
	}
	

}
