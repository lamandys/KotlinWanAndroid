package com.lamandys.basic.ext

import androidx.core.content.ContextCompat
import com.lamandys.basic.base.BaseApplication

/**
 * Created by lamandys on 2020/3/9 10:45 AM.
 */

fun Int.resIdToColor() = ContextCompat.getColor(BaseApplication.instance, this)