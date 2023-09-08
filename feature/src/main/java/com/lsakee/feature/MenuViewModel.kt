package com.lsakee.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lsakee.domain.usecase.GetStaffMenuUseCase
import com.lsakee.domain.usecase.GetStudentMenuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val getStudentMenuUseCase : GetStudentMenuUseCase,
    private val getStaffMenuUseCase : GetStaffMenuUseCase,
    ) : ViewModel() {
    fun getTag() = viewModelScope.launch {
        Timber.d("test")

        getStudentMenuUseCase().collect {
            Timber.tag("hello").d(it.toString())
        }
    }

}