package com.eeyan.cryptapp.data.utils

import com.eeyan.cryptapp.data.remote.dto.Links
import com.eeyan.cryptapp.data.remote.dto.LinksExtended
import com.eeyan.cryptapp.data.remote.dto.Stats
import com.eeyan.cryptapp.data.remote.dto.TeamMember

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