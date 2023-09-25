package com.example.kayuringinsehat.adaptorRV

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.kayuringinsehat.R
import com.example.kayuringinsehat.data.dataLayanan

class layananAdaptor(private val layananList: List<dataLayanan>) :
    RecyclerView.Adapter<layananAdaptor.LayananViewHolder>() {

    class LayananViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val gambarLayanan: ImageView = itemView.findViewById(R.id.rentang_ImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LayananViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_info, parent, false)
        return LayananViewHolder(view)
    }

    override fun onBindViewHolder(holder: LayananViewHolder, position: Int) {
        val layanan = layananList[position]
        holder.gambarLayanan.setImageResource(layanan.gambar)
    }

    override fun getItemCount(): Int {
        return layananList.size
    }
}