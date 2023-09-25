package com.example.kayuringinsehat.adaptorRV

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.kayuringinsehat.R
import com.example.kayuringinsehat.data.dataTanya

class tanyaAdaptor (private val tanyaList: List<dataTanya>) :
    RecyclerView.Adapter<tanyaAdaptor.TanyaViewHolder>() {

    class TanyaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val gambarTanya: ImageView = itemView.findViewById(R.id.rv_tanyaInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TanyaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_tanya, parent, false)
        return TanyaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TanyaViewHolder, position: Int) {
        val tanya = tanyaList[position]
        holder.gambarTanya.setImageResource(tanya.gambar)
    }

    override fun getItemCount(): Int {
        return tanyaList.size
    }
}