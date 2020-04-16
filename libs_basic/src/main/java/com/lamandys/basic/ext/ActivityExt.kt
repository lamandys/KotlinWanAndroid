package com.lamandys.basic.ext

import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.jetbrains.annotations.NotNull

/**
 * Created by lamandys on 2020/3/4 6:21 PM.
 */
var mCurrentFragment: Fragment? = null

fun AppCompatActivity.displayFragment(
    @IdRes container: Int, @NotNull fragment: Fragment,
    @NonNull currentFragment: Fragment? = mCurrentFragment
) {
    val transaction = supportFragmentManager.beginTransaction()
    val findFragment = supportFragmentManager.findFragmentByTag(fragment::class.java.simpleName)
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
    mCurrentFragment = fragment
}