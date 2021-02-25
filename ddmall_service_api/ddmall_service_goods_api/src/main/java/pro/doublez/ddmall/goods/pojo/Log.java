package pro.doublez.ddmall.goods.pojo;

import java.io.Serializable;

/**
 * log实体类
 *
 */

public class Log implements Serializable {

	private Long id;//id

	private Long branchId;//分支id
	private String xid;//xid
	private byte[] rollbackInfo;//回滚统计
	private Integer logStatus;//日志状态
	private java.util.Date logCreated;//日志创建时间
	private java.util.Date logModified;//日志最后修改时间
	private String ext;//拓展

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getBranchId() {
		return branchId;
	}
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getXid() {
		return xid;
	}
	public void setXid(String xid) {
		this.xid = xid;
	}

	public byte[] getRollbackInfo() {
		return rollbackInfo;
	}
	public void setRollbackInfo(byte[] rollbackInfo) {
		this.rollbackInfo = rollbackInfo;
	}

	public Integer getLogStatus() {
		return logStatus;
	}
	public void setLogStatus(Integer logStatus) {
		this.logStatus = logStatus;
	}

	public java.util.Date getLogCreated() {
		return logCreated;
	}
	public void setLogCreated(java.util.Date logCreated) {
		this.logCreated = logCreated;
	}

	public java.util.Date getLogModified() {
		return logModified;
	}
	public void setLogModified(java.util.Date logModified) {
		this.logModified = logModified;
	}

	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}



}
