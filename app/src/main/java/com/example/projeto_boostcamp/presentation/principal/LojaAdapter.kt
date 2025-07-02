package com.example.projeto_boostcamp.presentation.principal

import com.example.projeto_boostcamp.databinding.LojasViewBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.projeto_boostcamp.R

class LojaAdapter(
    private val clique: (Loja) -> Unit
) : RecyclerView.Adapter<LojaAdapter.LojaViewHolder>() {

    private var listaLoja = mutableListOf(
        Loja("China In Box", R.drawable.loja_1),
        Loja("Osnir Hamburguer", R.drawable.loja_2),
        Loja("Galeto's", R.drawable.loja_3),
        Loja("Mineiro Delivery's", R.drawable.loja_4),
        Loja("Pizza Hut", R.drawable.loja_5),
        Loja("KFC", R.drawable.loja_6)
    )

    inner class LojaViewHolder (
        val binding: LojasViewBinding
    ) : ViewHolder(binding.root) {

        fun bind(loja: Loja){
            with(binding){
                imgLoja.setImageResource(loja.imagem)
                textNomeLoja.text = loja.nome

                main.setOnClickListener {
                    clique(loja)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LojaViewHolder {
        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itemView = LojasViewBinding.inflate(
            layoutInflater, parent, false
        )

        return LojaViewHolder( itemView )
    }

    override fun getItemCount(): Int {
        return listaLoja.size
    }

    override fun onBindViewHolder(holder: LojaViewHolder, position: Int) {
        val loja = listaLoja[position]
        holder.bind(loja)
    }
}