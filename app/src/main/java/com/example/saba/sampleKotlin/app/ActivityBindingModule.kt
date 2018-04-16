package com.example.saba.sampleKotlin.app

import com.example.saba.sampleKotlin.MainActivity
import com.example.saba.sampleKotlin.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule{

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivityInjector():MainActivity

}