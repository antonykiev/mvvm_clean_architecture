package com.example.cleanarchitecture.domain.entity

sealed class Answer {
    data class Yes(val imageUrl: String) : Answer()
    data class No(val imageUrl: String) : Answer()
    object Maybe : Answer()
}