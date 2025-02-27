package com.periya.composearc

data class MainUIModel(
    val productId: String = EMPTY,
    val title: String = EMPTY,
    val userList : List<String> = emptyList(),
    val isLoading : Boolean = true,
    val onLoadClick : (() -> Unit)? = null)