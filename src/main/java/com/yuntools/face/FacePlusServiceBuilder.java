package com.yuntools.face;

public class FacePlusServiceBuilder {

	private String apiKey;

	private String apiSecret;

	public FacePlusServiceBuilder setApiKey(String apiKey) {
		this.apiKey = apiKey;
		return this;
	}

	public FacePlusServiceBuilder setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
		return this;
	}

	public FacePlusOcrService build(){
		FacePlusBaseData data = new FacePlusBaseData(apiKey,apiSecret);
		//return new FacePlusOcrService();
		return null;
	}
}
