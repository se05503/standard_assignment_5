package com.example.standard_assignment_4.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.standard_assignment_4.R
import com.example.standard_assignment_4.data.Card
import com.example.standard_assignment_4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CARD : String = "extra_card"
    }

    private val cardViewModel by viewModels<CardViewModel> {
        CardViewModelFactory()
    }

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = intent
        val cardId = intent.extras?.getLong(EXTRA_CARD) ?:0
        val cardItem = cardViewModel.getCardForId(cardId)
//        val cardItem = intent.getParcelableExtra<Card>(EXTRA_CARD)
        binding.detailTvName.text = cardItem?.userName
        binding.detailTvPrice.text = cardItem?.balance.toString()
        binding.detailTvExpire.text = cardItem?.period
        binding.detailTvCardNum.text = cardItem?.cardNumber
    }
}
