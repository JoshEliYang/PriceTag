package cn.springmvc.model;

/**
 * 
 * @author Edward
 * @description  调拨物品
 * @date 2016年6月12日
 */
public class TransferGood {

	private int id;

	// 调拨单号
	private int orderId;

	// 物品类型1.sku 2.equ
	private String goodType;

	// 物品编号
	private String goodNo;

	// 物品名称
	private String goodName;

	// 调拨数量
	private int num;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getGoodType() {
		return goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getGoodNo() {
		return goodNo;
	}

	public void setGoodNo(String goodNo) {
		this.goodNo = goodNo;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public TransferGood() {
		// TODO Auto-generated constructor stub
	}

	public TransferGood(int id, int orderId, String goodType, String goodNo, String goodName, int num) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.goodType = goodType;
		this.goodNo = goodNo;
		this.goodName = goodName;
		this.num = num;
	}

	@Override
	public String toString() {
		return "TransferGood [id=" + id + ", orderId=" + orderId + ", goodType=" + goodType + ", goodNo=" + goodNo
				+ ", goodName=" + goodName + ", num=" + num + "]";
	}

}
