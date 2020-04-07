package com.yuntools.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * baidu orc接口返回值封装
 * @author mantou
 */
public class GeneralResult {
	/**
	 * 唯一的log id，用于问题定位
	 */
	private String log_id;
	/**
	 * 图像方向，当detect_direction=true时存在。
	 * - -1:未定义，
	 * - 0:正向，
	 * - 1: 逆时针90度，
	 * - 2:逆时针180度，
	 * - 3:逆时针270度
	 */
	private int direction;
	/**
	 * 识别结果数，表示words_result的元素个数
	 */
	private int words_result_num;
	/**
	 * 识别结果数组
	 */
	private List<WordsResult> words_result;

	/**
	 * 识别结果中每一行的置信度值，包含average：行置信度平均值，variance：行置信度方差，min：行置信度最小值
	 */
	private Float probability;

	public String getLog_id() {
		return log_id;
	}

	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getWords_result_num() {
		return words_result_num;
	}

	public void setWords_result_num(int words_result_num) {
		this.words_result_num = words_result_num;
	}

	public List<WordsResult> getWords_result() {
		return words_result;
	}

	public void setWords_result(List<WordsResult> words_result) {
		this.words_result = words_result;
	}

	public static class WordsResult{
		/**
		 * 位置数组（坐标0点为左上角）
		 */
		private Location location;

		/**
		 * 识别结果字符串
		 */
		private String words;

		private List<LocationChar> chars;

		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}

		public String getWords() {
			return words;
		}

		public void setWords(String words) {
			this.words = words;
		}

		public List<LocationChar> getChars() {
			return chars;
		}

		public void setChars(List<LocationChar> chars) {
			this.chars = chars;
		}

		public static class Location{
			/**
			 * 表示定位位置的长方形左上顶点的水平坐标
			 */
			private int left;

			/**
			 * 表示定位位置的长方形左上顶点的垂直坐标
			 */
			private int top;

			/**
			 * 表示定位位置的长方形的宽度
			 */
			private int width;

			/**
			 * 表示定位位置的长方形的高度
			 */
			private int height;

			public int getLeft() {
				return left;
			}

			public void setLeft(int left) {
				this.left = left;
			}

			public int getTop() {
				return top;
			}

			public void setTop(int top) {
				this.top = top;
			}

			public int getWidth() {
				return width;
			}

			public void setWidth(int width) {
				this.width = width;
			}

			public int getHeight() {
				return height;
			}

			public void setHeight(int height) {
				this.height = height;
			}
		}

		public static class LocationChar{
			private Location location;

			/**
			 * 单字符识别结果
			 */
			@SerializedName("char")
			private String charss;

			public Location getLocation() {
				return location;
			}

			public void setLocation(Location location) {
				this.location = location;
			}

			public String getCharss() {
				return charss;
			}

			public void setCharss(String charss) {
				this.charss = charss;
			}
		}
	}

}
