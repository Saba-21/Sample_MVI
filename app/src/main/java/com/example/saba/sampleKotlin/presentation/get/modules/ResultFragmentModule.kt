package com.example.saba.sampleKotlin.presentation.get.modules

import com.example.saba.sampleKotlin.base.mvi.scopes.PerFragment
import com.example.saba.sampleKotlin.domain.useCase.DropLocalReposUseCase
import com.example.saba.sampleKotlin.domain.useCase.GetLocalReposUseCase
import com.example.saba.sampleKotlin.presentation.get.ResultNavigator
import com.example.saba.sampleKotlin.presentation.get.ResultPresenter
import dagger.Module
import dagger.Provides

@Module
class ResultFragmentModule{

    @Provides
    @PerFragment
    fun provideResultPresenter(resultNavigator: ResultNavigator,
                               getLocalReposUseCase: GetLocalReposUseCase,
                               dropLocalReposUseCase: DropLocalReposUseCase):
            ResultPresenter = ResultPresenter(resultNavigator,
            getLocalReposUseCase,
            dropLocalReposUseCase)

}
