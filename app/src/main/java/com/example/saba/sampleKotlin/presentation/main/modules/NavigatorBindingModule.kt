package com.example.saba.sampleKotlin.presentation.main.modules

import com.example.saba.sampleKotlin.base.mvi.scopes.PerActivity
import com.example.saba.sampleKotlin.presentation.add.AddingNavigator
import com.example.saba.sampleKotlin.presentation.get.ResultNavigator
import com.example.saba.sampleKotlin.presentation.main.MainActivity
import dagger.Module
import dagger.Provides

@Module
class NavigatorBindingModule {

    @PerActivity
    @Provides
    fun bindAddingNavigator(mainActivity: MainActivity): AddingNavigator {
        return mainActivity.getPresenter()
    }


    @PerActivity
    @Provides
    fun bindResultsNavigator(mainActivity: MainActivity): ResultNavigator {
        return mainActivity.getPresenter()
    }

}
