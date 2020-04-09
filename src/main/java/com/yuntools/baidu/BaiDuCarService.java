package com.yuntools.baidu;

import com.yuntools.util.HttpUtil;
import com.yuntools.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 汽车场景文字识别
 */
public class BaiDuCarService extends BaiDuBase{


	/**
	 * 构建service类必传的参数
	 *
	 * @param baiDuBaseData
	 */
	public BaiDuCarService(BaiDuBaseData baiDuBaseData) {
		super(baiDuBaseData);
	}

	/**
	 * 行驶证识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param detect_direction - false：默认值不进行图像方向自动矫正
	 * - true: 开启图像方向自动矫正功能，可对旋转 90/180/270 度的图片进行自动矫正并识别
	 * @param vehicle_license_side - front：默认值，识别行驶证主页
	 * - back：识别行驶证副页
	 * @param unified - false：默认值，不进行归一化处理
	 * - true：对输出字段进行归一化处理，将新/老版行驶证的“注册登记日期/注册日期”统一为”注册日期“进行输出
	 * @return
	 */
	public String vehicleLicense(String image,Boolean detect_direction,String vehicle_license_side,Boolean unified){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(4);
		map.put("image",image);
		if(!StringUtil.isEmpty(detect_direction)){
			map.put("detect_direction",detect_direction.toString());
		}
		if(!StringUtil.isEmpty(vehicle_license_side)){
			map.put("vehicle_license_side",vehicle_license_side);
		}
		if(!StringUtil.isEmpty(unified)){
			map.put("unified",unified.toString());
		}
		String result = HttpUtil.postRequest(VEHICLE_LICENSE_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 驾驶证识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:- true：检测朝向；- false：不检测朝向。
	 * @param unified_valid_period true: 归一化格式输出；false 或无此参数按非归一化格式输出
	 * @return
	 */
	public String drivingLicense(String image,Boolean detect_direction,Boolean unified_valid_period){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(3);
		map.put("image",image);
		if(!StringUtil.isEmpty(detect_direction)){
			map.put("detect_direction",detect_direction.toString());
		}
		if(!StringUtil.isEmpty(unified_valid_period)){
			map.put("unified_valid_period",unified_valid_period.toString());
		}
		String result = HttpUtil.postRequest(DRIVING_LICENSE_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 车牌识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param multi_detect 是否检测多张车牌，默认为false，当置为true的时候可以对一张图片内的多张车牌进行识别
	 * @return
	 */
	public String licensePlate(String image,Boolean multi_detect){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(2);
		map.put("image",image);
		if(!StringUtil.isEmpty(multi_detect)){
			map.put("multi_detect",multi_detect.toString());
		}
		String result = HttpUtil.postRequest(LICENSE_PLATE_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * VIN码识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String vinCode(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(VIN_CODE_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 机动车销售发票识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String vehicleInvoice(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(VEHICLE_INVOICE_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 车辆合格证识别
	 * @param image 	图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String vehicleCertificate(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(VEHICLE_CERTIFICATE_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

}
