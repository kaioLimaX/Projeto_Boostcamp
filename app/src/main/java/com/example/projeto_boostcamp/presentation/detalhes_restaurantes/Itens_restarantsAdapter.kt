package com.example.projeto_boostcamp.presentation.detalhes_restaurantes


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.projeto_boostcamp.R
import com.example.projeto_boostcamp.databinding.PromoViewBinding

class Itens_restarantsAdapter(
    private val list: List <Produto>,
    private val onItemClick: (Produto) -> Unit
): Adapter<Itens_restarantsAdapter.ItensViewHolder>() {


    inner class ItensViewHolder(
        val itensView: View
    ) : RecyclerView.ViewHolder(itensView){

        val imagem: ImageView = itemView.findViewById(R.id.iv_comida)
        val titulo: TextView = itemView.findViewById(R.id.text_nome_do_prato)
        val descricao: TextView = itemView.findViewById(R.id.text_descricao)
        val preco: TextView = itemView.findViewById(R.id.text_preco)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItensViewHolder {

        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itemView = layoutInflater.inflate(
            R.layout.item_restaurants, parent, false
        )

        return ItensViewHolder( itemView )
    }

    override fun onBindViewHolder(
        holder: ItensViewHolder,
        position: Int
    ) {
        holder.itemView.setOnClickListener {
            onItemClick(list[position])
        }
        val produto = list[position]
        holder.titulo.text = produto.titulo
        holder.imagem.setImageResource(produto.imagem)
        holder.descricao.text = produto.descricao
        holder.preco.text = produto.preco
    }


    override fun getItemCount(): Int {
        return list.size
    }



}
