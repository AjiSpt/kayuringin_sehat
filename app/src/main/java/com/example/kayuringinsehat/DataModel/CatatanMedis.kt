package com.example.kayuringinsehat.DataModel

import java.util.Date

data class CatatanMedis(
    val idSakit : Int,
    val diagnosa : String,
    val tglKunjungan : Date,
    val user: User,
    val dokter: Dokter,
    val faskes: Faskes
)
