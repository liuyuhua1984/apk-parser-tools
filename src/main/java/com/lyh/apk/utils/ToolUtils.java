package com.lyh.apk.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 工具类
 * 
 * @author lyh1984
 */
public class ToolUtils {
	
	/**
	 * 分隔字符串
	 * 
	 * @param srcStr
	 * @param separate "分隔符"
	 * @return
	 */
	public static String[] split(String srcStr, String separate) {
		List<String> list = new ArrayList<String>();
		if (srcStr != null) {
			int i = 0;
			int j = 0;
			while ((i = srcStr.indexOf(separate, i)) != -1) {
				list.add(srcStr.substring(j, i));
				j = i + separate.length();
				i = j;
			}
			
			list.add(srcStr.substring(j, srcStr.length()));
		}
		
		String str[] = new String[list.size()];
		for (int i = 0; i < str.length; i++) {
			str[i] = list.get(i);
		}
		return str;
	}

	/**
	 * 分割字符串
	 * @param srcStr
	 * @param split_point
	 * @param split_star
	 * @return
	 */
	public static String[][] splitStrToString(String srcStr, String split_point, String split_star) {
		String[][] tmp = null;
		String str[] = ToolUtils.split(srcStr, split_point);
		if (str != null) {
			tmp = new String[str.length][];
			for (int i = 0; i < str.length; i++) {
				String tmp_1[] = ToolUtils.split(str[i], split_star);
				tmp[i] = new String[tmp_1.length];
				for (int j = 0; j < tmp_1.length; j++) {
					tmp[i][j] = tmp_1[j];
				}
			}
		}
		return tmp;
	}
	/**
	 * 解析配置表字符串,先按照 split_point 分解，在以 split_star 分解
	 * 
	 * @param srcStr
	 * @param split_point
	 * @param split_star
	 * @return
	 */
	public static int[][] splitStrInt(String srcStr, String split_point, String split_star) {
		int[][] tmp = null;
		String str[] = ToolUtils.split(srcStr, split_point);
		if (str != null) {
			tmp = new int[str.length][];
			for (int i = 0; i < str.length; i++) {
				String tmp_1[] = ToolUtils.split(str[i], split_star);
				tmp[i] = new int[tmp_1.length];
				for (int j = 0; j < tmp_1.length; j++) {
					tmp[i][j] = Integer.parseInt(tmp_1[j]);
				}
			}
		}
		return tmp;
	}
	
	/**
	 * 解析配置表字符串,先按照 split_point 分解，在以 split_star 分解
	 * 
	 * @param srcStr
	 * @param split_point
	 * @param split_star
	 * @return
	 */
	public static float[][] splitStrFloat(String srcStr, String split_point, String split_star) {
		float[][] tmp = null;
		String str[] = ToolUtils.split(srcStr, split_point);
		if (str != null) {
			tmp = new float[str.length][];
			for (int i = 0; i < str.length; i++) {
				String tmp_1[] = ToolUtils.split(str[i], split_star);
				tmp[i] = new float[tmp_1.length];
				for (int j = 0; j < tmp_1.length; j++) {
					tmp[i][j] = Float.parseFloat(tmp_1[j]);
				}
			}
		}
		return tmp;
	}


	/**
	 * 分隔字符串
	 * 
	 * @param srcStr
	 * @param separate "分隔符"
	 * @return
	 */
	public static int[] splitStringToInt(String srcStr, String separate) {
		List<String> list = new ArrayList<String>();
		if (srcStr != null) {
			int i = 0;
			int j = 0;
			while ((i = srcStr.indexOf(separate, i)) != -1) {
				list.add(srcStr.substring(j, i));
				j = i + separate.length();
				i = j;
			}
			
			list.add(srcStr.substring(j, srcStr.length()));
		}
		
		int str[] = new int[list.size()];
		for (int i = 0; i < str.length; i++) {
			str[i] = Integer.parseInt(list.get(i));
		}
		return str;
	}
	
	/**
	 * 分隔字符串
	 * 
	 * @param srcStr
	 * @param separate "分隔符"
	 * @return
	 */
	public static String[] splitStringToString(String srcStr, String separate) {
		List<String> list = new ArrayList<String>();
		if (srcStr != null) {
			int i = 0;
			int j = 0;
			while ((i = srcStr.indexOf(separate, i)) != -1) {
				list.add(srcStr.substring(j, i));
				j = i + separate.length();
				i = j;
			}
			list.add(srcStr.substring(j, srcStr.length()));
		}
		
		String str[] = new String[list.size()];
		for (int i = 0; i < str.length; i++) {
			str[i] = list.get(i);
		}
		return str;
	}
	
