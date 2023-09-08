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
    fun getDiet(date:String, type:String) = viewModelScope.launch {
        getDietUseCase(date,type).collect {
            _diet.value=UiState.Success(it)
            Timber.d("$it")
        }
    }

}