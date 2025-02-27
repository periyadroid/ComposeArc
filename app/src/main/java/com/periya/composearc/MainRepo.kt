package com.periya.composearc

import kotlinx.coroutines.delay

class MainRepo(private val mainService: MainService) {

    suspend fun getData() : List<String>{
        delay(100)
        return mainService.getRemoteData()
    }

}