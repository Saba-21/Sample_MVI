package com.example.saba.sampleKotlin.presentation.main.modules

import com.example.saba.sampleKotlin.base.mvi.scopes.PerActivity
import com.example.saba.sampleKotlin.presentation.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule{

    @Provides
    @PerActivity
    fun provideMainPresenter(): MainPresenter = MainPresenter()

}
