package com.yuntools.huawei;

import com.yuntools.baidu.BaiDuBaseData;
import com.yuntools.baidu.BaiDuService;
import com.yuntools.entity.Domain;
import com.yuntools.entity.HuaweiAuth;
import com.yuntools.util.HttpUtil;
import com.yuntools.util.PropertiesUtil;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * tencent 文字识别
 * @author mantou
 */
public class HuaweiServiceBuilder {

	private final static String CHARSET = "UTF-8";

	private String secretId;

	private String secretKey;

	private BaiDuService baiDuService;

	private BaiDuBaseData baiDuBaseData;

	public HuaweiServiceBuilder setSecretId(String secretId){
		this.secretId = secretId;
		return this;
	}

	public HuaweiServiceBuilder setSecretKey(String secretKey){
		this.secretKey = secretKey;
		return this;
	}

	private static String getAccessToken(String clientId, String clientSecret) throws Exception {
		String getAccessTokenUrl = PropertiesUtil.getPropertiesValue("tencent.cvm.url");
		//其它
		String url = "https://ocr.cn-north-4.myhuaweicloud.com";
		//英文海关单据识别、手写文字识别
		String url1 = "https://ocr.cn-north-1.myhuaweicloud.com";
		//网络图片识别
		String url2 = "https://ocr.cn-south-1.myhuaweicloud.com";

		String huaweiToken = "https://iam.myhuaweicloud.com/v3/auth/tokens?";

		Domain domain = new Domain();
		domain.setName("用户所属账号的名称");

		HuaweiAuth.Identity_scope.Identity identity = new HuaweiAuth.Identity_scope.Identity();
		HuaweiAuth.Identity_scope.Scope scope = new HuaweiAuth.Identity_scope.Scope();
		scope.setDomain(domain);
		identity.setMethods(Arrays.asList("password"));
		HuaweiAuth auth = new HuaweiAuth();
		auth.setAuth();

		String json = "";


		return null;
	}

	public static void main(String[] args) throws Exception {
		getAccessToken(null,null);
	}

//	public BaiDuService buildOcrService(){
//		baiDuBaseData = new BaiDuBaseData(clientId,clientSecret,getAccessToken(clientId,clientSecret));
//		baiDuService = new BaiDuService(baiDuBaseData);
//		return baiDuService;
//	}

}