	/**
	 * 分隔字符串
	 * 
	 * @param srcStr
	 * @param separate "分隔符"
	 * @return
	 */
	public static short[] splitStringToShort(String srcStr, String separate) {
		List<String> list = new ArrayList<String>();
		if (srcStr != null) {
			int i = 0;
			int j = 0;
			while ((i = srcStr.indexOf(separate, i)) != -1) {
				list.add(srcStr.substring(j, i));
				j = i + separate.length();
				i = j;
			}
			
			list.add(srcStr.substring(j, srcStr.length()));
		}
		
		short str[] = new short[list.size()];
		for (int i = 0; i < str.length; i++) {
			str[i] = Short.parseShort(list.get(i));
		}
		return str;
	}
	
	/**
	 * 分隔字符串
	 * 
	 * @param srcStr
	 * @param separate "分隔符"
	 * @return
	 */
	public static byte[] splitStringToByte(String srcStr, String separate) {
		List<String> list = new ArrayList<String>();
		if (srcStr != null) {
			int i = 0;
			int j = 0;
			while ((i = srcStr.indexOf(separate, i)) != -1) {
				list.add(srcStr.substring(j, i));
				j = i + separate.length();
				i = j;
			}
			
			list.add(srcStr.substring(j, srcStr.length()));
		}
		
		byte str[] = new byte[list.size()];
		for (int i = 0; i < str.length; i++) {
			str[i] = Byte.parseByte(list.get(i));
		}
		return str;
	}
	
	/**
	 * 分隔字符串
	 * 
	 * @param srcStr
	 * @param separate "分隔符"
	 * @return
	 */
	public static long[] splitStringToLong(String srcStr, String separate) {
		List<String> list = new ArrayList<String>();
		if (srcStr != null) {
			int i = 0;
			int j = 0;
			while ((i = srcStr.indexOf(separate, i)) != -1) {
				list.add(srcStr.substring(j, i));
				j = i + separate.length();
				i = j;
			}
			
			list.add(srcStr.substring(j, srcStr.length()));
		}
		
		long str[] = new long[list.size()];
		for (int i = 0; i < str.length; i++) {
			str[i] = Long.parseLong(list.get(i));
		}
		return str;
	}

	/**
	 * splitStringToMap:(). <br/>
	 * TODO().<br/>
	 * 分隔字符串到map
	 *
	 * @author lyh
	 * @param srcString
	 * @param separatorOne
	 * @param mapSeparator
	 * @return
	 */
	public static Map<String, String> splitStringToMap(String srcStr, String separatorOne, String mapSeparator) {
		Map<String, String> map = new HashMap<String, String>();
		List<String> list = new ArrayList<String>();
		if (srcStr != null) {
			int i = 0;
			int j = 0;
			while ((i = srcStr.indexOf(separatorOne, i)) != -1) {
				list.add(srcStr.substring(j, i));
				j = i + separatorOne.length();
				i = j;
			}

			list.add(srcStr.substring(j, srcStr.length()));
		}
		for (String str : list) {
			int i = 0;
			if ((i = str.indexOf(mapSeparator, i)) != -1) {
				map.put(str.substring(0, i), str.substring(i + separatorOne.length(), str.length()));
			}
		}
		return map;
	}



	/**
	 * 判断 字符串是否没有值和空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isStringNull(String str) {
		if (str != null && !str.equals("")) {
			return false;
		}
		return true;
	}
	


	/**
	 * 大陆号码或香港号码均可
	 */
	public static boolean isPhoneLegal(String str) throws PatternSyntaxException {
		return isChinaPhoneLegal(str) || isHKPhoneLegal(str);
	}

	/**
	 * isNum:(). <br/>
	 * TODO().<br/>
	 * 判断是否是数据
	 *
	 * @author lyh
	 * @param num
	 * @return
	 */
	public static boolean isNum(String num) {
		String reg = "^[1-9]\\d*$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(num);
		return m.matches();
	}

	/**
	 * isNumAndLetter:(). <br/>
	 * TODO().<br/>
	 * 数字和字母
	 * @author lyh
	 * @param num
	 * @param len
	 * @return
	 */
	public static boolean isNumAndLetter(String num,int min,int max) {
		String reg = "^[0-9A-Za-z]+$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(num);
		return m.find();
	}

	/**
	 * isContainChinese:(). <br/>
	 * TODO().<br/>
	 * 中文
	 * @author lyh
	 * @param str
	 * @return
	 */
	public static boolean isContainChinese(String str) {

		Pattern pPattern = Pattern.compile("[\u4e00-\u9fa5]");
		if (pPattern != null) {
			Matcher m = pPattern.matcher(str);
			if (m.find()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数 此方法中前三位格式有： 13+任意数 15+除4的任意数 18+除1和4的任意数 17+除9的任意数 147
	 */
	public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
		String regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 * 香港手机号码8位数，5|6|8|9开头+7位任意数
	 */
	public static boolean isHKPhoneLegal(String str) throws PatternSyntaxException {
		String regExp = "^(5|6|8|9)\\d{7}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
}
