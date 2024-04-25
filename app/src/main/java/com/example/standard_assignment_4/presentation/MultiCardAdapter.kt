package com.example.standard_assignment_4.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_assignment_4.data.Card
import com.example.standard_assignment_4.databinding.ItemBlueCardBinding
import com.example.standard_assignment_4.databinding.ItemLightBlueCardBinding
import com.example.standard_assignment_4.databinding.ItemOrangeCardBinding
import java.lang.IllegalArgumentException

class MultiCardAdapter(private val onClick: (Card) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var cardList = listOf<Card>()

    // inner로 선언 → nested class로 변경
    // item layout의 ui값 뿌려주기
    class BlueTypeViewHolder(private val binding: ItemBlueCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                tvUserName.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
            }
        }
    }

    // 수정 후
    class LightBlueTypeViewHolder(private val binding: ItemLightBlueCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                tvUserName.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
            }
        }
    }

    class OrangeTypeViewHolder(private val binding: ItemOrangeCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                tvUserName.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            MultiViewEnum.BLUE.viewType -> {
                val binding = ItemBlueCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                BlueTypeViewHolder(binding)
            }
            MultiViewEnum.LIGHTBLUE.viewType -> {
                val binding = ItemLightBlueCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                LightBlueTypeViewHolder(binding)
            }
            MultiViewEnum.ORANGE.viewType -> {
                val binding = ItemOrangeCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                OrangeTypeViewHolder(binding)
            }
            else -> {
                throw IllegalArgumentException("Invalid view type")
            }
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // click 이벤트 처리를 해당 함수 안에서 해줌
        val currentItem = cardList[position]
        when(holder.itemViewType) {
            MultiViewEnum.BLUE.viewType -> {
                val blueHolder = holder as BlueTypeViewHolder
                blueHolder.bind(currentItem)
                holder.itemView.setOnClickListener {// 질문: 여기서는 왜 blueHolder.itemView. 이런 식으로 안쓰나요?
                    onClick(currentItem)
                }
            }
            MultiViewEnum.LIGHTBLUE.viewType -> {
                val lightblueHolder = holder as LightBlueTypeViewHolder
                lightblueHolder.bind(currentItem)
                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
            MultiViewEnum.ORANGE.viewType -> {
                val orangeHolder = holder as OrangeTypeViewHolder
                orangeHolder.bind(currentItem)
                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
        }
    }

    // multi view type 을 쓰는 경우 필요하다
    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> MultiViewEnum.BLUE.viewType
            1 -> MultiViewEnum.LIGHTBLUE.viewType
            2 -> MultiViewEnum.ORANGE.viewType
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}