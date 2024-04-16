package com.example.standard_assignment_4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard_assignment_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val dataList = mutableListOf<CardItem>()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        addData() // 데이터 초기화
        val adapter = CardAdapter(dataList,this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object: CardAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                val bundle = Bundle().apply { putParcelable("bundle",dataList[position])} // Fragment의 getInstance 함수 참고
                intent.putExtra("intent",bundle)
                startActivity(intent)
            }
        }
    }

    private fun addData() {
        dataList.add(CardItem("Anderson", "2423 3581 9503", "21 / 24",3100.3))
        dataList.add(CardItem("Katy", "1233 1981 6892", "12 / 25", 2499.8))
        dataList.add(CardItem("Mille", "9182 9138 3849", "19 / 19", 1381.7))
    }
}