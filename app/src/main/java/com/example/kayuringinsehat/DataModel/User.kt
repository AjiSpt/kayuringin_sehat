package com.example.kayuringinsehat.DataModel

import java.sql.Blob

data class User(
    val nik: Int,
    val nama: String,
    val telepon: Int,
    val kataSandi: String,
    val fotoProfil: String,
    val golDarah: String,
    val tensiDarah: String,
)