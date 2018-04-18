package com.example.saba.sampleKotlin.app

import android.app.Application
import javax.inject.Singleton
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(modules = [
    AppModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

}
