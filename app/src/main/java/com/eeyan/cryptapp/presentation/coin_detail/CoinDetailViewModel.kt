package com.eeyan.cryptapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eeyan.cryptapp.common.Constants
import com.eeyan.cryptapp.common.Resource
import com.eeyan.cryptapp.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel
    @Inject
    constructor(
        private val getCoinUseCase: GetCoinUseCase,
        savedStateHandle: SavedStateHandle
    ) : ViewModel()
{

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {

        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            getCoin(it)
        }

    }

    //call get coins
    private fun getCoin(coinId:String){
        //since we have  invoke function
        getCoinUseCase(coinId = coinId).onEach {
            when(it){
                is Resource.Success -> {
                    //set value of coins
                    _state.value = CoinDetailState(
                        coin = it.data
                    )

                }

                is Resource.Error -> {

                    //provide error message
                    _state.value = CoinDetailState(
                        error = it.message ?: "An unexpected error occurred"
                    )

                }

                is Resource.Loading -> {
                    //set loading is true
                    _state.value = CoinDetailState(isLoading = true)

                }
            }
        }.launchIn(viewModelScope)
    }

}
