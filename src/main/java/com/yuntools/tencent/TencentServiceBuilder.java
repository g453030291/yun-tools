package com.yuntools.tencent;

import com.yuntools.baidu.BaiDuBaseData;
import com.yuntools.baidu.BaiDuCardService;
import com.yuntools.baidu.BaiDuInvoiceService;
import com.yuntools.baidu.BaiDuService;
import com.yuntools.entity.AccessToken;
import com.yuntools.util.HttpUtil;
import com.yuntools.util.JsonUtil;
import com.yuntools.util.PropertiesUtil;

/**
 * tencent 文字识别
 * @author mantou
 */
public class TencentServiceBuilder {

	private String secretId;

	private String secretKey;

	private BaiDuService baiDuService;

	private BaiDuBaseData baiDuBaseData;

	public TencentServiceBuilder setSecretId(String secretId){
		this.secretId = secretId;
		return this;
	}

	public TencentServiceBuilder setSecretKey(String secretKey){
		this.secretKey = secretKey;
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
		AccessToken accessToken = (AccessToken) JsonUtil.fromJsonString(HttpUtil.getRequest(getAccessTokenUrl), AccessToken.class);
		return accessToken.getAccess_token();
	}

	public void test(){
		HttpUtil
	}

//	public BaiDuService buildOcrService(){
//		baiDuBaseData = new BaiDuBaseData(clientId,clientSecret,getAccessToken(clientId,clientSecret));
//		baiDuService = new BaiDuService(baiDuBaseData);
//		return baiDuService;
//	}

}
