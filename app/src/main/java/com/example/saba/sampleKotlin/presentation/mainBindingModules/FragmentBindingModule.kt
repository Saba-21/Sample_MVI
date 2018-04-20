package com.example.saba.sampleKotlin.presentation.mainBindingModules

import com.example.saba.sampleKotlin.mvi.scope.PerFragment
import com.example.saba.sampleKotlin.presentation.add.AddingFragment
import com.example.saba.sampleKotlin.presentation.add.AddingFragmentModule
import com.example.saba.sampleKotlin.presentation.get.ResultFragment
import com.example.saba.sampleKotlin.presentation.get.ResultFragmentModule
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
