package com.example.myproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.databinding.FragmentWalletBinding
import com.example.myproject.model.Activity
import com.example.myproject.model.WalletWithActivity

class ActivityAdapter( private val listener: onItemClickListener) : ListAdapter<WalletWithActivity, ActivityAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityAdapter.ViewHolder {

        val binding = FragmentWalletBinding.inflate( LayoutInflater.from(parent.context) )

        return ViewHolder( binding )
    }

    override fun onBindViewHolder(holder: ActivityAdapter.ViewHolder, position: Int) {
        val wallet = getItem(position)

        holder.textViewQuestion.text = wallet.walletObj.name
        holder.onClick( getItem( holder.adapterPosition), listener )
    }


    class ViewHolder( val binding: FragmentWalletBinding ) : RecyclerView.ViewHolder( binding.root ) {

        val textViewQuestion: TextView

        init {
            textViewQuestion = binding.walletView
        }
        fun onClick( question: WalletWithActivity, listener: onItemClickListener) {
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {

                    listener.onItemClick( question )
                }
            }
        }
    }
    interface onItemClickListener {
        fun onItemClick( question: WalletWithActivity )
    }

    object DiffCallback : DiffUtil.ItemCallback<WalletWithActivity>() {
        override fun areItemsTheSame(
            oldItem: WalletWithActivity,
            newItem: WalletWithActivity
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: WalletWithActivity,
            newItem: WalletWithActivity
        ): Boolean {
            return oldItem.walletObj.id == newItem.walletObj.id
        }
    }
}