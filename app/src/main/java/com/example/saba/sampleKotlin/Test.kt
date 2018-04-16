package com.example.saba.sampleKotlin

import android.content.Context
import android.util.Log
import javax.inject.Inject

class Test @Inject constructor(private val context: Context) {

    fun log(){ Log.i("---------------------->", context.packageCodePath) }

}