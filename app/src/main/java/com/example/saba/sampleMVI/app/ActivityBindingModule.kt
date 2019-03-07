package com.example.saba.sampleMVI.app

import com.example.saba.sampleMVI.presentation.main.MainActivity
import com.example.saba.sampleMVI.presentation.main.modules.MainActivityModule
import com.example.saba.sampleMVI.base.structure.scopes.PerActivity
import com.example.saba.sampleMVI.presentation.main.modules.FragmentBindingModule
import com.example.saba.sampleMVI.presentation.main.modules.NavigatorBindingModule
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
