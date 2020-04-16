package com.lamandys.project.ui

import com.alibaba.android.arouter.facade.annotation.Route
import com.lamandys.basic.base.BaseFragment
import com.lamandys.router.R
import com.lamandys.router.RouterPath

/**
 * Created by lamandys on 2020/3/10 6:30 PM.
 */
@Route(path = RouterPath.Project.Project_Fragment)
class ProjectFragment : BaseFragment<ProjectViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.project_main
    }

    override fun initDataAfterView() {
    }

    override fun initView() {
    }

}