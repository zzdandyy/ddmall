package pro.doublez.ddmall.config.pojo;


import java.util.Date;

public class OauthApprovals {

	private String userId;
	private String clientId;
	private String scope;
	private String status;
	private Date expiresAt;
	private Date lastModifiedAt;


	//get方法
	public String getUserId() {
		return userId;
	}

	//set方法
	public void setUserId(String userId) {
		this.userId = userId;
	}
	//get方法
	public String getClientId() {
		return clientId;
	}

	//set方法
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	//get方法
	public String getScope() {
		return scope;
	}

	//set方法
	public void setScope(String scope) {
		this.scope = scope;
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
	public Date getExpiresAt() {
		return expiresAt;
	}

	//set方法
	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}
	//get方法
	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}

	//set方法
	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}


}
