package pro.doublez.ddmall.seckill.pojo;


import java.util.Date;

public class SeckillOrder {

	private Long id;
	private Long seckillId;
	private String money;
	private String userId;
	private String sellerId;
	private Date createTime;
	private Date payTime;
	private String status;
	private String receiverAddress;
	private String receiverMobile;
	private String receiver;
	private String transactionId;


	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public Long getSeckillId() {
		return seckillId;
	}

	//set方法
	public void setSeckillId(Long seckillId) {
		this.seckillId = seckillId;
	}
	//get方法
	public String getMoney() {
		return money;
	}

	//set方法
	public void setMoney(String money) {
		this.money = money;
	}
	//get方法
	public String getUserId() {
		return userId;
	}

	//set方法
	public void setUserId(String userId) {
		this.userId = userId;
	}
	//get方法
	public String getSellerId() {
		return sellerId;
	}

	//set方法
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	//get方法
	public Date getPayTime() {
		return payTime;
	}

	//set方法
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	//get方法
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}
	//get方法
	public String getReceiverAddress() {
		return receiverAddress;
	}

	//set方法
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	//get方法
	public String getReceiverMobile() {
		return receiverMobile;
	}

	//set方法
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	//get方法
	public String getReceiver() {
		return receiver;
	}

	//set方法
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	//get方法
	public String getTransactionId() {
		return transactionId;
	}

	//set方法
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


}
