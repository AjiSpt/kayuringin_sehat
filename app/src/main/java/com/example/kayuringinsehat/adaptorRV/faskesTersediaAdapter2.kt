package com.example.kayuringinsehat.adaptorRV

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.kayuringinsehat.R
import com.example.kayuringinsehat.data.dataFaskesTersedia2

class faskesTersediaAdapter2 (private val faskesTersedia2List: List<dataFaskesTersedia2> ) :
    RecyclerView.Adapter<faskesTersediaAdapter2.FaskesTersedia2ViewHolder>(){

    class FaskesTersedia2ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val gambarFaskes: ImageView = itemView.findViewById(R.id.rv_faskesTersedia2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaskesTersedia2ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_faskestersedia2, parent, false)
        return FaskesTersedia2ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FaskesTersedia2ViewHolder, position: Int) {
        val faskesTersedia2 = faskesTersedia2List[position]
        holder.gambarFaskes.setImageResource(faskesTersedia2.gambar)
    }

    override fun getItemCount(): Int {
        return faskesTersedia2List.size
    }
}