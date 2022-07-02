package com.example.myproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myproject.model.Activity
import com.example.myproject.model.Wallet
import com.example.myproject.db.WalletDao


@Database (entities = [Wallet::class, Activity::class], version = 2 )
abstract class BilanzDatabase : RoomDatabase() {
    abstract fun walletDao(): WalletDao

    companion object {

        @Volatile private var  instance: BilanzDatabase? = null

        fun getInstance( context: Context): BilanzDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder( context, BilanzDatabase::class.java, "bilanz" ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }
    }
}


