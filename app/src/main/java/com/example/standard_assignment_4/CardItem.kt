package com.example.standard_assignment_4

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardItem(
    val name: String,
    val cardNum: String,
    val expire: String,
    val price: String,
//    val color: Int
):Parcelable
