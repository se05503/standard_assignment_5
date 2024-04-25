package com.example.standard_assignment_4.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.standard_assignment_4.data.DataSource

// Activity에서 ViewModel을 사용할 수 있게 됨
class CardViewModel(val dataSource: DataSource):ViewModel() {
    // 데이터 처리하는 비지니스 로직
    val cardLiveData = dataSource.getCardList()
}

//viewModel provider factory
class CardViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // 어떤 ViewModel이 와도 generic한 type으로 받음, 어떤 datatype이든 와라.
        if(modelClass.isAssignableFrom(CardViewModel::class.java)) {
            // CardViewModel이 유효한가?
            return CardViewModel(dataSource = DataSource.getDataSource()) as T
        } else {
            //유효하지 않은 경우
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}