package com.lamandys.router

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter
import com.lamandys.router.empty.NotFoundRouterFragment

/**
 * Created by lamandys on 2020/3/4 4:53 PM.
 */
fun <T> navigateToModuleService(servicePath: String): T? {
    @Suppress("UNCHECKED_CAST")
    return ARouter.getInstance().build(servicePath).navigation() as? T?
}

fun getFragment(path: String, withExtAction: Postcard.() -> Unit = {}): Fragment {
    return ARouter.getInstance().build(path).apply {
        withExtAction.invoke(this)
    }.navigation() as? Fragment? ?: NotFoundRouterFragment.newInstance(path)
}