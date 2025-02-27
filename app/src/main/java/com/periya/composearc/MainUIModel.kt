package com.periya.composearc

data class MainUIModel(
    val productId: String = EMPTY,
    val title: String = EMPTY,
    val userList : List<String> = emptyList(),
    val onLoadClick : (() -> Unit)? = null)