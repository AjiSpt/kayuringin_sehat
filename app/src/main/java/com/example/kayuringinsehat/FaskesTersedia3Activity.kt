package com.example.kayuringinsehat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kayuringinsehat.adaptorRV.faskesTersediaAdapter3
import com.example.kayuringinsehat.data.dataFaskesTersedia3
import com.example.kayuringinsehat.databinding.ActivityFaskesTersedia3Binding

class FaskesTersedia3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityFaskesTersedia3Binding
    private lateinit var recyclerView: RecyclerView
    private lateinit var faskesTersedia3List: ArrayList<dataFaskesTersedia3>
    private lateinit var faskesTersedia3Adapter: faskesTersediaAdapter3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaskesTersedia3Binding.inflate(layoutInflater)
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
        recyclerView = binding.rvFaskestersedia3
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        faskesTersedia3List = ArrayList()

        faskesTersedia3Adapter = faskesTersediaAdapter3(faskesTersedia3List)
        recyclerView.adapter = faskesTersedia3Adapter
    }
    private  fun addDataKeList(){
        faskesTersedia3List.add((dataFaskesTersedia3(R.drawable.kli1)))
        faskesTersedia3List.add((dataFaskesTersedia3(R.drawable.kli2)))
        faskesTersedia3List.add((dataFaskesTersedia3(R.drawable.kli3)))
        faskesTersedia3List.add((dataFaskesTersedia3(R.drawable.kli4)))
        faskesTersedia3List.add((dataFaskesTersedia3(R.drawable.kli4)))

    }
}