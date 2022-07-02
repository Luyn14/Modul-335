package com.example.myproject.ui


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myproject.db.BilanzDatabase
import com.example.myproject.model.Wallet
import com.example.myproject.model.WalletWithActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WalletOverviewViewViewModel(application : Application) : AndroidViewModel( application ) {

    private var walletDao = BilanzDatabase.getInstance(application.applicationContext).walletDao()

    var liveDataWallet: MutableLiveData<WalletWithActivity> = MutableLiveData()

    fun setWalletWithActivity(walletWithActivity: WalletWithActivity?) {

        if (walletWithActivity != null) {

            liveDataWallet.value = walletWithActivity

        } else {


            var wallet = Wallet(0, "",0)

            var activitys = mutableListOf<com.example.myproject.model.Activity>()

                var activity = com.example.myproject.model.Activity(0, 0, "initalise", 0)

                activitys.add(activity)

            liveDataWallet.value = WalletWithActivity(wallet, activitys)
        }
    }

    fun onSaveQuestionClick(): Boolean {
        val isValid = validateEntry()

        if (isValid) {
            CoroutineScope(Dispatchers.IO).launch {
                if (liveDataWallet.value!!.walletObj.id.compareTo(0) == 0) {

                    val walletId =
                        walletDao.insertWallet(liveDataWallet.value!!.walletObj)

                    for (activity in liveDataWallet.value!!.activityList) {
                        activity.walletId = walletId
                    }


                    walletDao.insertActivity(liveDataWallet.value!!.activityList)

                }



            }

        }

        return isValid
    }

    fun setWalletName(name: String) {
        this.liveDataWallet.value?.walletObj?.name = name
    }

    fun setActivityName(index: Int, name: String) {
        this.liveDataWallet.value?.activityList?.get(index)?.name = name
    }

    fun setActivityValue(index: Int, value: Long) {
        this.liveDataWallet.value?.activityList?.get(index)?.value = value
    }



    private fun validateEntry(): Boolean {
        var valid = true

        return valid
    }




}


