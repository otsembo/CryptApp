package com.eeyan.cryptapp.presentation.coin_list.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eeyan.cryptapp.common.Resource
import com.eeyan.cryptapp.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel
    @Inject
    constructor(
        private val getCoinsUseCase: GetCoinsUseCase
    ) : ViewModel()
{

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {

        getCoins()

    }

    //call get coins
    private fun getCoins(){
        //since we have  invoke function
        getCoinsUseCase().onEach {
            when(it){
                is Resource.Success -> {
                    //set value of coins
                    _state.value = CoinListState(
                        coins = it.data ?: emptyList()
                    )

                }

                is Resource.Error -> {

                    //provide error message
                    _state.value = CoinListState(
                        error = it.message ?: "An unexpected error occurred"
                    )

                }

                is Resource.Loading -> {
                    //set loading is true
                    _state.value = CoinListState(isLoading = true)

                }
            }
        }.launchIn(viewModelScope)
    }

}
