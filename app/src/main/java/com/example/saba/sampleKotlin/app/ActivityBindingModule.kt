package com.example.saba.sampleKotlin.app

import com.example.saba.sampleKotlin.presentation.main.MainActivity
import com.example.saba.sampleKotlin.presentation.main.MainActivityModule
import com.example.saba.sampleKotlin.mvi.scope.PerActivity
import com.example.saba.sampleKotlin.presentation.main.modules.FragmentBindingModule
import com.example.saba.sampleKotlin.presentation.main.modules.NavigatorBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule{

    @PerActivity
    @ContributesAndroidInjector(modules = [
        MainActivityModule::class,
        FragmentBindingModule::class,
        NavigatorBindingModule::class])
    abstract fun contributeMainActivityInjector(): MainActivity

}
