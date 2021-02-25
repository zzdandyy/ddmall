package pro.doublez.ddmall.user.pojo;


import java.util.Date;

public class Pref {

	private Integer id;
	private Integer cateId;
	private Integer buyMoney;
	private Integer preMoney;
	private Date startTime;
	private Date endTime;
	private String type;
	private String state;


	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public Integer getCateId() {
		return cateId;
	}

	//set方法
	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}
	//get方法
	public Integer getBuyMoney() {
		return buyMoney;
	}

	//set方法
	public void setBuyMoney(Integer buyMoney) {
		this.buyMoney = buyMoney;
	}
	//get方法
	public Integer getPreMoney() {
		return preMoney;
	}

	//set方法
	public void setPreMoney(Integer preMoney) {
		this.preMoney = preMoney;
	}
	//get方法
	public Date getStartTime() {
		return startTime;
	}

	//set方法
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	//get方法
	public Date getEndTime() {
		return endTime;
	}

	//set方法
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	//get方法
	public String getType() {
		return type;
	}

	//set方法
	public void setType(String type) {
		this.type = type;
	}
	//get方法
	public String getState() {
		return state;
	}

	//set方法
	public void setState(String state) {
		this.state = state;
	}


}
