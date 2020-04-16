package com.lamandys.basic.ext

import com.lamandys.basic.base.BaseApplication

/**
 * 包含常用的尺寸转换
 * Created by Jaminchanks on 2018-03-14.
 */
/**
 * 像素尺寸转换工具类
 * Created by chenmingzhen on 16-5-31.
 */
/**
 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
 */
fun Float.dp2px(): Int {
    val scale = BaseApplication.instance.resources.displayMetrics.density
    return (this * scale + 0.5f).toInt()
}

fun Float.dp2px_f(): Float {
    val scale = BaseApplication.instance.resources.displayMetrics.density
    return (this * scale + 0.5f)
}

/**
 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
 */
fun Float.px2dp(): Int {
    val scale = BaseApplication.instance.resources.displayMetrics.density
    return (this / scale + 0.5f).toInt()
}

fun Float.px2dp_f(): Float {
    val scale = BaseApplication.instance.resources.displayMetrics.density
    return (this / scale + 0.5f)
}

/**
 * 将px值转换为sp值，保证文字大小不变
 * @return
 */
fun Float.px2sp(): Int {
    val fontScale = BaseApplication.instance.resources.displayMetrics.scaledDensity
    return (this / fontScale + 0.5f).toInt()
}

/**
 * 将sp值转换为px值，保证文字大小不变
 * @return
 */
fun Float.sp2px(): Int {
    val fontScale = BaseApplication.instance.resources.displayMetrics.scaledDensity
    return (this * fontScale + 0.5f).toInt()
}

fun Float.sp2px_f(): Float {
    val fontScale = BaseApplication.instance.resources.displayMetrics.scaledDensity
    return (this * fontScale + 0.5f)
}