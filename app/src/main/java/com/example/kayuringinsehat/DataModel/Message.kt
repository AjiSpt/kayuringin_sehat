package com.example.kayuringinsehat.DataModel

import java.util.Date

data class Message(
    val idMessage: String,
    val isiMessage: String,
    val waktuKirim: Date,
    val room: ChatRoom,
    val user: User,
    val faskes: Faskes
)
