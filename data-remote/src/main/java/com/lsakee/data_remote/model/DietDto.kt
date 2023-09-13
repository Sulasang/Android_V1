package com.lsakee.data_remote.model


import com.lsakee.data.model.DietData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DietDto(
    @SerialName("dateAndTypeDietInfo")
    val dateAndTypeDietInfo: List<DateAndTypeDietInfoDto>
)

@Serializable
data class DateAndTypeDietInfoDto(
    @SerialName("commonMenu")
    val commonMenu: List<String>,
    @SerialName("company")
    val company: String,
    @SerialName("mainMenu")
    val mainMenu: List<String>,
    @SerialName("mealType")
    val mealType: String,
    @SerialName("restaurantType")
    val restaurantType: String
)

fun DietDto.toDietData() = DietData(
    dateAndTypeDietInfo.map { it.toDateAndTypeDietInfoData() }
)

fun DateAndTypeDietInfoDto.toDateAndTypeDietInfoData() = com.lsakee.data.model.DateAndTypeDietInfoData(
    commonMenu, company, mainMenu, mealType, restaurantType
)