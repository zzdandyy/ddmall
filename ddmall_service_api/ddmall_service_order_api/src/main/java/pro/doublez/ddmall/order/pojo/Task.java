package pro.doublez.ddmall.order.pojo;


import java.util.Date;

public class Task{

	private Long id;
	private Date createTime;
	private Date updateTime;
	private Date deleteTime;
	private String taskType;
	private String mqExchange;
	private String mqRoutingkey;
	private String requestBody;
	private String status;
	private String errormsg;


	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
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
	public Date getUpdateTime() {
		return updateTime;
	}

	//set方法
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	//get方法
	public Date getDeleteTime() {
		return deleteTime;
	}

	//set方法
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	//get方法
	public String getTaskType() {
		return taskType;
	}

	//set方法
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	//get方法
	public String getMqExchange() {
		return mqExchange;
	}

	//set方法
	public void setMqExchange(String mqExchange) {
		this.mqExchange = mqExchange;
	}
	//get方法
	public String getMqRoutingkey() {
		return mqRoutingkey;
	}

	//set方法
	public void setMqRoutingkey(String mqRoutingkey) {
		this.mqRoutingkey = mqRoutingkey;
	}
	//get方法
	public String getRequestBody() {
		return requestBody;
	}

	//set方法
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
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
	public String getErrormsg() {
		return errormsg;
	}

	//set方法
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}


}
