package com.example.saba.sampleKotlin.presentation.add

import com.example.saba.sampleKotlin.base.scope.PerFragment
import dagger.Module
import dagger.Provides

@Module
class AddingFragmentModule{

    @Provides
    @PerFragment
    fun provideAddingPresenter(addingNavigator: AddingNavigator):AddingPresenter = AddingPresenter(addingNavigator)

}
