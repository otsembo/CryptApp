package com.eeyan.cryptapp.data.utils

import com.eeyan.cryptapp.data.remote.dto.*
import com.eeyan.cryptapp.domain.model.Coin
import com.eeyan.cryptapp.domain.model.CoinDetail

val TeamMemberUtil = TeamMember(
    id = "xyz",
    name = "kanake",
    position = "android developer"
)

val links = Links(
    explorer = listOf(),
    facebook = listOf(),
    reddit = listOf(),
    source_code = listOf(),
    website = listOf(),
    youtube = listOf()
)

val LinksExtendedUtil = LinksExtended(
    stats = Stats(contributors = 1, followers = 2, stars = 3, subscribers = 4),
    type = "",
    url = ""
)

val coinDtoTestUtil = CoinDto(
    id = "android",
    is_active = false,
    is_new = true,
    name = "name",
    rank = 10,
    symbol = "symbol",
    type = "type"
)

val coinTestUtil = Coin(
    id = "android",
    is_active = false,
    name = "name",
    rank = 10,
    symbol = "symbol",
)

val coinDetailDtoTestUtil = CoinDetailDto(
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

val coinDetailTestUtil = CoinDetail(
    coinId = "bitcoin",
    isActive = false,
    name = "name",
    description = "Bitcoin is a decentralized digital currency",
    rank = 10,
    symbol = "symbol",
    tags = listOf(),
    team = listOf(TeamMemberUtil)
)