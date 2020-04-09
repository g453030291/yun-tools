package com.yuntools.baidu;

import com.yuntools.util.HttpUtil;
import com.yuntools.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 其它文字识别
 * @author mantou
 */
public class BaiDuOtherService extends BaiDuBase{

	/**
	 * 构建service类必传的参数
	 *
	 * @param baiDuBaseData
	 */
	public BaiDuOtherService(BaiDuBaseData baiDuBaseData) {
		super(baiDuBaseData);
	}

	/**
	 * 网络图片文字识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式，当image字段存在时url字段失效
	 * @param url 图片完整URL，URL长度不超过1024字节，URL对应的图片base64编码后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式，当image字段存在时url字段失效，不支持https的图片链接
	 * @param detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:
	 * - true：检测朝向；
	 * - false：不检测朝向。
	 * @param detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
	 * @return
	 */
	public String webImage(String image,String url,Boolean detect_direction,Boolean detect_language){
		if(StringUtil.isEmpty(image) && StringUtil.isEmpty(url)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(4);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}
		if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}
		if(!StringUtil.isEmpty(detect_direction)){
			map.put("detect_direction",detect_direction.toString());
		}
		if(!StringUtil.isEmpty(detect_language)){
			map.put("detect_language",detect_language.toString());
		}
		String result = HttpUtil.postRequest(WEB_IMAGE_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

}
