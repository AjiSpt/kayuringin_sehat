package com.example.kayuringinsehat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kayuringinsehat.adaptorRV.faskesTersediaAdapter2
import com.example.kayuringinsehat.data.dataFaskesTersedia2
import com.example.kayuringinsehat.databinding.ActivityFaskesTersedia2Binding

class FaskesTersedia2 : AppCompatActivity() {

    private lateinit var binding: ActivityFaskesTersedia2Binding
    private lateinit var recyclerView: RecyclerView
    private lateinit var faskesTersedia2List: ArrayList<dataFaskesTersedia2>
    private lateinit var faskesTersedia2Adapter: faskesTersediaAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaskesTersedia2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        onCreateView()
        addDataKeList()

        binding.cvKembaliFaskesTersedia.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Menampilkan efek sentuhan saat ditekan
                    binding.cvKembaliFaskesTersedia.animate().scaleX(0.9f).scaleY(0.9f).start()
                }
                MotionEvent.ACTION_UP -> {
                    // Mengembalikan ukuran cardview ke semula
                    binding.cvKembaliFaskesTersedia.animate().scaleX(1f).scaleY(1f).start()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            true
        }
    }

    private fun onCreateView(){
        recyclerView = binding.rvFaskestersedia
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        faskesTersedia2List = ArrayList()

        faskesTersedia2Adapter = faskesTersediaAdapter2(faskesTersedia2List)
        recyclerView.adapter = faskesTersedia2Adapter
    }
    private  fun addDataKeList(){
        faskesTersedia2List.add((dataFaskesTersedia2(R.drawable.pus1)))
        faskesTersedia2List.add((dataFaskesTersedia2(R.drawable.pus2)))
        faskesTersedia2List.add((dataFaskesTersedia2(R.drawable.pus3)))
    }
}