package com.lamandys.basic.base

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import kotlin.properties.Delegates

/**
 * Created by lamandys on 2020/3/7 4:15 PM.
 */
open class BaseApplication : Application() {

    companion object {
        var instance: Application by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}