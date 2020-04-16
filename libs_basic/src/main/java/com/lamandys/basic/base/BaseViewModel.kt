package com.lamandys.basic.base

import androidx.lifecycle.ViewModel
import com.lamandys.basic.http.BaseRepository
import java.lang.reflect.ParameterizedType

/**
 * Created by lamandys on 2020/3/7 3:03 PM.
 */
abstract class BaseViewModel<T : BaseRepository> : ViewModel() {

    var api: T

    init {
        @Suppress("UNCHECKED_CAST")
        val clazz = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>
        api = clazz.newInstance()
    }
}