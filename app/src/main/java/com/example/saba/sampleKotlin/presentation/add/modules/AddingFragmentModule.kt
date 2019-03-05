package com.example.saba.sampleKotlin.presentation.add.modules

import com.example.saba.sampleKotlin.base.mvi.scopes.PerFragment
import com.example.saba.sampleKotlin.domain.useCase.GetGlobalReposUseCase
import com.example.saba.sampleKotlin.domain.useCase.GetLocalReposUseCase
import com.example.saba.sampleKotlin.domain.useCase.SaveLocalRepoUseCase
import com.example.saba.sampleKotlin.presentation.add.AddingNavigator
import com.example.saba.sampleKotlin.presentation.add.AddingPresenter
import dagger.Module
import dagger.Provides

@Module
class AddingFragmentModule{

    @Provides
    @PerFragment
    fun provideAddingPresenter(addingNavigator: AddingNavigator,
                               getGlobalReposUseCase: GetGlobalReposUseCase,
                               saveLocalRepoUseCase: SaveLocalRepoUseCase):
            AddingPresenter = AddingPresenter(addingNavigator,
            getGlobalReposUseCase,
            saveLocalRepoUseCase)

}
