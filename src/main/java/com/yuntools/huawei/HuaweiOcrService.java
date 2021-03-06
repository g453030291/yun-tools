package com.yuntools.huawei;

import com.yuntools.entity.ResponseData;
import com.yuntools.util.HttpUtil;
import com.yuntools.util.JsonUtil;
import com.yuntools.util.StringUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

	/**
	 * 通用文字识别
	 * image和ur必须传一个,如果都传,默认识别image
	 * @param image 图片base64编码
	 * @param url 图片url地址
	 * @param detect_direction 图片朝向检测开关，可选值包括：
	 * true：检测图片朝向；
	 * false：不检测图片朝向。
	 * 支持任意角度的图片朝向检测。未传入该参数时默认为false，即不检测图片朝向。
	 * @param quick_mode 快速模式开关，针对单行文字图片（要求图片只包含一行文字，且文字区域占比超过50%），打开时可以更快返回识别内容。可选值包括:
	 * true：打开快速模式；
	 * false：关闭快速模式。
	 * 未传入该参数时默认为false，即关闭快速模式。
	 * @return
	 * @throws IOException
	 */
	public String generalText(String image,String url,Boolean detect_direction,Boolean quick_mode) throws IOException {
		Map<String,String> map = new HashMap<>(3);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		if(!StringUtil.isEmpty(detect_direction)){
			map.put("detect_direction",detect_direction.toString());
		}
		if(!StringUtil.isEmpty(quick_mode)){
			map.put("quick_mode",quick_mode.toString());
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(GENERAL_TEXT_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 通用表格识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。图片最小边不小于15像素，最长边不超过4096像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @param return_confidence 是否返回置信度的开关，可选值包括：
	 *
	 * true：返回置信度
	 * false：不返回置信度
	 * 如果无该参数，系统默认不返回置信度。如果输入参数不是Boolean类型，则会报非法参数错误。
	 * @return
	 * @throws IOException
	 */
	public String generalTable(String image,String url,Boolean return_confidence) throws IOException {
		Map<String,String> map = new HashMap<>(2);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		if(!StringUtil.isEmpty(return_confidence)){
			map.put("return_confidence",return_confidence.toString());
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(TABLE_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	public String webImage(String image, String url, Boolean detect_direction,List<String> extract_type) throws IOException {
		Map<String,Object> map = new HashMap<>(4);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		if(!StringUtil.isEmpty(detect_direction)){
			map.put("detect_direction",detect_direction.toString());
		}
		if(!StringUtil.isEmpty(extract_type)){
			map.put("extract_type",extract_type);
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(WEB_IMAGE_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 智能分类识别
	 * 检测定位图片上指定要识别的票证（票据、证件或其他文字载体），并返回识别的结构化结果。
	 * 接口以列表形式返回图片上要识别票证的位置坐标、结构化识别的内容以及对应的类别。
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。
	 * 图片最小边不小于15像素，最长边不超过8000像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @param type_list 增值税发票 vat_invoice
	 * 出租车票 taxi_invoice
	 * 飞机行程单 flight_itinerary
	 * 机动车销售统一发票 mvs_invoice
	 * 身份证头像面 id_card_portrait_side
	 * 驾驶证主页 driver_license_front
	 * 行驶证主页 vehicle_license_front
	 * 道路运输证 transportation_license
	 * 定额发票 quota_invoice
	 * 火车票 train_ticket
	 * 车辆通行费发票 toll_invoice
	 * 护照 passport
	 * 身份证国徽面 id_card_emblem_side
	 * 驾驶证副页 driver_license_back
	 * 行驶证副页 vehicle_license_back
	 * 银行卡 bankcard
	 * @return
	 * @throws IOException
	 */
	public String invoice(String image, String url,List<String> type_list) throws IOException {
		Map<String,Object> map = new HashMap<>(2);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		if(!type_list.isEmpty()){
			map.put("type_list",type_list);
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(AUTO_CLASSIFICATION_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 手写文字识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。图片最小边不小于8像素，最长边不超过4096像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @param quick_mode 快速模式开关，针对单行文字图片（要求图片只包含一行文字，且文字区域占比超过50%），打开时可以更快返回识别内容。可选值包括：
	 * true：打开快速模式；
	 * false：关闭快速模式。
	 * 未传入该参数时默认为false，即关闭快速模式。
	 * @param char_set 字符集设置，用户可以根据实际需要限定输出字符集范围。可选值包括：
	 * "digit"：数字模式；
	 * "letter"：大小写字母模式；
	 * "digit_letter"：数字+字母模式；
	 * "general"：数字+字母+中文模式；
	 * 未传入该参数时，默认为“general”模式。
	 * @param detect_direction 为Boolean类型，若不传该字段，默认不检测图像倾斜角度文字方向，为True时，支持任意角度的旋转倾斜（建议在场景内有大量倾斜图片时才开启以减少性能损失）。
	 * @param extract_type 结构化数据提取参数列表，目前只支持数学试卷结构化提取，其入参值为“math_info”，若该字段为空或缺省该字段，默认不提取。
	 * @return
	 * @throws IOException
	 */
	public String handWriting(String image, String url,Boolean quick_mode,String char_set,String detect_direction,String extract_type) throws IOException {
		Map<String,Object> map = new HashMap<>(2);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		if(!StringUtil.isEmpty(quick_mode)){
			map.put("quick_mode",quick_mode);
		}
		if(!StringUtil.isEmpty(char_set)){
			map.put("char_set",char_set);
		}
		if(!StringUtil.isEmpty(detect_direction)){
			map.put("detect_direction",detect_direction);
		}
		if(!StringUtil.isEmpty(extract_type)){
			map.put("extract_type",extract_type);
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(HAND_WRITING_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 身份证识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。图片最小边不小于15像素，最长边不超过8000像素。支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @param side front：身份证人像面
	 * back：身份证国徽面
	 * 如果参数值为空或无该参数，系统自动识别，建议填写，准确率更高。
	 * @return
	 * @throws IOException
	 */
	public String idCard(String image,String url,String side) throws IOException {
		Map<String,String> map = new HashMap<>(2);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		if(!StringUtil.isEmpty(side)){
			map.put("side",side);
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(ID_CARD_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 行驶证识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。图片最小边不小于100像素，最长边不超过8000像素。支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @param side front: 行驶证主页
	 * back: 行驶证副页
	 * 如果参数值为空或无该参数，系统默认识别主页，建议填写，准确率更高。
	 * @return
	 * @throws IOException
	 */
	public String vehicleLicense(String image,String url,String side) throws IOException {
		Map<String,String> map = new HashMap<>(2);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		if(!StringUtil.isEmpty(side)){
			map.put("side",side);
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(VEHICLE_LICENSE_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 驾驶证识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。图片最小边不小于100像素，最长边不超过8000像素。支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @param side front: 驾驶证主页
	 * back: 驾驶证副页
	 * 如果参数值为空或无该参数，系统默认识别主页，建议填写，准确率更高。
	 * @return
	 * @throws IOException
	 */
	public String driverLicense(String image,String url,String side) throws IOException {
		Map<String,String> map = new HashMap<>(2);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		if(!StringUtil.isEmpty(side)){
			map.put("side",side);
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(DRIVER_LICENSE_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 功能介绍
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。
	 * 图片最小边不小于15像素，最长边不超过4096像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @param country_code 输入值为护照颁发国的国家码，根据国家码选择对应的护照识别服务。
	 * 若输入中未选此字段，服务会根据自己识别判断的护照类型匹配相应的护照识别服务。
	 * 若选择值为GENERAL，则选择护照机器码识别。
	 * 若选择值为CHN，则选择中国护照全字段识别。
	 * @return
	 * @throws IOException
	 */
	public String passport(String image,String url,String country_code) throws IOException {
		Map<String,String> map = new HashMap<>(2);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		if(!StringUtil.isEmpty(country_code)){
			map.put("country_code",country_code);
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(PASSPORT_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 银行卡识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。图片最小边不小于15像素，最长边不超过4096像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @return
	 * @throws IOException
	 */
	public String bankcard(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(BANKCARD_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 营业执照识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。
	 * 图片最小边不小于15像素，最长边不超过8192像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @return
	 * @throws IOException
	 */
	public String businessLicense(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(BUSINESS_LICENSE_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 道路运输证识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。
	 * 图片最小边不小于15像素，最长边不超过4096像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @return
	 * @throws IOException
	 */
	public String transportationLicense(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(TRANSPORTATION_LICENSE_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 车牌识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。图片最小边不小于15像素，最长边不超过4096像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @return
	 * @throws IOException
	 */
	public String licensePlate(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(LICENSE_PLATE_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 增值税发票识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。图片最小边不小于100像素，最长边不超过8192像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @return
	 * @throws IOException
	 */
	public String vatInvoice(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(VAT_INVOICE_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 机动车销售发票识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。图片最小边不小于100像素，最长边不超过8000像素。支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @return
	 * @throws IOException
	 */
	public String mvsInvoice(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(MVS_INVOICE_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 出租车发票识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。
	 * 图片最小边不小于15像素，最长边不超过4096像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @return
	 * @throws IOException
	 */
	public String taxiInvoice(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(TAXI_INVOICE_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 火车票识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。
	 * 图片最小边不小于15像素，最长边不超过4096像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @return
	 * @throws IOException
	 */
	public String trainTicket(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(TRAIN_TICKET_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 定额发票识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。
	 * 图片最小边不小于15像素，最长边不超过4096像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @return
	 * @throws IOException
	 */
	public String quotaInvoice(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(QUOTA_INVOICE_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 车辆通行费发票识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。
	 * 图片最小边不小于15像素，最长边不超过4096像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @return
	 * @throws IOException
	 */
	public String tollInvoice(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(TOLL_INVOICE_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 飞机行程单识别
	 * @param image 图像数据，base64编码，要求base64编码后大小不超过10MB。
	 * 图片最小边不小于15像素，最长边不超过4096像素，支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @return
	 * @throws IOException
	 */
	public String flightItinerary(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(FLIGHT_ITINERARY_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

	/**
	 * 英文海关单据识别
	 * @param image 英文海关单据图片文件，经过Base64转换后的字符串。要求base64编码后大小不超过10MB，图片尺寸不小于1000*1200像素。支持JPEG/JPG/PNG/BMP/TIFF格式。
	 * @param url 图片的URL路径，目前仅支持华为云上OBS提供的匿名公开授权访问的URL以及公网URL。
	 * @return
	 * @throws IOException
	 */
	public String ocrForm(String image,String url) throws IOException {
		Map<String,String> map = new HashMap<>(1);
		if(!StringUtil.isEmpty(image)){
			map.put("image",image);
		}else if(!StringUtil.isEmpty(url)){
			map.put("url",url);
		}else {
			throw new NullPointerException("image 或 url不能为空");
		}
		Map<String,String> header = new HashMap<>(1);
		header.put("X-Auth-Token",huaweiBaseData.getToken());
		ResponseData responseData = HttpUtil.postJsonRequest(OCR_FORM_URL,header,JsonUtil.toJsonString(map));
		return responseData.getResponseBody();
	}

}
