package com.lamandys.basic.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by lamandys on 2020/3/6 10:19 AM.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        initData()
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun initData()
}