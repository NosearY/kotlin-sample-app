package noseary.github.io.kotlinapp.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

// 1e48958d28ec44a79060e0ca8b3a1c6f
@Module
class NetworkModule @Inject constructor(private val baseUrl: String){
    @Singleton
    @Provides
    fun provideGson(): Gson {
        with(GsonBuilder()) {
            return this.create()
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        with(OkHttpClient.Builder()) {
            return this.build()
        }
    }

    @Singleton
    @Provides
    fun provideNewsApiRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        with(Retrofit.Builder()) {
            return this.baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

    }
}