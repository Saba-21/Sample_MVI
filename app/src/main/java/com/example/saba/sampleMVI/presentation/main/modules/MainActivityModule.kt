package com.example.saba.sampleMVI.presentation.main.modules

import com.example.saba.sampleMVI.base.structure.scopes.PerActivity
import com.example.saba.sampleMVI.presentation.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule{

    @Provides
    @PerActivity
    fun provideMainPresenter(): MainPresenter = MainPresenter()

}
