package com.example.myfirstapplication.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Wallet (
    @PrimaryKey (autoGenerate = true) var id: Long,
    var name: String,
    var value: Long
) : Parcelable{
}