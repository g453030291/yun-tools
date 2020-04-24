package com.yuntools.face;

public class FacePlusBaseData {

	/**
	 * api_key
	 */
	private String apiKey;

	/**
	 * api_secret
	 */
	private String apiSecret;

	public FacePlusBaseData() {
	}

	public FacePlusBaseData(String apiKey, String apiSecret) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}
}
