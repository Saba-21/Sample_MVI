package com.example.saba.sampleKotlin.presentation

import com.example.saba.sampleKotlin.base.scope.PerActivity
import com.example.saba.sampleKotlin.presentation.add.AddingNavigator
import com.example.saba.sampleKotlin.presentation.get.ResultNavigator
import dagger.Binds
import dagger.Module

@Module
abstract class NavigatorBindingModule {

    @Binds
    @PerActivity
    abstract fun bindAddingNavigator(presenter: MainPresenter):AddingNavigator

    @Binds
    @PerActivity
    abstract fun bindResultsNavigator(presenter: MainPresenter):ResultNavigator

}
