package com.example.myproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.example.myproject.databinding.FragmentWalletBinding
import com.example.myproject.model.WalletWithActivity
import com.example.myproject.ui.WalletOverviewViewViewModel
import com.google.android.material.snackbar.Snackbar

class Wallet_View : Fragment() {

    val viewModelOverview:WalletOverviewViewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentWalletBinding.inflate( inflater )

        val wallet : WalletWithActivity? = arguments?.get( "wallet" ) as WalletWithActivity?

        viewModelOverview.setWalletWithActivity( wallet )

        viewModelOverview.liveDataWallet.observe(viewLifecycleOwner) { walletWithActivity ->
            binding.apply {
                eingabeName.addTextChangedListener {
                    viewModelOverview.setActivityName( 0, it.toString())
                }
                eingabeWert.addTextChangedListener {
                    viewModelOverview.setActivityValue( 0, it.toString().toLong())
                }
            }
        }

        binding.apply {
            buttonTranscation.setOnClickListener {
                val saved = viewModelOverview.onSaveQuestionClick()

                if (saved) {

                } else {
                    Snackbar.make(requireView(), "Fields invalid", Snackbar.LENGTH_SHORT).show()
                }
            }

        }
        return binding.root
    }

}