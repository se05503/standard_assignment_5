package com.example.standard_assignment_4

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_assignment_4.databinding.CardLayoutBinding

class CustomAdapter(private val dataList: MutableList<Item>):RecyclerView.Adapter<CustomAdapter.Holder>(){

    inner class Holder(binding:CardLayoutBinding):RecyclerView.ViewHolder(binding.root) {
        val name = binding.tvName
        val cardNum = binding.tvCardNum
        val expire = binding.tvExpireDate
        val price = binding.tvBalanceNum
        val layout = binding.constraintLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,
            false)
        return Holder(binding)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        // 전체 데이터에 대해서 매번 실행
        holder.name.text = dataList[position].name
        holder.cardNum.text = dataList[position].cardNum
        holder.expire.text = dataList[position].expire
        holder.price.text = dataList[position].price
        holder.layout.setBackgroundColor(dataList[position].color)
    }
}