package com.example.saba.sampleKotlin.domain.model

import com.google.gson.annotations.SerializedName

data class OwnerModel(val login:String,
                      @SerializedName("avatar_url")
                      val avatar: String)
