package com.example.kayuringinsehat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager

        // Menambahkan fragment_layanan.xml ke FragmentContainerView di activity_main.xml
        fragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, LayananFragment())
            .commit()
    }
}