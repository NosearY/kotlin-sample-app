package noseary.github.io.kotlinapp.di.component

import dagger.Component
import noseary.github.io.kotlinapp.MainApplication
import noseary.github.io.kotlinapp.di.module.AppModule
import noseary.github.io.kotlinapp.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(app: MainApplication)
}