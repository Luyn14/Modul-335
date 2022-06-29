package com.example.myproject.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import com.example.myfirstapplication.model.Activity
import com.example.myfirstapplication.model.Wallet
import com.example.myproject.Wallet_View
import kotlinx.android.parcel.Parcelize

@Parcelize
class WalletWithActivity (
    @Embedded var walletObj: Wallet,
    @Relation(
        parentColumn = "id",
        entityColumn = "questionId")

    var activityList: List<Activity>
    ) : Parcelable {

    }