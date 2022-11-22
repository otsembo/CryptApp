package com.eeyan.cryptapp.data.mappers

import com.eeyan.cryptapp.data.remote.dto.CoinDetailDto
import com.eeyan.cryptapp.data.remote.dto.CoinDto
import com.eeyan.cryptapp.domain.model.Coin
import com.eeyan.cryptapp.domain.model.CoinDetail

fun CoinDto.toCoin() : Coin {
    return Coin(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}

fun CoinDetailDto.toCoinDetail() : CoinDetail {
    return CoinDetail(
        coinId = coinId,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        team = team,
        tags = tags.map { it.name },
        isActive = isActive
    )
}