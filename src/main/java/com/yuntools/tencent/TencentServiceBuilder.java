package com.yuntools.tencent;

import com.yuntools.baidu.BaiDuBaseData;
import com.yuntools.baidu.BaiDuCardService;
import com.yuntools.baidu.BaiDuInvoiceService;
import com.yuntools.baidu.BaiDuService;
import com.yuntools.entity.AccessToken;
import com.yuntools.util.HttpUtil;
import com.yuntools.util.JsonUtil;
import com.yuntools.util.PropertiesUtil;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * tencent 文字识别
 * @author mantou
 */
public class TencentServiceBuilder {

	private final static String CHARSET = "UTF-8";

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

	private final static Charset UTF8 = StandardCharsets.UTF_8;
	private final static String SECRET_ID = "";
	private final static String SECRET_KEY = "";
	private final static String CT_JSON = "application/json; charset=utf-8";

	public static byte[] hmac256(byte[] key, String msg) throws Exception {
		Mac mac = Mac.getInstance("HmacSHA256");
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, mac.getAlgorithm());
		mac.init(secretKeySpec);
		return mac.doFinal(msg.getBytes(UTF8));
	}

	public static String sha256Hex(String s) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] d = md.digest(s.getBytes(UTF8));
		return DatatypeConverter.printHexBinary(d).toLowerCase();
	}

	private static String getAccessToken(String clientId, String clientSecret) throws Exception {
		String getAccessTokenUrl = PropertiesUtil.getPropertiesValue("tencent.cvm.url");
		String service = "cvm";
		String host = "cvm.tencentcloudapi.com";
		String region = "ap-guangzhou";
		String action = "DescribeInstances";
		String version = "2017-03-12";
		String algorithm = "TC3-HMAC-SHA256";
		String timestamp = "1551113065";
		//String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 注意时区，否则容易出错
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String date = sdf.format(new Date(Long.valueOf(timestamp + "000")));

		// ************* 步骤 1：拼接规范请求串 *************
		String httpRequestMethod = "POST";
		String canonicalUri = "/";
		String canonicalQueryString = "";
		String canonicalHeaders = "content-type:application/json; charset=utf-8\n" + "host:" + host + "\n";
		String signedHeaders = "content-type;host";

		String payload = "{\"Limit\": 1, \"Filters\": [{\"Values\": [\"\\u672a\\u547d\\u540d\"], \"Name\": \"instance-name\"}]}";
		Map<String,String> map = new HashMap<>();
		map.put("Limit","1");
		map.put("Filters","[{\"Values\": [\"\\u672a\\u547d\\u540d\"], \"Name\": \"instance-name\"}]");
		String hashedRequestPayload = sha256Hex(payload);
		String canonicalRequest = httpRequestMethod + "\n" + canonicalUri + "\n" + canonicalQueryString + "\n"
				+ canonicalHeaders + "\n" + signedHeaders + "\n" + hashedRequestPayload;
		System.out.println(canonicalRequest);

		// ************* 步骤 2：拼接待签名字符串 *************
		String credentialScope = date + "/" + service + "/" + "tc3_request";
		String hashedCanonicalRequest = sha256Hex(canonicalRequest);
		String stringToSign = algorithm + "\n" + timestamp + "\n" + credentialScope + "\n" + hashedCanonicalRequest;
		System.out.println(stringToSign);

		// ************* 步骤 3：计算签名 *************
		byte[] secretDate = hmac256(("TC3" + SECRET_KEY).getBytes(UTF8), date);
		byte[] secretService = hmac256(secretDate, service);
		byte[] secretSigning = hmac256(secretService, "tc3_request");
		String signature = DatatypeConverter.printHexBinary(hmac256(secretSigning, stringToSign)).toLowerCase();
		System.out.println(signature);

		// ************* 步骤 4：拼接 Authorization *************
		String authorization = algorithm + " " + "Credential=" + SECRET_ID + "/" + credentialScope + ", "
				+ "SignedHeaders=" + signedHeaders + ", " + "Signature=" + signature;
		System.out.println(authorization);

		TreeMap<String, String> headers = new TreeMap<String, String>();
		headers.put("Authorization", authorization);
		headers.put("Content-Type", "application/json; charset=utf-8");
		headers.put("Host", host);
		headers.put("X-TC-Action", action);
		headers.put("X-TC-Timestamp", timestamp);
		headers.put("X-TC-Version", version);
		headers.put("X-TC-Region", region);

		String result = HttpUtil.postRequest(getAccessTokenUrl,map,headers);
		System.out.println("result--------------------------");
		System.out.println(result);

		StringBuilder sb = new StringBuilder();
		sb.append("curl -X POST https://").append(host)
				.append(" -H \"Authorization: ").append(authorization).append("\"")
				.append(" -H \"Content-Type: application/json; charset=utf-8\"")
				.append(" -H \"Host: ").append(host).append("\"")
				.append(" -H \"X-TC-Action: ").append(action).append("\"")
				.append(" -H \"X-TC-Timestamp: ").append(timestamp).append("\"")
				.append(" -H \"X-TC-Version: ").append(version).append("\"")
				.append(" -H \"X-TC-Region: ").append(region).append("\"")
				.append(" -d '").append(payload).append("'");
		System.out.println(sb.toString());
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
