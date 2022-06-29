package com.example.myproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myproject.R
import com.example.myproject.databinding.FragmentIntroFragmentBinding


class IntroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentIntroFragmentBinding.inflate(inflater)

        binding.buttonWallet.setOnClickListener { view ->
            Navigation.findNavController( view ).navigate(R.id.action_introFragment_to_wallet_View2)
        }

        binding.buttonHistory.setOnClickListener { view ->
            Navigation.findNavController( view ).navigate(R.id.action_introFragment_to_activity_Overview2)
        }

        binding.apply {
            titelView.text = "Hallo Welt"
        }

        return binding.root


    }
}