package com.example.kayuringinsehat.DataModel

data class Jadwal(
    val idJadwal : Int,
    val sesi : String,
    val hari : String,
    val dokter: Dokter,
    val faskes: Faskes,
    val poli: Poli
)
