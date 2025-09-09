package com.example.projeto_boostcamp.presentation.confirmacao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_boostcamp.R

class ConfirmationAdapter(
    private val listaConfirmation: MutableList<ConfirmationDataClass>
) : RecyclerView.Adapter<ConfirmationAdapter.ConfirmationViewHolder>()
{
    //Ao criar o View Holder -> criar a visualização
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ConfirmationViewHolder
    {
        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itemView = layoutInflater.inflate(
            R.layout.item_lista_confirmation, parent, false
        )

        return ConfirmationViewHolder( itemView )
    }

    // ao vincular o view holder
    override fun onBindViewHolder(
        holder: ConfirmationViewHolder,
        position: Int
    )
    {
        val confirmationProduto = listaConfirmation[position]
        holder.bind(confirmationProduto)

    }

    //getItemCount -> Recuperar a quantidade de itens
    override fun getItemCount(): Int
    {
        return listaConfirmation.size
    }

    inner class ConfirmationViewHolder(
        val itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private var view: View = itemView
        val txtNomeItem: TextView = itemView.findViewById( R.id.text_titulo_confirmation_item)
        val txtPrecoItem: TextView = itemView.findViewById( R.id.text_preco_confirmation_item)
        val imgItem: ImageView = view.findViewById(R.id.image_confirmation_item)

        fun bind ( confirmationItens : ConfirmationDataClass ) {
            txtNomeItem.text = confirmationItens.titulo
            txtPrecoItem.text = confirmationItens.preco
            imgItem.setImageDrawable(
                ContextCompat.getDrawable(view.context,
                    confirmationItens.imagem)
            )
        }

    }
}