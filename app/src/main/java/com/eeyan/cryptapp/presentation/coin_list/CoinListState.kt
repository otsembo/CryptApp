package com.eeyan.cryptapp.presentation.coin_list

import com.eeyan.cryptapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins:List<Coin> = emptyList(),
    val error:String = ""
)
