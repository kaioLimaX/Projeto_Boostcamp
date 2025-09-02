package com.example.projeto_boostcamp.presentation.detalhes_produto

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_boostcamp.R

class DetalheEProdutosAdapter :
    RecyclerView.Adapter<DetalheEProdutosAdapter.DetalheProdutosViewHolder>() {

    private var listaProdutosEDetalhes = listOf<DetalheProdutos>()

    @SuppressLint("NotifyDataSetChanged")
    fun configurarLista(lista: List<DetalheProdutos>) {
        listaProdutosEDetalhes = lista
        notifyDataSetChanged()
    }

    inner class DetalheProdutosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var view: View = itemView
        private var textTituloProduto: TextView = view.findViewById(R.id.text_titulo_produto)
        private var textPrecoProduto: TextView = view.findViewById(R.id.text_preco_produto)
        private var textQuantidadeProduto: TextView =
            view.findViewById(R.id.text_quantidade_produto)
        private var imgProduto: ImageView = view.findViewById(R.id.image_detalhe_produto)

        fun bind(detalheProdutos: DetalheProdutos) {
            textTituloProduto.text = detalheProdutos.tituloProduto
            textPrecoProduto.text = detalheProdutos.precoProduto
            textQuantidadeProduto.text = detalheProdutos.quantidadeProduto
            imgProduto.setImageDrawable(
                ContextCompat.getDrawable(view.context, detalheProdutos.imagemProduto)
            )
        }
    }

    //Segundo Metodo
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetalheProdutosViewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_detalhe_produto, parent, false)
        return DetalheProdutosViewHolder(view)
    }

    //Terceiro Metodo
    override fun onBindViewHolder(
        holder: DetalheProdutosViewHolder,
        position: Int
    ) {
        val detalheProduto = listaProdutosEDetalhes[position]
        holder.bind(detalheProduto)

    }

    //Primeiro Metodo
    override fun getItemCount(): Int {
        return listaProdutosEDetalhes.size
    }


}