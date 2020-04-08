package com.yuntools.baidu;

/**
 * baidu 接口基础数据封装类
 * @author mantou
 */
public class BaiDuBaseData {

	private String clientId;

	private String clientSecret;

	private String accessToken;

	public BaiDuBaseData() {
	}

	public BaiDuBaseData(String clientId, String clientSecret, String accessToken) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.accessToken = accessToken;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
