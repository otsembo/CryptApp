package com.eeyan.cryptapp.domain.use_case.get_coin

import com.eeyan.cryptapp.common.Resource
import com.eeyan.cryptapp.data.remote.dto.toCoin
import com.eeyan.cryptapp.data.remote.dto.toCoinDetail
import com.eeyan.cryptapp.data.repository.CoinRepository
import com.eeyan.cryptapp.domain.model.Coin
import com.eeyan.cryptapp.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase
    @Inject constructor(private val repository: CoinRepository)
{

        operator fun invoke(coinId:String) : Flow<Resource<CoinDetail>> = flow {

            try{
                //start loading
                emit(Resource.Loading<CoinDetail>())
                //retrieve coins from repo
                val coin = repository.getCoinById(coinId).toCoinDetail()
                //success
                emit(Resource.Success(coin))
            }catch (e : HttpException){
                //error
                emit(Resource.Error<CoinDetail>(e.localizedMessage?: "An unexpected error occurred"))
            }catch (e: IOException){
                emit(Resource.Error<CoinDetail>("Could not reach server! Check internet connection"))
            }

        }

}