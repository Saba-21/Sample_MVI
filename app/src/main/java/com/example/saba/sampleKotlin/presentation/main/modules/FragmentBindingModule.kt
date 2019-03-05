package com.example.saba.sampleKotlin.presentation.main.modules

import com.example.saba.sampleKotlin.base.mvi.scopes.PerFragment
import com.example.saba.sampleKotlin.presentation.add.AddingFragment
import com.example.saba.sampleKotlin.presentation.add.modules.AddingFragmentModule
import com.example.saba.sampleKotlin.presentation.get.ResultFragment
import com.example.saba.sampleKotlin.presentation.get.modules.ResultFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [ResultFragmentModule::class])
    abstract fun provideResultFragmentFactory(): ResultFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [AddingFragmentModule::class])
    abstract fun provideAddingFragmentFactory(): AddingFragment

}
