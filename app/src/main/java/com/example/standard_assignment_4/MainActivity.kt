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

/*
[느낀점]
- button 커스텀화 + svg 이미지 사용으로 수정하기
- marginStart랑 marginLeft의 차이?
- 뭔가 padding 보다 margin 주는게 더 나은 것 같음(각 뷰위젯마다 margin 주다가 갑자기 한 위젯 padding 주니까 거리 개념이 깨짐)
- layout_width, height 설정 방식이 어려워보인다
- 디버그랑 로그캣 차이?
[트러블 슈팅 해결과정]
1. Adapter에서 color값 가져오기 → 해당코드 참고
2. 리사이클러뷰 마지막 레이아웃 짤려보임 → 에뮬레이터를 최신식으로 바꿔줘서 해결
- 질문 : 카드의 레이아웃 양식이 동일한데 왜 recyclerView가 아닌 multi-recyclerView를 사용하는건가요?
 */

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
        dataList.add(CardItem("Anderson", "2423 3581 9503", "21 / 24","$3,100.30"))
        dataList.add(CardItem("Katy", "1233 1981 6892", "12 / 25", "$2,499.80"))
        dataList.add(CardItem("Mille", "9182 9138 3849", "19 / 19", "$1,381.70"))
    }
}