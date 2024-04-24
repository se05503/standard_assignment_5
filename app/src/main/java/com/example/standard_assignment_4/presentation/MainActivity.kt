package com.example.standard_assignment_4.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val cardList = DataSource.getDataSource().getCardList() // 데이터 받아오기
        multiCardAdapter.cardList = cardList // 어댑터에 정의한 빈 데이터와 연결

        with(binding.recyclerView) {
            adapter = multiCardAdapter // 어댑터 연결
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun adapterOnClick(card:Card) {
        // bundle로 넘기는 작업
        // item 을 눌렀을 때 이벤트 생성
        val intent = Intent(this, DetailActivity::class.java)
        val bundle = Bundle().apply {
            // bundle 에다가 data class 를 parcelize로 넣기
            putParcelable(DetailActivity.EXTRA_CARD,card)
        }
        intent.putExtras(bundle) // intent 의 putExtra 가 아닌 putExtras 를 쓰면 key 값을 쓰지 않아도 된다.
        startActivity(intent)
    }
}