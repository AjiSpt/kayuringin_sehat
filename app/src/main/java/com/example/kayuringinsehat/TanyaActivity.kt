package com.example.kayuringinsehat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kayuringinsehat.adaptorRV.tanyaAdaptor
import com.example.kayuringinsehat.data.dataTanya
import com.example.kayuringinsehat.databinding.FragmentTanyaBinding

class TanyaActivity : Fragment() {
    private var _binding: FragmentTanyaBinding? = null

    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var tanyaList: ArrayList<dataTanya>
    private lateinit var tanyaAdaptor: tanyaAdaptor


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTanyaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTanyaBinding.bind(view)

        recyclerView = binding.rvTanya
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        tanyaList = ArrayList()

        tanyaAdaptor = tanyaAdaptor(tanyaList)
        recyclerView.adapter = tanyaAdaptor

        addDataToList()
    }

    private fun addDataToList() {
        tanyaList.add(dataTanya(R.drawable.rumahsakit1))
        tanyaList.add(dataTanya(R.drawable.rumahsakit2))
        tanyaList.add(dataTanya(R.drawable.rumahsakit3))
        tanyaList.add(dataTanya(R.drawable.rumahsakit4))
        tanyaList.add(dataTanya(R.drawable.puskesmas1))
        tanyaList.add(dataTanya(R.drawable.puskesmas2))
        tanyaList.add(dataTanya(R.drawable.puskesmas3))
        tanyaList.add(dataTanya(R.drawable.klinik1))
        tanyaList.add(dataTanya(R.drawable.klinik2))
        tanyaList.add(dataTanya(R.drawable.klinik3))
        tanyaList.add(dataTanya(R.drawable.klinik4))
        tanyaList.add(dataTanya(R.drawable.klinik5))
        tanyaList.add(dataTanya(R.drawable.klinikgigi1))
        tanyaList.add(dataTanya(R.drawable.klinikgigi2))
        tanyaList.add(dataTanya(R.drawable.klinikgigi3))
    }
}