package com.lamandys.home.ui

import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.drakeet.multitype.MultiTypeAdapter
import com.lamandys.basic.base.BaseFragment
import com.lamandys.basic.ext.execObserver
import com.lamandys.basic.statusbar.StatusBarUtil
import com.lamandys.home.adapter.ArticleViewAdapter
import com.lamandys.home.adapter.ArticleBigViewAdapter
import com.lamandys.home.adapter.BannerViewAdapter
import com.lamandys.home.model.ArticleModel
import com.lamandys.home.type.BannerType
import com.lamandys.router.R
import com.lamandys.router.RouterPath
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import kotlinx.android.synthetic.main.home_fragment.*

@Route(path = RouterPath.Home.Home_Fragment)
class HomeFragment : BaseFragment<HomeViewModel>() {

    private var multiTypeAdapter: MultiTypeAdapter? = null
    private val mDataList: ArrayList<Any> = ArrayList()

    override fun getLayoutId(): Int {
        return R.layout.home_fragment
    }

    override fun initDataAfterView() {
        execObserver(mViewModel.mBannerData) {
            mDataList.clear()
            mDataList.add(0, BannerType(this))
            multiTypeAdapter?.items = mDataList
            multiTypeAdapter?.notifyDataSetChanged()
            home_smart_refresh?.finishRefresh()
        }
        execObserver(mViewModel.mArticleList) {
            mDataList.addAll(this)
            multiTypeAdapter?.items = mDataList
            multiTypeAdapter?.notifyDataSetChanged()
            home_smart_refresh?.finishLoadMore()
        }
        mViewModel.requestHomeData()
    }

    override fun initView() {
        StatusBarUtil.setTranslucentStatus(activity)
        StatusBarUtil.setStatusBarDarkTheme(activity, true)

        home_recyclerview?.apply {
            layoutManager = LinearLayoutManager(context)
            multiTypeAdapter = MultiTypeAdapter()
            multiTypeAdapter?.register(BannerType::class.java, BannerViewAdapter())
            // 一拖二
            multiTypeAdapter?.register(ArticleModel.Data::class.java)?.to(
                ArticleViewAdapter(),
                ArticleBigViewAdapter()
            )?.withKotlinClassLinker { _, item ->
                when (item.envelopePic.isNullOrBlank()) {
                    true -> ArticleViewAdapter::class
                    else -> ArticleBigViewAdapter::class
                }
            }
            adapter = multiTypeAdapter
        }

        home_smart_refresh?.apply {
            setRefreshHeader(ClassicsHeader(context))
            setRefreshFooter(ClassicsFooter(context))

            setOnRefreshListener {
                mViewModel.requestHomeData()
            }

            setOnLoadMoreListener {
                mViewModel.requestArticleList(mViewModel.currentPage + 1)
            }
        }

    }

}
