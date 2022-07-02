package com.example.myproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject.databinding.FragmentActivityFragmentBinding
import com.example.myproject.model.WalletWithActivity
import com.example.myproject.ui.ActivityAdapter
import com.example.myproject.ui.WalletDetailViewViewModel


class Activity_Overview : Fragment(), ActivityAdapter.onItemClickListener {

    private lateinit var binding: FragmentActivityFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModelOverview: WalletDetailViewViewModel by viewModels()
        binding = FragmentActivityFragmentBinding.inflate( inflater )
        val adapter = ActivityAdapter( this )

        binding.apply {
            recyclerViewActivity.adapter = adapter
            recyclerViewActivity.layoutManager = LinearLayoutManager( requireContext() )
            recyclerViewActivity.setHasFixedSize( true )


        }

        viewModelOverview.getActivity().observe( viewLifecycleOwner) { questions ->
            adapter.submitList( questions )
        }

        return binding.root
    }

    override fun onItemClick(question: WalletWithActivity) {

    }


}