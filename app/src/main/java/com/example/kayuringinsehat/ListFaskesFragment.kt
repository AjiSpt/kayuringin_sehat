package com.example.kayuringinsehat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kayuringinsehat.databinding.FragmentListFaskesBinding

class ListFaskesFragment : Fragment() {
    private var _binding: FragmentListFaskesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListFaskesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentListFaskesBinding.bind(view)

        binding.cvRumahsakit.setOnClickListener {
            val intent = Intent(activity, FaskesTersediaActivity::class.java)
            startActivity(intent)
        }

        binding.cvPuskesmas.setOnClickListener {
            val intent = Intent(activity, FaskesTersedia2Activity::class.java)
            startActivity(intent)
        }

        binding.cvKlinik.setOnClickListener {
            val intent = Intent(activity, FaskesTersedia3Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
