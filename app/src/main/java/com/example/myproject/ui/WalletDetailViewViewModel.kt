package com.example.myproject.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myproject.db.BilanzDatabase
import com.example.myproject.model.Wallet
import com.example.myproject.model.WalletWithActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WalletDetailViewViewModel (application: Application) : AndroidViewModel(application) {

    private var walletDao = BilanzDatabase.getInstance(application.applicationContext ).walletDao()

    private var liveDataWallet: MutableLiveData<List<WalletWithActivity>> = MutableLiveData()

    fun getActivity() : LiveData<List<WalletWithActivity>> {
        if ( liveDataWallet.value == null ) {
            CoroutineScope(Dispatchers.IO).launch{
                liveDataWallet.postValue( walletDao.getWalletWithActivitys() )
            }
        }

        return liveDataWallet
    }
}