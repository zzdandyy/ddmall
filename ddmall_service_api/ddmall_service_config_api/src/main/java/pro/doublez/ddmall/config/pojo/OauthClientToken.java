package pro.doublez.ddmall.config.pojo;


public class OauthClientToken {

	private String tokenId;
	private String token;
	private String authenticationId;
	private String userName;
	private String clientId;


	//get方法
	public String getTokenId() {
		return tokenId;
	}

	//set方法
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	//get方法
	public String getToken() {
		return token;
	}

	//set方法
	public void setToken(String token) {
		this.token = token;
	}
	//get方法
	public String getAuthenticationId() {
		return authenticationId;
	}

	//set方法
	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}
	//get方法
	public String getUserName() {
		return userName;
	}

	//set方法
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//get方法
	public String getClientId() {
		return clientId;
	}

	//set方法
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


}
