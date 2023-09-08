package com.lsakee.data_remote.response

import com.lsakee.data.model.DaysEntity
import com.lsakee.data.model.MenuEntity

data class MenuResponse(
    val link: String,
    val days: DaysResponse
)

data class DaysResponse(
    val friday: List<String>,
    val monday: List<String>,
    val thursday: List<String>,
    val tuesday: List<String>,
    val wednesday: List<String>
)

fun MenuResponse.toMenuData() = MenuEntity(
    link = link,
    days = days.toDaysData()
)

fun DaysResponse.toDaysData() = DaysEntity(
    friday, monday, thursday, tuesday, wednesday
)