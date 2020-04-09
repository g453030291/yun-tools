package com.yuntools.baidu;

import com.yuntools.util.HttpUtil;
import com.yuntools.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 票据文字识别
 * @author mantou
 */
public class BaiDuInvoiceService extends BaiDuBase{
	/**
	 * 构建service类必传的参数
	 *
	 * @param baiDuBaseData
	 */
	public BaiDuInvoiceService(BaiDuBaseData baiDuBaseData) {
		super(baiDuBaseData);
	}

	/**
	 * 增值税发票识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param type 进行识别的增值税发票类型，默认为 normal，可缺省
	 * 				- normal：可识别增值税普票、专票、电子发票
	 * 				- roll：可识别增值税卷票
	 * @return
	 */
	public String vatInvoice(String image,String type){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(3);
		map.put("image",image);
		if(!StringUtil.isEmpty(type)){
			map.put("type",type);
		}
		String result = HttpUtil.postRequest(VAT_INVOICE_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 定额发票识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String quotaInvoice(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(QUOTA_INVOICE_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 通用机打发票识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param location 是否输出位置信息，true：输出位置信息，false：不输出位置信息，默认false
	 * @return
	 */
	public String invoice(String image,Boolean location){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		if(!StringUtil.isEmpty(location)){
			map.put("location",location.toString());
		}
		String result = HttpUtil.postRequest(INVOICE_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 火车票识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String trainTicket(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(TRAIN_TICKET_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 出租车票识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String taxiReceipt(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(TAXI_RECEIPT_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 行程单识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String airTicket(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(AIR_TICKET_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 通用票据识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
	 * @param probability 是否返回识别结果中每一行的置信度
	 * @param accuracy normal 使用快速服务;缺省或其它值使用高精度服务
	 * @param detect_direction 是否检测图像朝向，默认不检测，即：false。可选值包括true - 检测朝向；false - 不检测朝向。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。
	 * @return
	 */
	public String receipt(String image,String recognize_granularity,Boolean probability,String accuracy,Boolean detect_direction){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		if(!StringUtil.isEmpty(recognize_granularity)){
			map.put("recognize_granularity",recognize_granularity);
		}
		if(!StringUtil.isEmpty(probability)){
			map.put("probability",probability.toString());
		}
		if(!StringUtil.isEmpty(accuracy)){
			map.put("accuracy",accuracy);
		}
		if(!StringUtil.isEmpty(detect_direction)){
			map.put("detect_direction",detect_direction.toString());
		}
		String result = HttpUtil.postRequest(RECEIPT_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 保单识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param kv_business 是否进行商业逻辑处理，true：进行商业逻辑处理，false：不进行商业逻辑处理，默认true
	 * @return
	 */
	public String insuranceDcuments(String image,Boolean kv_business){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(3);
		map.put("image",image);
		if(!StringUtil.isEmpty(kv_business)){
			map.put("kv_business",kv_business.toString());
		}
		String result = HttpUtil.postRequest(INSURANCE_DOCUMENTS_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 彩票识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
	 * @return
	 */
	public String lottery(String image,String recognize_granularity){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(3);
		map.put("image",image);
		if(!StringUtil.isEmpty(recognize_granularity)){
			map.put("recognize_granularity",recognize_granularity);
		}
		String result = HttpUtil.postRequest(LOTTERY_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

}
