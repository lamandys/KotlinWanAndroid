package com.lamandys.router.empty

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.lamandys.router.R
import com.lamandys.basic.base.BaseFragment
import kotlinx.android.synthetic.main.router_fragment_none.*

/**
 * Created by lamandys on 2020/3/4 5:23 PM.
 */
class NotFoundRouterFragment : BaseFragment<ViewModel>() {

    companion object {
        private const val BUILD_PATH = "buildPath"

        fun newInstance(buildPath: String): NotFoundRouterFragment{
            val fragment = NotFoundRouterFragment()
            fragment.arguments = Bundle().apply { putString(BUILD_PATH, buildPath) }
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.router_fragment_none
    }

    override fun initDataAfterView() {
    }

    override fun initView() {
        val buildPath = arguments?.getString(BUILD_PATH)
        _tv_build_path.text = "\"$buildPath\" was not found."
    }
}