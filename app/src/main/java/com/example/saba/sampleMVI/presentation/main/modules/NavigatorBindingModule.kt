package com.example.saba.sampleMVI.presentation.main.modules

import com.example.saba.sampleMVI.base.structure.scopes.PerActivity
import com.example.saba.sampleMVI.presentation.add.AddingNavigator
import com.example.saba.sampleMVI.presentation.get.ResultNavigator
import com.example.saba.sampleMVI.presentation.main.MainActivity
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
