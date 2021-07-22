package com.example.demo.common;

import java.text.NumberFormat;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-06-24 17:51
 */
public class PercentUtil {

    /**
     * 算百分比
     *
     * @param num      除数
     * @param totalNum 总数
     * @param digit    百分比小数位数
     * @return 百分比
     */
    public static String getPercent(float num, float totalNum, int digit) {
        // 创建一个数值格式化对象 设置精确到小数点后digit位
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(digit);
        return numberFormat.format(num / totalNum * 100) + "%";
    }
}
