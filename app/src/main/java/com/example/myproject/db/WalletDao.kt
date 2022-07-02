package com.example.myproject.db

import androidx.room.*
import com.example.myproject.model.Activity
import com.example.myproject.model.Wallet
import com.example.myproject.model.WalletWithActivity

@Dao
interface WalletDao {

    @Query("Select * From wallet")
    fun getAll(): List<Wallet>

    @Insert
    fun insertWallet( wallet: Wallet): Long

    @Update
    fun updateWallet( wallet: Wallet)

    @Delete
    fun deleteWallet( wallet: Wallet)

    @Insert
    fun insertActivity( activity: List<Activity>)

    @Update
    fun updateActivity( activity: List<Activity>)

    @Delete
    fun deleteActivity( activity: List<Activity>)

    @Transaction
    @Query( "Select * From wallet")
    fun getWalletWithActivitys(): List<WalletWithActivity>
}