package com.eeyan.cryptapp.di

import com.eeyan.cryptapp.common.Constants
import com.eeyan.cryptapp.data.remote.CoinPaprikaApi
import com.eeyan.cryptapp.data.repository.CoinRepository
import com.eeyan.cryptapp.domain.repository.CoinRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(Singleton::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi() : CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }


    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi) : CoinRepository{
        return CoinRepositoryImpl(api)
    }

}