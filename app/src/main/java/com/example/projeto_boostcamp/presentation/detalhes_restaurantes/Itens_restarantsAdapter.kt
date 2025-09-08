package com.example.projeto_boostcamp.presentation.detalhes_restaurantes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_boostcamp.databinding.PromoViewBinding

class Itens_restarantsAdapter(
    private val list: List <String>
): RecyclerView.Adapter<>() {


    private val textName: TextView

    init {
        textName = itemView.findViemById(R.id.text_name)
    }
    }

    inner class RecyclerView(
        val itensView: Itens_restarantsAdapter.RecyclerView
    ) : androidx.recyclerview.widget.RecyclerView.ViewHolder



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ERROR {

        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itensView = layoutInflater.inflate(
            R.layout.item_restaurants,parent,false
        )


        return Itens_restarantsAdapter(itensView)
    }

    override fun onBindViewHolder(holder: ERROR, position: Int) {

        val nome = list[position]
        mensagemViewholder.textName.text = name
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class PromoViewHolder (
        val binding: PromoViewBinding

}
