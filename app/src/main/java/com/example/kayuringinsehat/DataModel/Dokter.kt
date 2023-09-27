package com.example.kayuringinsehat.DataModel

data class Dokter(
    val idDokter : Int,
    val namaDokter : String,
    val fotoDokter : String,
    val faskes: Faskes,
    val poli: Poli,
    val jadwal: Jadwal
)
