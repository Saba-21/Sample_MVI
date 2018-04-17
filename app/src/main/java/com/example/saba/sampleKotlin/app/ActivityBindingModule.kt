package com.example.saba.sampleKotlin.app

import com.example.saba.sampleKotlin.presentation.MainActivity
import com.example.saba.sampleKotlin.presentation.MainActivityModule
import com.example.saba.sampleKotlin.base.scope.PerActivity
import com.example.saba.sampleKotlin.presentation.FragmentBindingModule
import com.example.saba.sampleKotlin.presentation.NavigatorBinfingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule{

    @PerActivity
    @ContributesAndroidInjector(modules = [
        MainActivityModule::class,
        FragmentBindingModule::class,
        NavigatorBinfingModule::class
    ])
    abstract fun contributeMainActivityInjector(): MainActivity

}
