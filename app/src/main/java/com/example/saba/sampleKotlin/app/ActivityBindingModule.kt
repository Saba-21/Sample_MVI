package com.example.saba.sampleKotlin.app

import com.example.saba.sampleKotlin.presentation.MainActivity
import com.example.saba.sampleKotlin.presentation.MainActivityModule
import com.example.saba.sampleKotlin.mvi.scope.PerActivity
import com.example.saba.sampleKotlin.presentation.bindingModules.FragmentBindingModule
import com.example.saba.sampleKotlin.presentation.bindingModules.NavigatorBindingModule
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
