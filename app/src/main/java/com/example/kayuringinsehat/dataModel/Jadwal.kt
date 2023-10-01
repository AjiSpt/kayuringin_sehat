package com.example.kayuringinsehat.dataModel

data class Jadwal(
    val idJadwal : Int,
    val sesi : String,
    val hari : String,
    val dokter: Dokter,
    val faskes: Faskes,
    val poli: Poli
)
