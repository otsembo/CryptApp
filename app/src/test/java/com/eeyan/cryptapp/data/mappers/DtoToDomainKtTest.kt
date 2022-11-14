package com.eeyan.cryptapp.data.mappers

import com.eeyan.cryptapp.data.remote.dto.CoinDetailDto
import com.eeyan.cryptapp.data.remote.dto.CoinDto
import com.eeyan.cryptapp.data.remote.dto.Whitepaper
import com.eeyan.cryptapp.data.utils.LinksExtendedUtil
import com.eeyan.cryptapp.data.utils.TeamMemberUtil
import com.eeyan.cryptapp.data.utils.links
import com.eeyan.cryptapp.domain.model.Coin
import com.eeyan.cryptapp.domain.model.CoinDetail
import com.google.common.truth.Truth.assertThat
import org.junit.Test



class DtoToDomainKtTest {

    @Test
    fun `confirm that CoinDto toCoin results to Coin`() {
        val coinDto = CoinDto(
            id = "android",
            is_active = false,
            is_new = true,
            name = "name",
            rank = 10,
            symbol = "symbol",
            type = "type"
        )
        val coin = Coin(
            id = "android",
            is_active = false,
            name = "name",
            rank = 10,
            symbol = "symbol",
        )
        assertThat(coinDto.toCoin()).isEqualTo(coin)
    }

    @Test
    fun `confirm that toCoinDetail toDomain results to Coin`() {
        val coinDetailDto = CoinDetailDto(
            coinId = "bitcoin",
            isActive = false,
            is_new = true,
            name = "name",
            description = "Bitcoin is a decentralized digital currency",
            rank = 10,
            symbol = "symbol",
            tags = listOf(),
            team = listOf(TeamMemberUtil),
            development_status = "",
            first_data_at = "",
            hardware_wallet = false,
            hash_algorithm = "",
            last_data_at = "",
            links = links,
            links_extended = listOf(LinksExtendedUtil),
            message = "",
            open_source = true,
            org_structure = "",
            proof_type = "",
            started_at = "",
            whitepaper = Whitepaper(link = "", thumbnail = ""),
            type = ""
        )
        val coinDetail = CoinDetail(
            coinId = "bitcoin",
            isActive = false,
            name = "name",
            description = "Bitcoin is a decentralized digital currency",
            rank = 10,
            symbol = "symbol",
            tags = listOf(),
            team = listOf(TeamMemberUtil)
        )
        assertThat(coinDetailDto.toCoinDetail()).isEqualTo(coinDetail)
    }
}