package com.periya.composearc

class MainService {

    private var count = 0

    fun getRemoteData(): List<String> {
        val res =  (count..count+10).map { "User $it" }
        count+=10
        return res
    }

}