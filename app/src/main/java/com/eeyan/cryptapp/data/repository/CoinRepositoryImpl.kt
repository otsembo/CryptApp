package com.eeyan.cryptapp.data.repository

import com.eeyan.cryptapp.data.remote.CoinPaprikaApi
import com.eeyan.cryptapp.data.remote.dto.CoinDetailDto
import com.eeyan.cryptapp.data.remote.dto.CoinDto
import com.eeyan.cryptapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl
    @Inject constructor(private val api:CoinPaprikaApi) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(id: String): CoinDetailDto {
        return api.getCoinById(id)
    }
}