package com.lamandys.basic.http

/**
 * Created by lamandys on 2020/3/6 5:45 PM.
 */
class ApiResult<T> {

    var errorCode = 0
    var errorMsg = ""

    var data: T? = null

    fun isSuccessful(): Boolean {
        return errorCode == 0 && errorMsg.isBlank() && data != null
    }

    override fun toString(): String {
        return """
            ApiResult{
                data: ${if (data == null) "null" else data.toString()},
                errorCode: $errorCode ,
                errorMsg : $errorMsg
            }
        """.trimIndent()
    }
}