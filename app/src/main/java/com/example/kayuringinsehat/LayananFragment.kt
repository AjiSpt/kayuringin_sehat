package com.example.kayuringinsehat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.kayuringinsehat.adaptorRV.layananAdaptor
import com.example.kayuringinsehat.data.dataLayanan
import com.example.kayuringinsehat.databinding.FragmentLayananBinding

class LayananFragment : Fragment() {
    private var _binding: FragmentLayananBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var layananList:ArrayList<dataLayanan>
    private lateinit var makananAdaptor: layananAdaptor



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLayananBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLayananBinding.bind(view)

        recyclerView = binding.rvMainmenu
        recyclerView.setHasFixedSize(true)
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        layananList = ArrayList()

        makananAdaptor = layananAdaptor(layananList)
        recyclerView.adapter = makananAdaptor

        addDataToList()

        binding.cvKalGiziAnak.setOnClickListener {
            val intent = Intent(activity, GiziActivity::class.java)
            startActivity(intent)
        }
        binding.cvBmi.setOnClickListener {
            val intent = Intent(activity, BmiActivity::class.java)
            startActivity(intent)
        }
        binding.cvKalMenstruasi.setOnClickListener {
            val intent = Intent(activity, MensActivity::class.java)
            startActivity(intent)
        }

    }
    private fun addDataToList(){
        layananList.add(dataLayanan(R.drawable.rentang1))
        layananList.add(dataLayanan(R.drawable.rentang_2))
        layananList.add(dataLayanan(R.drawable.rentang_3))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

