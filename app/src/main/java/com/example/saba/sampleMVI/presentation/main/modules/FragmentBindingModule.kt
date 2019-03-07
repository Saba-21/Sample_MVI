package com.example.saba.sampleMVI.presentation.main.modules

import com.example.saba.sampleMVI.base.structure.scopes.PerFragment
import com.example.saba.sampleMVI.presentation.add.AddingFragment
import com.example.saba.sampleMVI.presentation.add.modules.AddingFragmentModule
import com.example.saba.sampleMVI.presentation.get.ResultFragment
import com.example.saba.sampleMVI.presentation.get.modules.ResultFragmentModule
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
