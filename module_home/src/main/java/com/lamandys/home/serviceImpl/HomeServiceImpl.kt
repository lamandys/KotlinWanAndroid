package com.lamandys.home.serviceImpl

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.lamandys.basic.logger.log
import com.lamandys.router.RouterPath
import com.lamandys.router.home.IHomeService

/**
 * Created by lamandys on 2020/3/4 6:27 PM.
 */
@Route(path = RouterPath.Home.Home_Service)
class HomeServiceImpl : IHomeService {

    override fun init(context: Context?) {
        log { "HomeServiceImpl进行初始化" }
    }

}