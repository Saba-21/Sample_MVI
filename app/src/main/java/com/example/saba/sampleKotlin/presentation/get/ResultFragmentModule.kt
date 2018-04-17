package com.example.saba.sampleKotlin.presentation.get

import com.example.saba.sampleKotlin.base.scope.PerFragment
import dagger.Module
import dagger.Provides

@Module
class ResultFragmentModule{

    @Provides
    @PerFragment
    fun provideResultPresenter(resultNavigator: ResultNavigator):ResultPresenter = ResultPresenter(resultNavigator)

}
