package com.example.saba.sampleKotlin.presentation.add

import com.example.saba.sampleKotlin.base.scope.PerFragment
import com.example.saba.sampleKotlin.domain.useCase.GetGlobalReposUseCase
import com.example.saba.sampleKotlin.domain.useCase.SaveLocalRepoUseCase
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
