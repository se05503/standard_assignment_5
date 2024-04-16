package com.example.standard_assignment_4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.standard_assignment_4.databinding.CardItem1Binding
import com.example.standard_assignment_4.databinding.CardItem2Binding
import com.example.standard_assignment_4.databinding.CardItem3Binding

class CardAdapter(private val dataList: MutableList<CardItem>, private val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {

    companion object {
        private const val CARD_ITEM_1 = 0
        private const val CARD_ITEM_2 = 1
        private const val CARD_ITEM_3 = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> CARD_ITEM_1
            1 -> CARD_ITEM_2
            else -> CARD_ITEM_3
        }
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    inner class CardItemOneHolder(binding: CardItem1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        val name = binding.tvName
        val cardNum = binding.tvCardNum
        val expire = binding.tvExpireDate
        val price = binding.tvBalanceNum
    }

    inner class CardItemTwoHolder(binding: CardItem2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        val name = binding.tvName
        val cardNum = binding.tvCardNum
        val expire = binding.tvExpireDate
        val price = binding.tvBalanceNum
    }

    inner class CardItemThreeHolder(binding: CardItem3Binding) :
        RecyclerView.ViewHolder(binding.root) {
        val name = binding.tvName
        val cardNum = binding.tvCardNum
        val expire = binding.tvExpireDate
        val price = binding.tvBalanceNum
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            CARD_ITEM_1 -> {
                val binding = CardItem1Binding.inflate(inflater,parent,false)
                CardItemOneHolder(binding)
            }
            CARD_ITEM_2 -> {
                val binding = CardItem2Binding.inflate(inflater,parent,false)
                CardItemTwoHolder(binding)
            }
            else -> {
                // CARD_ITEM_3
                val binding = CardItem3Binding.inflate(inflater,parent,false)
                CardItemThreeHolder(binding)
            }
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        when(position) {
            0 -> {
                (holder as CardItemOneHolder).name.text = dataList[position].name
                holder.cardNum.text = dataList[position].cardNum
                holder.expire.text = dataList[position].expire
                holder.price.text = dataList[position].price
            }
            1 -> {
                (holder as CardItemTwoHolder).name.text = dataList[position].name
                holder.cardNum.text = dataList[position].cardNum
                holder.expire.text = dataList[position].expire
                holder.price.text = dataList[position].price
            }
            2 -> {
                (holder as CardItemThreeHolder).name.text = dataList[position].name
                holder.cardNum.text = dataList[position].cardNum
                holder.expire.text = dataList[position].expire
                holder.price.text = dataList[position].price
            }
        }
    }
}