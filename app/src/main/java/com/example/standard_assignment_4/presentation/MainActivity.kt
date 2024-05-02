package com.example.standard_assignment_4.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard_assignment_4.R
import com.example.standard_assignment_4.data.Card
import com.example.standard_assignment_4.data.DataSource
import com.example.standard_assignment_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val multiCardAdapter : MultiCardAdapter by lazy {
        MultiCardAdapter { card ->
            adapterOnClick(card)
        }
    }

    private val cardViewModel by viewModels<CardViewModel> {
        CardViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val cardList = cardViewModel.cardLiveData
        multiCardAdapter.cardList = cardList

        with(binding.recyclerView) {
            adapter = multiCardAdapter // 어댑터 연결
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun adapterOnClick(card:Card) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_CARD,card.id)
        startActivity(intent)
    }
}