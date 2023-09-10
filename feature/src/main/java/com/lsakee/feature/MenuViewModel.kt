package com.lsakee.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lsakee.core_ui.view.UiState
import com.lsakee.domain.model.Diet
import com.lsakee.domain.usecase.GetDietUseCase
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

    private val _diet = MutableStateFlow<UiState<Diet>>(UiState.Loading)
    val diet: StateFlow<UiState<Diet>> = _diet.asStateFlow()

    data class DietData(
        val diet1: Pair<List<String>, List<String>>,
        val diet2: Pair<List<String>, List<String>>,
        val diet3: Pair<List<String>, List<String>>
    )

    private val _dietData = MutableStateFlow<UiState<DietData>>(UiState.Loading)
    val dietData: StateFlow<UiState<DietData>> = _dietData.asStateFlow()
    fun getDiet(date:String, type:String) = viewModelScope.launch {
        getDietUseCase(date,type).collect {
            _diet.value=UiState.Success(it)
            Timber.d("$it")
        }
    }
    private val companyMap = mutableMapOf<String, Pair<List<String>, List<String>>>()
    fun getDietV2(date: String,type: String) = viewModelScope.launch {
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
                companyMap["Little Kitchen"] ?: Pair(emptyList(), emptyList()),
                companyMap["Mom's Cook"] ?: Pair(emptyList(), emptyList()),
                companyMap["Chef Table"] ?: Pair(emptyList(), emptyList())
            ))
        }

    }

}