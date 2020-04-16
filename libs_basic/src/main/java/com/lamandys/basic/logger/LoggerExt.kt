package com.lamandys.basic.logger

import timber.log.Timber

fun initLogger(isDebug: Boolean = true) {
    if (isDebug) {
        Timber.plant(Timber.DebugTree())
    } else {
        Timber.plant(CrashReportingTree())
    }
}

fun log(content: () -> String) {
    logd(content)
}

fun logd(content: () -> String) = Timber.d(content())

fun logi(content: () -> String) = Timber.i(content())

fun loge(content: () -> String) = Timber.e(content())

fun logw(content: () -> String) = Timber.w(content())

fun logwtf(content: () -> String) = Timber.wtf(content())