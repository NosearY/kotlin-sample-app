package noseary.github.io.kotlinapp

import android.app.Application
import noseary.github.io.kotlinapp.di.component.AppComponent
import noseary.github.io.kotlinapp.di.component.DaggerAppComponent
import noseary.github.io.kotlinapp.di.module.AppModule
import noseary.github.io.kotlinapp.di.module.NetworkModule
import retrofit2.Retrofit
import javax.inject.Inject

class MainApplication: Application() {

    @Inject
    lateinit var retrofit: Retrofit

    private val appComponent: AppComponent  by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule((this)))
            .networkModule(NetworkModule(
            "http://newsapi.org/v2/")).build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    fun appComponent(): AppComponent = appComponent
}