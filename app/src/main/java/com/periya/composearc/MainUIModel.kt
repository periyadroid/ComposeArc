package com.periya.composearc

data class MainUIModel(
    val isLoading : Boolean = false,
    val productId: String = EMPTY,
    val title: String = EMPTY,
    val userList : List<String> = emptyList(),
    val onLoadClick : (() -> Unit)? = null)