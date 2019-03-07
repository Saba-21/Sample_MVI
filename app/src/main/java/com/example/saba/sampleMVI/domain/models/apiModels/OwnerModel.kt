package com.example.saba.sampleMVI.domain.models.apiModels

import com.google.gson.annotations.SerializedName

data class OwnerModel(val id: Int,
                      val login:String,
                      @SerializedName("avatar_url")
                      val avatarUrl: String)
