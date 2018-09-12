package org.dousnl.test;

public enum DCType {
	/** 
	 * IQ:询单，报价：QT，合同：CT, AP:担保合同号 ,资信调查 : CI, 限额申请 : CA, 支付 : PM, 物流 : LG, 收款人 RcvMen, 付款人 PayMen ,商品  Product , 境内支付结果 PayResult, 境外支付结果 DCPayResult ,东方付通商城号 PayMall,模板号FTM.
	 */

 	IQ("IQ"),QT("QT"),CT("CT"),AP("AP"),CI("CI"), CA("CA"), GD("GD"), PM("PM"), LG("LG"), SPT("SPT"), SPR("SPR"), FT("FT"), FI("FI"),RcvMen("RCV"),PayMen("PAY"),Product("Product"),PayResult("PR"),DCPayResult("DCPR"),PayMall("PayMall"),OrderCancel("OC"),OrderCancelHistory("OCH"),FTM("FTM"),BS("BS");
 	
	private String value;
	
	private DCType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value){
		this.value = value;
	}
}
