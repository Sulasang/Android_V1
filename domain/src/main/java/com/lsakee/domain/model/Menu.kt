package com.lsakee.domain.model

data class Menu (
    val link:String,
    val days : Days
)

data class Days(
    val monday: List<String>,
    val tuesday: List<String>,
    val wednesday: List<String>,
    val thursday: List<String>,
    val friday: List<String>,
)