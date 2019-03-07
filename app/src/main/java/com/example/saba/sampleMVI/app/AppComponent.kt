package com.example.saba.sampleMVI.app

import android.app.Application
import javax.inject.Singleton
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(modules = [
    com.example.saba.sampleMVI.app.AppModule::class,
    com.example.saba.sampleMVI.app.ActivityBindingModule::class,
    AndroidSupportInjectionModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): com.example.saba.sampleMVI.app.AppComponent.Builder

        fun build(): com.example.saba.sampleMVI.app.AppComponent
    }

    fun inject(app: com.example.saba.sampleMVI.app.App)

}
