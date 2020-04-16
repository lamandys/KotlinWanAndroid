package com.lamandys.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lamandys.basic.base.BaseViewModel
import com.lamandys.basic.ext.execResult
import com.lamandys.basic.logger.log
import com.lamandys.home.api.HomeRepository
import com.lamandys.home.model.ArticleModel
import com.lamandys.home.model.BannerModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * Created by lamandys on 2020/3/6 4:31 PM.
 */
class HomeViewModel : BaseViewModel<HomeRepository>() {

    val mBannerData = MutableLiveData<ArrayList<BannerModel>>()
    val mArticleList = MutableLiveData<ArrayList<ArticleModel.Data>>()

    /** 用于处理分页 */
    val pageEvent = MutableLiveData<ArticleModel>()

    var currentPage: Int = 0

    fun requestHomeData() {
        viewModelScope.launch {
            val banner = async { api.getBanner() }
            val article = async { api.getArticle() }
            banner.await().execResult({
                mBannerData.postValue(this)
            }, {
                log { "请求失败，errCode is $errorCode && errMsg is $errorMsg" }
            })
            article.await().execResult({
                dealWithArticleData(this)
            }, {
                log { "请求失败，errCode is $errorCode && errMsg is $errorMsg" }
            })
        }
    }

    fun requestBanner() {
        viewModelScope.launch {
            api.getBanner().execResult(success = {
                mBannerData.postValue(this)
            }, failed = {
                log { "请求失败，errCode is $errorCode && errMsg is $errorMsg" }
            })
        }
    }

    private fun dealWithArticleData(articleModel: ArticleModel) {
        pageEvent.postValue(articleModel)
        currentPage = articleModel.curPage ?: currentPage
        // 过滤所有为null的值
        val allNonData = articleModel.datas?.filterNotNull()
        mArticleList.postValue(allNonData as ArrayList<ArticleModel.Data>)
    }

    fun requestArticleList(page: Int) {
        viewModelScope.launch {
            api.getArticle(page).execResult({
                dealWithArticleData(this)
            }, {
                log { "请求失败，errCode is $errorCode && errMsg is $errorMsg" }
            })
        }
    }
}