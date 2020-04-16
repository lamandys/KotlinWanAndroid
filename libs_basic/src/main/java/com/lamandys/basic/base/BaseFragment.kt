package com.lamandys.basic.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

/**
 * Created by lamandys on 2020/3/4 5:39 PM.
 */
abstract class BaseFragment<T : ViewModel> : Fragment() {

    val mViewModel: T by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        @Suppress("UNCHECKED_CAST")
        val clazz =
            (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>
        ViewModelProvider.AndroidViewModelFactory.getInstance(activity!!.application)
            .create(clazz.kotlin.java)
    }

    var mRootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRootView = inflater.inflate(getLayoutId(), container, false)
        return mRootView
    }

    abstract fun getLayoutId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initDataAfterView()
    }

    abstract fun initDataAfterView()

    abstract fun initView()

}