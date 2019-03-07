package com.example.saba.sampleMVI.presentation.get.modules

import com.example.saba.sampleMVI.base.structure.scopes.PerFragment
import com.example.saba.sampleMVI.domain.useCases.DropLocalReposUseCase
import com.example.saba.sampleMVI.domain.useCases.GetLocalReposUseCase
import com.example.saba.sampleMVI.presentation.get.ResultNavigator
import com.example.saba.sampleMVI.presentation.get.ResultPresenter
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
