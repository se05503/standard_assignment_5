package com.example.standard_assignment_4.data

class DataSource {
    companion object {
        private var INSTANCE: DataSource? = null
        fun getDataSource(): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    fun getCardList(): List<Card> {
        return cardList()
    }

//    fun getCardForId(id:Long):Card {
//        cardList().let { cards ->
//            return cards.first{it.id == id}
//        }
//    }
}