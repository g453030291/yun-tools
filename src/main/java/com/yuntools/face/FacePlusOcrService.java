package com.yuntools.face;

import com.yuntools.util.HttpUtil;
import com.yuntools.util.JsonUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FacePlusOcrService extends FacePlusBase {

	/**
	 * 构建service必填
	 * @param facePlusBaseData
	 */
	public FacePlusOcrService(FacePlusBaseData facePlusBaseData) {
		super(facePlusBaseData);
	}

	private static String getBoundary() {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for(int i = 0; i < 32; ++i) {
			sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".length())));
		}
		return sb.toString();
	}

//	public String ocr(String image){
//		Map<String,String> map = new HashMap<>();
//		map.put("name",facePlusBaseData.getApiKey()+facePlusBaseData.getApiSecret());
//		//map.put("")
//		HttpUtil
//		return null;
//	}

}
