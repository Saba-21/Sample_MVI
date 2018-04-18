package com.example.saba.sampleKotlin.presentation.add

import com.example.saba.sampleKotlin.base.scope.PerFragment
import com.example.saba.sampleKotlin.domain.dataProvider.global.GlobalDataProvider
import com.example.saba.sampleKotlin.domain.useCase.GetStarredReposUseCase
import dagger.Module
import dagger.Provides

@Module
class AddingFragmentModule{

    @Provides
    @PerFragment
    fun provideAddingPresenter(addingNavigator: AddingNavigator,
                               getStarredReposUseCase: GetStarredReposUseCase):
            AddingPresenter = AddingPresenter(addingNavigator,getStarredReposUseCase)

}
