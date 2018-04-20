package com.example.saba.sampleKotlin.presentation.get

import com.example.saba.sampleKotlin.mvi.scope.PerFragment
import com.example.saba.sampleKotlin.domain.useCase.DropLocalReposUseCase
import com.example.saba.sampleKotlin.domain.useCase.GetLocalReposUseCase
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
