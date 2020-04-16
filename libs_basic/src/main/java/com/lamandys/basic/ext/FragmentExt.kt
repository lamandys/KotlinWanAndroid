package com.lamandys.basic.ext

import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.lamandys.basic.base.BaseFragment
import org.jetbrains.annotations.NotNull

/**
 * Created by lamandys on 2020/3/4 6:19 PM.
 */
fun Fragment.displayFragment(
    @IdRes container: Int, @NotNull fragment: Fragment,
    @NonNull currentFragment: Fragment? = null
) {
    val transaction = childFragmentManager.beginTransaction()
    val findFragment = childFragmentManager.findFragmentByTag(fragment::class.java.simpleName)
    if (findFragment == null) {
        if (currentFragment == null) {
            transaction.add(container, fragment, fragment::class.java.simpleName)
                .commit()
        } else {
            transaction.add(container, fragment, fragment::class.java.simpleName)
                .hide(currentFragment).commit()
        }
    } else {
        if (currentFragment != null) {
            transaction.hide(currentFragment).show(fragment).commit()
        } else {
            transaction.show(fragment).commit()
        }
    }
}

fun <T> Fragment.execObserver(liveData: LiveData<T>, observe: T.() -> Unit) {
    liveData.observe(viewLifecycleOwner, Observer {
        observe.invoke(it)
    })
}