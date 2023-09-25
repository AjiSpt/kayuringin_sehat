package com.example.kayuringinsehat.adaptorRV

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.kayuringinsehat.R
import com.example.kayuringinsehat.data.dataFaskesTersedia

class faskesTersediaAdapter (private val faskesTersediaList: List<dataFaskesTersedia> ) :
    RecyclerView.Adapter<faskesTersediaAdapter.FaskesTersediaViewHolder>(){

    class FaskesTersediaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val gambarFaskes: ImageView = itemView.findViewById(R.id.rv_faskesTersedia)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaskesTersediaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_faskestersedia, parent, false)
        return FaskesTersediaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FaskesTersediaViewHolder, position: Int) {
        val faskesTersedia = faskesTersediaList[position]
        holder.gambarFaskes.setImageResource(faskesTersedia.gambar)
    }

    override fun getItemCount(): Int {
        return faskesTersediaList.size
    }
}