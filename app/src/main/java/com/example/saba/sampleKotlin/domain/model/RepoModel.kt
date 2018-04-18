package com.example.saba.sampleKotlin.domain.model

import com.google.gson.annotations.SerializedName

data class RepoModel(val id: Int,
                     val name: String,
                     val language: String,
                     @SerializedName("stargazers_count")
                     val starCount: Int,
                     val owner: OwnerModel)
