package com.lamandys.wan.core

import com.alibaba.android.arouter.launcher.ARouter
import com.lamandys.basic.base.BaseApplication
import com.lamandys.basic.factory.initHttp
import com.lamandys.basic.logger.initLogger
import com.lamandys.copywanandroid.BuildConfig

/**
 * Created by lamandys on 2020/3/3 3:26 PM.
 */
class WanApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        initLogger(BuildConfig.DEBUG)
        initHttp()

        ARouter.openDebug()
        ARouter.openLog()

        ARouter.init(this)
    }
}