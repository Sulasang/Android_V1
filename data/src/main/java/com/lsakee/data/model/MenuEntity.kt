package com.lsakee.data.model

import com.lsakee.domain.model.Days
import com.lsakee.domain.model.Menu
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MenuEntity (
    @SerialName("link")
    val link:String,
    @SerialName("days")
    val days : DaysEntity
)
@Serializable
data class DaysEntity(
    @SerialName("monday")
    val monday: List<String>,
    @SerialName("tuesday")
    val tuesday: List<String>,
    @SerialName("wednesday")
    val wednesday: List<String>,
    @SerialName("thursday")
val thursday: List<String>,
    @SerialName("friday")
val friday: List<String>,
)

fun MenuEntity.toMenuDomain() = Menu(
    link = link,
    days = days.toDaysDomain()
)

fun DaysEntity.toDaysDomain() = Days(
    friday, monday, thursday, tuesday, wednesday
)