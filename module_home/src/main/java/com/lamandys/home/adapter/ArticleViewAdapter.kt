package com.lamandys.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.lamandys.home.model.ArticleModel
import com.lamandys.router.R

/**
 * Created by lamandys on 2020/3/9 4:26 PM.
 */
class ArticleViewAdapter :
    ItemViewBinder<ArticleModel.Data, ArticleViewAdapter.ArticleHolderView>() {


    class ArticleHolderView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val author = itemView.findViewById<TextView>(R.id.home_item_author)
        val time = itemView.findViewById<TextView>(R.id.home_item_time)
        val singleTitle = itemView.findViewById<TextView>(R.id.home_item_single_title)
        val chapter = itemView.findViewById<TextView>(R.id.home_item_chapter)
        val tagList = itemView.findViewById<LinearLayout>(R.id.home_item_tag_container)
    }

    override fun onBindViewHolder(holder: ArticleHolderView, item: ArticleModel.Data) {
        holder.author.text = if (item.author.isNullOrBlank()) item.shareUser else item.author
        holder.time.text = item.niceDate
        holder.chapter.text = item.chapterName
        holder.singleTitle.text = item.title
    }

    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ArticleHolderView {
        val view = inflater.inflate(R.layout.home_recyclerview_item, parent, false)
        return ArticleHolderView(
            view
        )
    }
}