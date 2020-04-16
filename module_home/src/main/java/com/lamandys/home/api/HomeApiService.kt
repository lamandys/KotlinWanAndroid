package com.lamandys.home.api

import com.lamandys.basic.http.ApiResult
import com.lamandys.home.model.ArticleModel
import com.lamandys.home.model.BannerModel
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by lamandys on 2020/3/6 5:40 PM.
 */
interface HomeApiService {

    @GET("/banner/json")
    suspend fun getBanner(): ApiResult<ArrayList<BannerModel>>

    @GET("/article/list/{page}/json")
    suspend fun getArticle(@Path("page") page: Int): ApiResult<ArticleModel>
}