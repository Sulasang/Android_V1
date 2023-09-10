package com.lsakee.data.model


import com.lsakee.domain.model.DateAndTypeDietInfo
import com.lsakee.domain.model.Diet
import kotlinx.serialization.Serializable

data class DietData(
    val dateAndTypeDietInfo: List<DateAndTypeDietInfoData>
)

@Serializable
data class DateAndTypeDietInfoData(
    val commonMenu: List<String>,
    val company: String,
    val mainMenu: List<String>,
    val mealType: String,
    val restaurantType: String
)

fun DietData.toDietDomain() = Diet(
    dateAndTypeDietInfo.map { it.toDateAndTypeDietInfoDomain() }
)

fun DateAndTypeDietInfoData.toDateAndTypeDietInfoDomain() = DateAndTypeDietInfo(
    commonMenu, company, mainMenu, mealType, restaurantType
)