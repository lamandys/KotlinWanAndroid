package com.lamandys.home.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.lamandys.basic.ext.dp2px_f
import com.lamandys.basic.glide.GlideApp
import com.lamandys.home.model.BannerModel
import com.youth.banner.adapter.BannerAdapter

/**
 * Created by lamandys on 2020/3/7 4:47 PM.
 */
class BannerImageAdapter(datas: List<BannerModel>) :
    BannerAdapter<BannerModel, BannerImageAdapter.BannerViewHolder>(datas) {


    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val imageView = ImageView(parent.context)
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        ViewCompat.setElevation(imageView, 5f.dp2px_f())
        return BannerViewHolder(imageView)
    }

    override fun onBindView(holder: BannerViewHolder, data: BannerModel, position: Int, size: Int) {
        GlideApp.with(holder.imageView).load(data.imagePath).into(holder.imageView)
    }

    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView as ImageView
    }
}