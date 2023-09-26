package com.example.kayuringinsehat.adaptorRV

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.kayuringinsehat.R
import com.example.kayuringinsehat.data.dataFaskesTersedia3

class faskesTersediaAdapter3 (private val faskesTersedia3List: List<dataFaskesTersedia3> ) :
    RecyclerView.Adapter<faskesTersediaAdapter3.FaskesTersedia3ViewHolder>(){

    class FaskesTersedia3ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val gambarFaskes: ImageView = itemView.findViewById(R.id.rv_faskesTersedia3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaskesTersedia3ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_faskestersedia3, parent, false)
        return FaskesTersedia3ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FaskesTersedia3ViewHolder, position: Int) {
        val faskesTersedia3 = faskesTersedia3List[position]
        holder.gambarFaskes.setImageResource(faskesTersedia3.gambar)
    }

    override fun getItemCount(): Int {
        return faskesTersedia3List.size
    }
}