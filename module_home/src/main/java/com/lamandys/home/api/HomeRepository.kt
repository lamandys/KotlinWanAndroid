package com.lamandys.home.api

import com.lamandys.basic.http.BaseRepository
import com.lamandys.basic.factory.HttpFactory
import com.lamandys.basic.http.ApiResult
import com.lamandys.home.model.ArticleModel
import com.lamandys.home.model.BannerModel

/**
 * Created by lamandys on 2020/3/7 2:41 PM.
 */
class HomeRepository : BaseRepository() {

    suspend fun getBanner(): ApiResult<ArrayList<BannerModel>> {
        return HttpFactory.getInstance().getApiServer(HomeApiService::class.java).getBanner()
    }

    suspend fun getArticle(page: Int = 0): ApiResult<ArticleModel> {
        return HttpFactory.getInstance().getApiServer(HomeApiService::class.java).getArticle(page)
    }
}