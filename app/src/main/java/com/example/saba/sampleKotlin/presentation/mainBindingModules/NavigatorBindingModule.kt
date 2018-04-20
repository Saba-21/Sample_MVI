package com.example.saba.sampleKotlin.presentation.mainBindingModules

import com.example.saba.sampleKotlin.mvi.scope.PerActivity
import com.example.saba.sampleKotlin.presentation.MainPresenter
import com.example.saba.sampleKotlin.presentation.add.AddingNavigator
import com.example.saba.sampleKotlin.presentation.get.ResultNavigator
import dagger.Binds
import dagger.Module

@Module
abstract class NavigatorBindingModule {

    @Binds
    @PerActivity
    abstract fun bindAddingNavigator(presenter: MainPresenter): AddingNavigator

    @Binds
    @PerActivity
    abstract fun bindResultsNavigator(presenter: MainPresenter): ResultNavigator

}
