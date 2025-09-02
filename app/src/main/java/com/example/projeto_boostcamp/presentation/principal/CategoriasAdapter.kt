package com.example.projeto_boostcamp.presentation.principal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.projeto_boostcamp.R
import com.example.projeto_boostcamp.databinding.ItemCategoriaBinding
import com.example.projeto_boostcamp.databinding.LojasViewBinding

class CategoriasAdapter(
    private val clique: (Categoria) -> Unit
) : RecyclerView.Adapter<CategoriasAdapter.CategoriasViewHolder>() {

    private var listaLoja = mutableListOf(
        Categoria("Restaurantes", R.drawable.comida_2),
        Categoria("Mercado", R.drawable.mercado_1),
        Categoria("Bebidas", R.drawable.bebida_1),
        Categoria("Farmacia", R.drawable.farmacia),
        Categoria("Express", R.drawable.express),
        Categoria("Pet", R.drawable.pet_1),
        Categoria("Shopping", R.drawable.comida_1),
        Categoria("Gourmet", R.drawable.comida_2),
        Categoria("Essenciais", R.drawable.macarrao),
        Categoria("Caseiros", R.drawable.yakisoba_bowl),
    )

    inner class CategoriasViewHolder (
        val binding: ItemCategoriaBinding
    ) : ViewHolder(binding.root) {

        fun bind(categoria: Categoria){
            with(binding){
                imgCategoria.setImageResource(categoria.imagem)
                txtCategoria.text = categoria.nome
                itemView.setOnClickListener {
                    clique(categoria)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriasViewHolder {
        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itemView = ItemCategoriaBinding.inflate(
            layoutInflater, parent, false
        )

        return CategoriasViewHolder( itemView )
    }

    override fun onBindViewHolder(holder: CategoriasViewHolder, position: Int) {
        val loja = listaLoja[position]
        holder.bind(loja)
    }

    override fun getItemCount(): Int {
        return listaLoja.size
    }
}