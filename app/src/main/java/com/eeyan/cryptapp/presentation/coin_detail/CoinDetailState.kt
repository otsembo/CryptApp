package com.eeyan.cryptapp.presentation.coin_detail

import com.eeyan.cryptapp.domain.model.Coin
import com.eeyan.cryptapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin:CoinDetail? = null,
    val error:String = ""
)
