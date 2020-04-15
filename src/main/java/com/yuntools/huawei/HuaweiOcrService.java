package com.yuntools.huawei;

import com.yuntools.util.HttpUtil;
import com.yuntools.util.StringUtil;

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

	public String generalText(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);

		return result;
	}
}
