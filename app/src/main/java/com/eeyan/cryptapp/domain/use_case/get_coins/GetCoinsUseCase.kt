package com.eeyan.cryptapp.domain.use_case.get_coins

import com.eeyan.cryptapp.common.Resource
import com.eeyan.cryptapp.data.remote.dto.toCoin
import com.eeyan.cryptapp.data.repository.CoinRepository
import com.eeyan.cryptapp.domain.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase
    @Inject constructor(private val repository: CoinRepository)
{

        operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
            //test coins (simply prevent android studio complaints)
            val sampleCoins : List<Coin> = ArrayList()

            try{
                //start loading
                emit(Resource.Loading(sampleCoins))
                //retrieve coins from repo
                val coins = repository.getCoins().map { it.toCoin() }
                //success
                emit(Resource.Success(coins))
            }catch (e : HttpException){
                //error
                emit(Resource.Error(e.localizedMessage?: "An unexpected error occurred",sampleCoins))
            }catch (e: IOException){
                emit(Resource.Error("Could not reach server! Check internet connection",sampleCoins))
            }

        }

}