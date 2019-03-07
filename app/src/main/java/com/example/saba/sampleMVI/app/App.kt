package com.example.saba.sampleMVI.app

import android.app.Activity
import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject lateinit var mDispatchingAndroidActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = mDispatchingAndroidActivityInjector

    override fun onCreate() {
        super.onCreate()
        initDagger()
        Fresco.initialize(this)
    }

    private fun initDagger(){
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }
}
