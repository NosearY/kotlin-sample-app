package noseary.github.io.kotlinapp.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import noseary.github.io.kotlinapp.MainApplication
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule @Inject constructor(private val mainApplication: MainApplication){

    @Singleton
    @Provides
    fun provideMainApplication(): MainApplication = mainApplication

    @Singleton
    @Provides
    fun provideApplicationContext(): Context = mainApplication.applicationContext
}