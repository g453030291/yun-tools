package com.yuntools.baidu;

import com.yuntools.util.HttpUtil;
import com.yuntools.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 教育场景文字识别
 * @author mantou
 */
public class BaiDuEduService extends BaiDuBase{

	/**
	 * 构建service类必传的参数
	 *
	 * @param baiDuBaseData
	 */
	public BaiDuEduService(BaiDuBaseData baiDuBaseData) {
		super(baiDuBaseData);
	}

	/**
	 * 手写文字识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
	 * @param recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
	 * @param words_type words_type=number:手写数字识别；无此参数或传其它值 默认手写通用识别（目前支持汉字和英文）
	 * @param probability 是否返回识别结果中每一行的置信度，默认为false，不返回置信度
	 * @return
	 */
	public String handwriting(String image,String recognize_granularity,String words_type,Boolean probability){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(4);
		map.put("image",image);
		if(!StringUtil.isEmpty(recognize_granularity)){
			map.put("recognize_granularity",recognize_granularity);
		}
		if(!StringUtil.isEmpty(words_type)){
			map.put("words_type",words_type);
		}
		if(!StringUtil.isEmpty(probability)){
			map.put("probability",probability.toString());
		}
		String result = HttpUtil.postRequest(HANDWRITING_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

	/**
	 * 公式识别
	 * @param image 图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式，当image字段存在时url字段失效
	 * @param recognize_granularity 是否定位单字符位置，big：不定位单字符位置；small：定位单字符位置。默认值为big
	 * @param detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:
	 * - true：检测朝向；
	 * - false：不检测朝向。
	 * @param disp_formula 是否分离输出公式识别结果，在words_result外单独输出公式结果，展示在“formula_result”中
	 * @return
	 */
	public String formula(String image,String recognize_granularity,Boolean detect_direction,Boolean disp_formula){
		if(StringUtil.isEmpty(image)){
			throw new NullPointerException("图片参数不能为空");
		}
		Map<String,String> map = new HashMap<>(4);
		map.put("image",image);
		if(!StringUtil.isEmpty(recognize_granularity)){
			map.put("recognize_granularity",recognize_granularity);
		}
		if(!StringUtil.isEmpty(detect_direction)){
			map.put("detect_direction",detect_direction.toString());
		}
		if(!StringUtil.isEmpty(disp_formula)){
			map.put("disp_formula",disp_formula.toString());
		}
		String result = HttpUtil.postRequest(FORMULA_URL+"?access_token=" + baiDuBaseData.getAccessToken(),map);
		return result;
	}

}
