package com.example.kayuringinsehat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kayuringinsehat.adaptorRV.faskesTersediaAdapter
import com.example.kayuringinsehat.data.dataFaskesTersedia
import com.example.kayuringinsehat.databinding.ActivityFaskesTersediaBinding

class FaskesTersedia : AppCompatActivity() {

    private lateinit var binding: ActivityFaskesTersediaBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var faskesTersediaList: ArrayList<dataFaskesTersedia>
    private lateinit var faskesTersediaAdapter: faskesTersediaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaskesTersediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onCreateView()
        addDataKeList()

        binding.cvKembaliFaskesTersedia.setOnClickListener {
            val fragment = ListFaskesFragment
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.faskesTersediaxml, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

//        binding.cvKembaliFaskesTersedia.setOnTouchListener { view, motionEvent ->
//            when (motionEvent.action) {
//                MotionEvent.ACTION_DOWN -> {
//                    // Menampilkan efek sentuhan saat ditekan
//                    binding.cvKembaliFaskesTersedia.animate().scaleX(0.9f).scaleY(0.9f).start()
//                }
//                MotionEvent.ACTION_UP -> {
//                    // Mengembalikan ukuran cardview ke semula
//                    binding.cvKembaliFaskesTersedia.animate().scaleX(1f).scaleY(1f).start()
//                    startActivity(Intent(this, MainActivity::class.java))
//                }
//            }
//            true
//        }
    }

    private fun onCreateView(){
        recyclerView = binding.rvFaskestersedia
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        faskesTersediaList = ArrayList()

        faskesTersediaAdapter = faskesTersediaAdapter(faskesTersediaList)
        recyclerView.adapter = faskesTersediaAdapter
    }
    private  fun addDataKeList(){
        faskesTersediaList.add((dataFaskesTersedia(R.drawable.rs1)))
        faskesTersediaList.add((dataFaskesTersedia(R.drawable.rs2)))
        faskesTersediaList.add((dataFaskesTersedia(R.drawable.rs3)))
        faskesTersediaList.add((dataFaskesTersedia(R.drawable.rs4)))
    }
}