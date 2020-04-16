package com.lamandys.basic.ext

import com.lamandys.basic.http.ApiResult

/**
 * Created by lamandys on 2020/3/7 3:32 PM.
 */
fun <T> ApiResult<T>.execResult(success: T.() -> Unit, failed: ApiResult<T>.() -> Unit) {
    when (isSuccessful()) {
        true -> success.invoke(data!!)
        else -> failed.invoke(this)
    }
}