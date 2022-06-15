package com.example.retrofiinkotlin.viewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofiinkotlin.R
import com.example.retrofiinkotlin.network.RickAndMortyList.CharacterData

//B6: khởi tạo Adapter
class RecycleViewAdapter: PagingDataAdapter<CharacterData, RecycleViewAdapter.MyViewHolder>(DiffUtilCallBack()) {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_view,parent,false)

        return MyViewHolder(inflater)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imgRow: ImageView = view.findViewById(R.id.imgRow)
        val tvTitleRow: TextView = view.findViewById(R.id.tvTitleRow)
        val tvSubTitleRow: TextView = view.findViewById(R.id.tvSubTitle)
        fun bind(data: CharacterData?){
            tvTitleRow.text = data?.name
            tvSubTitleRow.text = data?.name
            Glide.with(imgRow)
                .load(data?.image)
                .circleCrop()
                .into(imgRow)
        }
    }
    class DiffUtilCallBack : DiffUtil.ItemCallback<CharacterData>() {
        override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name &&
                    oldItem.species == newItem.species
        }
    }

}