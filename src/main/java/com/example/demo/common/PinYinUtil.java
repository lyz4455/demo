package com.example.demo.common;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * @author biyukun
 * @description TODO
 * @date 2020-07-23
 */
public class PinYinUtil {

    /**
     * 获取汉字的首字母
     * @param hanzi 汉字
     * @return 首字母
     */
    public static String getHanziInitials(String hanzi) {
        String result = null;
        if (null != hanzi && !"".equals(hanzi)) {
            char[] charArray = hanzi.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (char ch : charArray) {
                String[] stringsArray = PinyinHelper.toHanyuPinyinStringArray(ch);
                if (null != stringsArray) {
                    sb.append(stringsArray[0].charAt(0));
                }
            }
            if (sb.length() > 0) {
                result = sb.toString().toUpperCase();
            }
        }
        return result;
    }

    /**
     * 转换成汉语拼音
     * @param hanzi 汉字
     * @return 拼音
     */
    public static String getHanziPinyin(String hanzi) {
        String result = null;
        if (null != hanzi && !"".equals(hanzi)) {
            char[] charArray = hanzi.toCharArray();
            StringBuffer sb  = new StringBuffer();
            for (char ch : charArray) {
                String[] stringArray = PinyinHelper.toHanyuPinyinStringArray(ch);
                if (null != stringArray) {
                    sb.append(stringArray[0].replaceAll("\\d", ""));
                }
            }
            if (sb.length() > 0) {
                result = sb.toString();
            }
        }
        return result;
    }
}
