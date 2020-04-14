package com.yuntools.huawei;

/**
 * tencent 接口基础数据封装类
 * @author mantou
 */
public class HuaweiBaseData {

	private String secretId;

	private String secretKey;

	private String accessToken;

	public HuaweiBaseData() {
	}

	public HuaweiBaseData(String secretId, String secretKey, String accessToken) {
		this.secretId = secretId;
		this.secretKey = secretKey;
		this.accessToken = accessToken;
	}

	public String getSecretId() {
		return secretId;
	}

	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
