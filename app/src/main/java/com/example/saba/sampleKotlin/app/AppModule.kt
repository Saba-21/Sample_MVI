package com.example.saba.sampleKotlin.app

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.example.saba.sampleKotlin.R
import com.example.saba.sampleKotlin.domain.dataProvider.global.GlobalDataProvider
import com.example.saba.sampleKotlin.domain.dataProvider.local.LocalDataProvider
import com.example.saba.sampleKotlin.domain.dataProvider.local.LocalDataProviderImpl
import com.example.saba.sampleKotlin.domain.database.RepoDatabase
import com.example.saba.sampleKotlin.domain.repository.Repository
import com.example.saba.sampleKotlin.domain.repository.RepositoryImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule{

    @Provides
    @Singleton
    fun provideContext(application: Application):
            Context = application

    @Provides
    @Singleton
    @Named("base_url")
    fun provideBaseUrl(context: Context):
            String = context.getString(R.string.base_url)

    @Provides
    @Singleton
    fun provideGSon():
            Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideGSonConverterFactory(gSon: Gson):
            GsonConverterFactory = GsonConverterFactory.create(gSon)

    @Provides
    @Singleton
    fun provideRx2CallAdapterFactory():
            RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    fun provideOkHtppClient():
            OkHttpClient = OkHttpClient.Builder().build()


    @Provides
    @Singleton
    fun provideRetrofit(@Named("base_url")baseUrl: String,
                        okHttpClient: OkHttpClient,
                        gSonConverterFactory: GsonConverterFactory,
                        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory):
            Retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .client(okHttpClient)
                        .addConverterFactory(gSonConverterFactory)
                        .addCallAdapterFactory(rxJava2CallAdapterFactory)
                        .build()

    @Provides
    @Singleton
    fun provideDatabase(context: Context):
            RepoDatabase = Room
            .databaseBuilder(context, RepoDatabase::class.java, "repoDatabase")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideLocalDataProvider(repoDatabase: RepoDatabase):
            LocalDataProvider = LocalDataProviderImpl(repoDatabase)

    @Provides
    @Singleton
    fun provideGlobalDataProvider(retrofit: Retrofit):
            GlobalDataProvider = retrofit.create(GlobalDataProvider::class.java)

    @Provides
    @Singleton
    fun provideRepository(globalDataProvider: GlobalDataProvider, localDataProvider: LocalDataProvider):
            Repository = RepositoryImpl(globalDataProvider,localDataProvider)

}
