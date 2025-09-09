package com.example.projeto_boostcamp.presentation.detalhes_restaurantes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_boostcamp.databinding.PromoViewBinding

class Itens_restarantsAdapter(
    private val list: List <String>
):RecyclerView.Adapter<Itens_restaurantesAdapter.PromoViewHolder>() {


    private val textName: TextView

    init {
        textName = itemView.findViemById(R.id.text_name)
    }
    }

    inner class RecyclerView(
        val itensView: Itens_restarantsAdapter.RecyclerView
    ) : androidx.recyclerview.widget.RecyclerView.ViewHolder



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {

        val binding = PromoViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )


        return PromoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {

        val nome = list[position]
        holder.binding.textName.text = name
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(binding.root) (
        val binding: PromoViewBinding
    ): RecyclerView.ViewHolder(binding.root)
}

}
