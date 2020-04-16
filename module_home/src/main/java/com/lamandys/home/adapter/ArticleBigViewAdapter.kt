package com.lamandys.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.lamandys.basic.glide.GlideApp
import com.lamandys.home.model.ArticleModel
import com.lamandys.router.R

/**
 * Created by lamandys on 2020/3/9 4:26 PM.
 */
class ArticleBigViewAdapter :
    ItemViewBinder<ArticleModel.Data, ArticleBigViewAdapter.ArticleHolderView>() {


    class ArticleHolderView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val author = itemView.findViewById<TextView>(R.id.home_item_author)
        val time = itemView.findViewById<TextView>(R.id.home_item_time)
        val title = itemView.findViewById<TextView>(R.id.home_item_title)
        val chapter = itemView.findViewById<TextView>(R.id.home_item_chapter)
        val tagList = itemView.findViewById<LinearLayout>(R.id.home_item_tag_container)
        val desc = itemView.findViewById<TextView>(R.id.home_item_desc)
        val imageView = itemView.findViewById<ImageView>(R.id.home_item_image)
    }

    override fun onBindViewHolder(holder: ArticleHolderView, item: ArticleModel.Data) {
        holder.author.text = if (item.author.isNullOrBlank()) item.shareUser else item.author
        holder.time.text = item.niceDate
        holder.chapter.text = item.chapterName
        holder.title.text = item.title
        holder.desc.text = item.desc
        GlideApp.with(holder.itemView).load(item.envelopePic).into(holder.imageView)
    }

    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ArticleHolderView {
        val view = inflater.inflate(R.layout.home_recyclerview_item_big, parent, false)
        return ArticleHolderView(view)
    }
}