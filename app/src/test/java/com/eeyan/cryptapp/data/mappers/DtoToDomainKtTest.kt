package com.eeyan.cryptapp.data.mappers


import com.eeyan.cryptapp.data.utils.*
import com.google.common.truth.Truth.assertThat
import org.junit.Test



class DtoToDomainKtTest {

    @Test
    fun `confirm that CoinDto toCoin results to Coin`() {
        val coinDto = coinDtoTestUtil
        val coin = coinTestUtil
        assertThat(coinDto.toCoin()).isEqualTo(coin)
    }

    @Test
    fun `confirm that toCoinDetail toDomain results to Coin`() {
        val coinDetailDto = coinDetailDtoTestUtil
        val coinDetail = coinDetailTestUtil
        assertThat(coinDetailDto.toCoinDetail()).isEqualTo(coinDetail)
    }
}