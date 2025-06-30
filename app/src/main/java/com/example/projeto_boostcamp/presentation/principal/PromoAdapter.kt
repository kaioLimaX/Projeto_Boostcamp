package com.example.projeto_boostcamp.presentation.principal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.projeto_boostcamp.R
import com.example.projeto_boostcamp.databinding.PromoViewBinding

class PromoAdapter : RecyclerView.Adapter<PromoAdapter.PromoViewHolder>() {

    private var listaPromo = mutableListOf(
        R.drawable.promo1,
        R.drawable.promo2,
        R.drawable.promo3,
        R.drawable.promo4
    )

    inner class PromoViewHolder (
        val binding: PromoViewBinding
    ) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itemView = PromoViewBinding.inflate(
            layoutInflater, parent, false
        )

        return PromoViewHolder( itemView )
    }

    override fun getItemCount(): Int {
        return listaPromo.size
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        val imagem = listaPromo[position]
        holder.binding.imageView.setImageResource(imagem)
    }
}