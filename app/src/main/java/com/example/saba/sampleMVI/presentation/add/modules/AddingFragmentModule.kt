package com.example.saba.sampleMVI.presentation.add.modules

import com.example.saba.sampleMVI.base.structure.scopes.PerFragment
import com.example.saba.sampleMVI.domain.useCases.GetGlobalReposUseCase
import com.example.saba.sampleMVI.domain.useCases.SaveLocalRepoUseCase
import com.example.saba.sampleMVI.presentation.add.AddingNavigator
import com.example.saba.sampleMVI.presentation.add.AddingPresenter
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
