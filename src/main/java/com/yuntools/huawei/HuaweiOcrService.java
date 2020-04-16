package com.yuntools.huawei;

import com.yuntools.entity.ResponseData;
import com.yuntools.util.HttpUtil;
import com.yuntools.util.JsonUtil;
import com.yuntools.util.StringUtil;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 华为通用文字识别
 * @author mantou
 */
public class HuaweiOcrService extends HuaweiBase{

	/**
	 * 构建service类必传的参数
	 *
	 * @param huaweiBaseData
	 */
	public HuaweiOcrService(HuaweiBaseData huaweiBaseData) {
		super(huaweiBaseData);
	}

	public String generalText(String image) throws IOException {
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(GENERAL_TEXT_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}
}
