package com.example.standard_assignment_4.extension

import android.app.Activity

// 스스로 작성 시도해보고 안되면 코드 참고하기
/*
val intent = intent
val cardId = intent.extras?.getLong(EXTRA_CARD) ?:0
 */

// 지금 이해 안해도 됨
//inline fun <reified T:Any> Activity.extraNotNull(key:String) {
//    val value =intent.extras?.getLong(key)
//}

inline fun <reified T: Any> Activity.extraNotNull(key:String, default:T ?= null) = lazy {
    val value = intent?.extras?.getLong(key)
    requireNotNull(if(value is T) value else default){key}
}
