package com.lsakee.domain.model



data class Diet(
    val dateAndTypeDietInfo: List<DateAndTypeDietInfo>
)
data class DateAndTypeDietInfo(
    val commonMenu: List<String>,
    val company: String,
    val mainMenu: List<String>,
    val mealType: String,
    val restaurantType: String
)