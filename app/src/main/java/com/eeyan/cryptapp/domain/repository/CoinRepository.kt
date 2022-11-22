package com.eeyan.cryptapp.domain.repository

import com.eeyan.cryptapp.data.remote.dto.CoinDetailDto
import com.eeyan.cryptapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(id:String) : CoinDetailDto

}