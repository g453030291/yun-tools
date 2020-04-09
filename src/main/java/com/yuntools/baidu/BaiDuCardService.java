package com.yuntools.baidu;

import com.yuntools.entity.IdCard;
import com.yuntools.util.HttpUtil;
import com.yuntools.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡证文字识别
 * @author mantou
 */
public class BaiDuCardService extends BaiDuBase{

	/**
	 * 构建service类必传的参数
	 *
	 * @param baiDuBaseData
	 */
	public BaiDuCardService(BaiDuBaseData baiDuBaseData) {
		super(baiDuBaseData);
	}

	/**
	 * 身份证识别
	 * @param idCard
	 * @return
	 */
	public String idCard(IdCard idCard){
		if(idCard == null
				|| StringUtil.isEmpty(idCard.getImage())
				||StringUtil.isEmpty(idCard.getId_card_side()) ){
			throw new NullPointerException("必传参数不能为空");
		}
		Map<String,String> map = new HashMap<>(6);
		map.put("image",idCard.getImage());
		map.put("id_card_side",idCard.getId_card_side());
		if(!StringUtil.isEmpty(idCard.getDetect_direction())){
			map.put("detect_direction",idCard.getDetect_direction().toString());
		}
		if(!StringUtil.isEmpty(idCard.getDetect_direction())){
			map.put("detect_risk",idCard.getDetect_risk().toString());
		}
		if(!StringUtil.isEmpty(idCard.getDetect_direction())){
			map.put("detect_photo",idCard.getDetect_photo().toString());
		}
		if(!StringUtil.isEmpty(idCard.getDetect_direction())){
			map.put("detect_rectify",idCard.getDetect_rectify().toString());
		}
		String result = HttpUtil.postRequest(ID_CARD_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 银行卡识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param detect_direction 是否检测图像朝向，默认检测，即：true。可选值包括true - 检测朝向；false - 不检测朝向。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。
	 * @return
	 */
	public String bankCard(String image,String detect_direction){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(2);
		map.put("image",image);
		if(!StringUtil.isEmpty(detect_direction)){
			map.put("detect_direction",detect_direction);
		}
		String result = HttpUtil.postRequest(BANK_CARD_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 营业执照识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param detect_direction 可选值 true,false是否检测图像朝向，默认不检测，即：false。可选值包括true - 检测朝向；false - 不检测朝向。朝向是指输入图像是正常方向、逆时针旋转90/180/270度
	 * @param accuracy 可选值：normal,high参数选normal或为空使用快速服务；选择high使用高精度服务，但是时延会根据具体图片有相应的增加
	 * @return
	 */
	public String businessLicense(String image,Boolean detect_direction,String accuracy){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(3);
		map.put("image",image);
		if(!StringUtil.isEmpty(detect_direction)){
			map.put("detect_direction",detect_direction.toString());
		}
		if(!StringUtil.isEmpty(accuracy)){
			map.put("accuracy",accuracy);
		}
		String result = HttpUtil.postRequest(BUSINESS_LICENSE_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 名片识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String businessCard(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(BUSINESS_CARD_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 护照识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String passport(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(PASSPORT_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 港澳通行证识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String hkMacauExitentrypermit(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(HK_MACAU_EXITENTRYPERMIT_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 台湾通行证识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String taiwanExitentrypermit(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(TAIWAN_EXITENTRYPERMIT_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 户口本识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String householdRegister(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(HOUSEHOLE_REGISTER_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 出生医学证明识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @return
	 */
	public String birthCertificate(String image){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(1);
		map.put("image",image);
		String result = HttpUtil.postRequest(BIRTH_CERTIFICATE_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

}
