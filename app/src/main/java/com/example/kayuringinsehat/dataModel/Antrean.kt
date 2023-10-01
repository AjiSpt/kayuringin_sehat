package com.example.kayuringinsehat.dataModel

data class Antrean(
    val idAntre : Int,
    val noAntre : String,
    val user: User,
    val faskes: Faskes,
    val dokter: Dokter,
    val poli: Poli,
    val jadwal: Jadwal
)
