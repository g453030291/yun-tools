package com.yuntools.baidu;

/**
 * 百度文字识别
 * @author mantou
 */
public class BaiDuServiceBuilder {

	private String clientId;

	private String clientSecret;

	private BaiDuService baiDuService = new BaiDuService();

	public BaiDuServiceBuilder setClientId(String clientId){
		this.clientId = clientId;
		return this;
	}

	public BaiDuServiceBuilder setClientSecret(String clientSecret){
		this.clientSecret = clientSecret;
		return this;
	}

	public BaiDuService build(){
		return baiDuService;
	}

}
