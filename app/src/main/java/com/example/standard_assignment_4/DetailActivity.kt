package com.example.standard_assignment_4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.standard_assignment_4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    private var item: Item? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bundle = intent.getBundleExtra("intent") // intent에서 bundle 꺼내오기
        item = bundle?.getParcelable("bundle",Item::class.java) // bundle에서 data class 꺼내오기
        binding.detailTvName.text = "이름: ${item?.name}"
        binding.detailTvCardNum.text="카드 번호: ${item?.cardNum}"
        binding.detailTvExpire.text="유효기간: ${item?.expire}"
        binding.detailTvPrice.text="가격: ${item?.price}"
    }
}