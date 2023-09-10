package com.lsakee.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lsakee.core_ui.view.UiState
import com.lsakee.domain.model.Diet
import com.lsakee.domain.usecase.GetDietUseCase
import com.lsakee.feature.model.DietData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val getDietUseCase: GetDietUseCase
    ) : ViewModel() {

    private val _dietData = MutableStateFlow<UiState<DietData>>(UiState.Loading)
    val dietData: StateFlow<UiState<DietData>> = _dietData.asStateFlow()

    private val companyMap = mutableMapOf<String, Pair<List<String>, List<String>>>()
    fun getDiet(date: String,type: String) = viewModelScope.launch {
        getDietUseCase(date, type).collect{
            companyMap.clear()
            for (dietInfo in it.dateAndTypeDietInfo) {
                val company = dietInfo.company
                if (company.isNotEmpty()) {
                    if (companyMap.containsKey(company)) {
                        val companyCommonMenu = companyMap[company]?.first?.toMutableList()
                        val companyMainMenu = companyMap[company]?.second?.toMutableList()
                        companyCommonMenu?.addAll(dietInfo.commonMenu)
                        companyMainMenu?.addAll(dietInfo.mainMenu)
                        companyMap[company] = Pair(
                            companyCommonMenu?.toList() ?: emptyList(),
                            companyMainMenu?.toList() ?: emptyList()
                        )
                    } else {
                        val companyCommonMenu = dietInfo.commonMenu.toMutableList()
                        val companyMainMenu = dietInfo.mainMenu.toMutableList()
                        companyMap[company] =
                            Pair(companyCommonMenu.toList(), companyMainMenu.toList())
                    }
                }
            }
            _dietData.value = UiState.Success(DietData(
                companyMap["Little Kitchen"] ?: Pair(listOf("오늘은 학식이 없습니다."), listOf("오늘은 학식이 없습니다.")),
                companyMap["Mom's Cook"] ?: Pair(listOf("오늘은 학식이 없습니다."), listOf("오늘은 학식이 없습니다.")),
                companyMap["Chef Table"] ?: Pair(listOf("오늘은 학식이 없습니다."), listOf("오늘은 학식이 없습니다."))
            ))
        }

    }

}