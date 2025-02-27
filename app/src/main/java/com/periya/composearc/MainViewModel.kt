package com.periya.composearc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepo: MainRepo) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUIModel())
    val uiState: StateFlow<MainUIModel> = _uiState

    fun onInitState(state: MainUIModel) {
        _uiState.update { state.copy(onLoadClick = ::onLoadClick) }
    }

    //If action needs to perform anything in viewmodel prefer this approach
    private fun onLoadClick() {
        if (_uiState.value.productId.isNotEmpty()) {
            viewModelScope.launch {
                _uiState.update {
                    it.copy(userList = it.userList+mainRepo.getData())
                }
            }
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return MainViewModel(
                   MainRepo(MainService())
                ) as T
            }
        }
    }

}