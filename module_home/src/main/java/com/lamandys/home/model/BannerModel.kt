package com.lamandys.home.model
import com.google.gson.annotations.SerializedName


/**
 * Created by lamandys on 2020/3/6 5:55 PM.
 */
data class BannerModel(
    @SerializedName("desc")
    var desc: String? = "",
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("imagePath")
    var imagePath: String? = "",
    @SerializedName("isVisible")
    var isVisible: Int? = 0,
    @SerializedName("order")
    var order: Int? = 0,
    @SerializedName("title")
    var title: String? = "",
    @SerializedName("type")
    var type: Int? = 0,
    @SerializedName("url")
    var url: String? = ""
)