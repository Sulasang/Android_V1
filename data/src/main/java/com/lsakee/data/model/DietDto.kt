package com.lsakee.data.model


import com.lsakee.domain.model.DateAndTypeDietInfo
import com.lsakee.domain.model.Diet
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

fun DietDto.toDietDomain() = Diet(
    dateAndTypeDietInfo.map { it.toDateAndTypeDietInfoDomain() }
)

fun DateAndTypeDietInfoDto.toDateAndTypeDietInfoDomain() = DateAndTypeDietInfo(
    commonMenu, company, mainMenu, mealType, restaurantType
)