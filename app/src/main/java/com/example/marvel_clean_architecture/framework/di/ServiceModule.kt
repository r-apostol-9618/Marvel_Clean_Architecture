package com.example.marvel_clean_architecture.framework.di

import com.example.marvel_clean_architecture.framework.AuthInterceptor
import com.example.marvel_clean_architecture.framework.service.MarvelApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl("https://gateway.marvel.com/v1/public/").client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
    return OkHttpClient().newBuilder().addInterceptor(logging).addInterceptor(authInterceptor)
        .build()
}

fun provideApi(retrofit: Retrofit): MarvelApi = retrofit.create(MarvelApi::class.java)

