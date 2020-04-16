package com.yuntools.baidu;

import com.yuntools.entity.AccessToken;
import com.yuntools.util.HttpUtil;
import com.yuntools.util.JsonUtil;
import com.yuntools.util.PropertiesUtil;

/**
 * 百度文字识别
 * @author mantou
 */
public class BaiDuServiceBuilder {

	private String clientId;

	private String clientSecret;

	private BaiDuService baiDuService;

	private BaiDuCardService baiDuCardService;

	private BaiDuInvoiceService baiDuInvoiceService;

	private BaiDuBaseData baiDuBaseData;

	public BaiDuServiceBuilder setClientId(String clientId){
		this.clientId = clientId;
		return this;
	}

	public BaiDuServiceBuilder setClientSecret(String clientSecret){
		this.clientSecret = clientSecret;
		return this;
	}

	private String getAccessToken(String clientId,String clientSecret){
		String getAccessTokenUrl = PropertiesUtil.getPropertiesValue("baidu.auth.host.url")
				// 1. grant_type为固定参数
				+ "?grant_type=client_credentials"
				// 2. 官网获取的 API Key
				+ "&client_id=" + clientId
				// 3. 官网获取的 Secret Key
				+ "&client_secret=" + clientSecret;
		AccessToken accessToken = JsonUtil.fromJsonString(HttpUtil.getRequest(getAccessTokenUrl), AccessToken.class);
		return accessToken.getAccess_token();
	}

	public BaiDuService buildOcrService(){
		baiDuBaseData = new BaiDuBaseData(clientId,clientSecret,getAccessToken(clientId,clientSecret));
		baiDuService = new BaiDuService(baiDuBaseData);
		return baiDuService;
	}

	public BaiDuCardService buildCardServie(){
		baiDuBaseData = new BaiDuBaseData(clientId,clientSecret,getAccessToken(clientId,clientSecret));
		baiDuCardService = new BaiDuCardService(baiDuBaseData);
		return baiDuCardService;
	}

	public BaiDuCardService buildInvoiceServie(){
		baiDuBaseData = new BaiDuBaseData(clientId,clientSecret,getAccessToken(clientId,clientSecret));
		baiDuInvoiceService = new BaiDuInvoiceService(baiDuBaseData);
		return baiDuCardService;
	}

}
