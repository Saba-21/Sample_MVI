package com.example.saba.sampleKotlin.presentation

import com.example.saba.sampleKotlin.base.scope.PerActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule{

    @Provides
    @PerActivity
    fun provideMainPresenter():MainPresenter = MainPresenter()

}
