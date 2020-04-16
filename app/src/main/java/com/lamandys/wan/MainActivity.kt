package com.lamandys.wan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lamandys.basic.ext.displayFragment
import com.lamandys.basic.logger.log
import com.lamandys.copywanandroid.R
import com.lamandys.router.RouterPath
import com.lamandys.router.getFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { getFragment(RouterPath.Home.Home_Fragment) }
    private val projectFragment by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { getFragment(RouterPath.Project.Project_Fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_root_nav_group?.apply {
            setOnCheckedChangeListener { _, id ->
                when (id) {
                    R.id.main_root_nav_home -> {
                        displayFragment(R.id.main_root_container, homeFragment)
                    }
                    R.id.main_root_nav_project -> {
                        displayFragment(R.id.main_root_container, projectFragment)
                    }
                    R.id.main_root_nav_article -> log { "公众号" }
                    R.id.main_root_nav_system -> log { "体系" }
                    R.id.main_root_nav_mine -> log { "我的" }
                }
            }
            main_root_nav_home.isChecked = true
        }
    }
}
