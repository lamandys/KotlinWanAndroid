package com.lamandys.home.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.lamandys.basic.ext.dp2px
import com.lamandys.basic.ext.dp2px_f
import com.lamandys.basic.ext.resIdToColor
import com.lamandys.basic.logger.log
import com.lamandys.basic.statusbar.StatusBarUtil
import com.lamandys.home.model.BannerModel
import com.lamandys.home.type.BannerType
import com.lamandys.router.R
import com.youth.banner.Banner
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.listener.OnBannerListener
import com.youth.banner.listener.OnPageChangeListener

/**
 * Created by lamandys on 2020/3/7 5:14 PM.
 */
class BannerViewAdapter : ItemViewBinder<BannerType, BannerViewAdapter.BannerViewHolder>() {

    override fun onBindViewHolder(holder: BannerViewHolder, item: BannerType) {
        holder.banner.apply {
            adapter = BannerImageAdapter(item.bannerList)
            indicator = CircleIndicator(holder.itemView.context)
            setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            indicatorConfig.apply {
                normalColor = R.color.textNormalColor.resIdToColor()
                selectedColor = R.color.colorPrimary.resIdToColor()
                selectedWidth = normalWidth
            }
            isAutoLoop(true)
            setDelayTime(5000L)
        }
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): BannerViewHolder {
        val banner = Banner<BannerModel, BannerImageAdapter>(parent.context)
        var baseHeight = 150f.dp2px()
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            baseHeight += StatusBarUtil.getStatusBarHeight(parent.context)
        }
        val lp = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, baseHeight)
        lp.bottomMargin = 10f.dp2px()
        banner.layoutParams = lp
        ViewCompat.setElevation(banner, 5f.dp2px_f())
        return BannerViewHolder(banner)
    }

    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @Suppress("UNCHECKED_CAST")
        val banner: Banner<BannerModel, BannerImageAdapter> =
            itemView as Banner<BannerModel, BannerImageAdapter>
    }

    override fun onViewAttachedToWindow(holder: BannerViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.banner.start()
    }

    override fun onViewDetachedFromWindow(holder: BannerViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.banner.stop()
    }
}