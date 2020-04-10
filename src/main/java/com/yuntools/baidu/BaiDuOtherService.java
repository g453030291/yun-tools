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

	/**
	 * 表格文字识别(异步接口)
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param is_sync 是否同步返回识别结果。取值为“false”，需通过获取结果接口获取识别结果；取值为“true”，同步返回识别结果，无需调用获取结果接口。默认取值为“false”
	 * @param request_type 当 is_sync=true 时，需在提交请求时即传入此参数指定获取结果的类型，取值为“excel”时返回xls文件的地址，取值为“json”时返回json格式的字符串。当 is_sync=false 时，需在获取结果时指定此参数。
	 * @return
	 */
	public String formOcr(String image,Boolean is_sync,String request_type){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(3);
		map.put("image",image);
		if(!StringUtil.isEmpty(is_sync)){
			map.put("is_sync",is_sync.toString());
		}
		if(!StringUtil.isEmpty(request_type)){
			map.put("request_type",request_type);
		}
		String result = HttpUtil.postRequest(FORM_OCR_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 获取结果接口
	 * @param request_id 发送表格文字识别请求时返回的request id
	 * @param request_type 期望获取结果的类型，取值为“excel”时返回xls文件的地址，取值为“json”时返回json格式的字符串,默认为”excel”
	 * @return
	 */
	public String formOcrResult(String request_id,String request_type){
		if(StringUtil.isEmpty(request_id)){
			throw new NullPointerException("request_id为空");
		}
		Map<String,String> map = new HashMap<>(2);
		map.put("request_id",request_id);
		if(!StringUtil.isEmpty(request_type)){
			map.put("request_type",request_type);
		}
		String result = HttpUtil.postRequest(FORM_OCR_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 表格文字识别(同步接口)
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param table_border 识别表格对象是否有框线。缺省或 table_border = normal，可识别框线齐全的常规表格，table_border = none，可识别无框线表格。默认为normal
	 * @return
	 */
	public String formOcrSync(String image,String table_border){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(2);
		map.put("image",image);
		if(!StringUtil.isEmpty(table_border)){
			map.put("table_border",table_border);
		}
		String result = HttpUtil.postRequest(FORM_SYNC_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 数字识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
	 * @param detect_direction 是否检测图像朝向，默认不检测，即：false。可选值包括true - 检测朝向；false - 不检测朝向。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。
	 * @return
	 */
	public String numbers(String image,String recognize_granularity,Boolean detect_direction){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(2);
		map.put("image",image);
		if(!StringUtil.isEmpty(recognize_granularity)){
			map.put("recognize_granularity",recognize_granularity);
		}
		if(!StringUtil.isEmpty(detect_direction)){
			map.put("detect_direction",detect_direction.toString());
		}
		String result = HttpUtil.postRequest(NUMBERS_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 二维码识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String qrCode(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(QR_CODE_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 印章检测
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String seal(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(SEAL_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

}
