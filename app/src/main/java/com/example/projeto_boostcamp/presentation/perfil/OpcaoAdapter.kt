package com.example.projeto_boostcamp.presentation.perfil

import com.example.projeto_boostcamp.databinding.OpcoesViewBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.projeto_boostcamp.R

class OpcaoAdapter(
    private val clique: (Opcao) -> Unit
) : RecyclerView.Adapter<OpcaoAdapter.OpcaoViewHolder>() {

    private var listaOpcao = mutableListOf(
        Opcao(R.drawable.icon_mensagem, "Conversas", "Meu histórico de conversas","4"),
        Opcao(R.drawable.icon_notification, "Notificação", "Minha central de notificações"),
        Opcao(R.drawable.icon_dadosdaconta, "Dados da conta", "Minhas informações da conta"),
        Opcao(R.drawable.ic_cartao_24, "Pagamentos", "Meus saldos e cartôes"),
        Opcao(R.drawable.icon_diamante, "Clube iFood", "Meus benefícios exclusivos"),
        Opcao(R.drawable.icon_cupom, "Cupons", "Meus cupons de desconto"),
        Opcao(R.drawable.icon_senha, "Código de entrega", "Edite seu código de entrega", "NOVO!"),
        Opcao(R.drawable.icon_favorito, "Favoritos", "Meus locais favoritos"),
        Opcao(R.drawable.icon_endereco, "Endereços", "Meus endereços de entrega")
    )

    inner class OpcaoViewHolder (
        val binding: OpcoesViewBinding
    ) : ViewHolder(binding.root) {

        fun bind(opcao: Opcao){
            with(binding){
                imageOpcao.setImageResource(opcao.icone)
                textTituloOpcao.text = opcao.titulo
                textDescricaoOpcao.text = opcao.descricao
                textInformacaoAdicionalOpcao.text = opcao.informacao_adicional

                if (opcao.informacao_adicional.isNullOrBlank()) {
                    textInformacaoAdicionalOpcao.background = null // sem fundo
                }

                main.setOnClickListener {
                    clique(opcao)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpcaoViewHolder {
        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itemView = OpcoesViewBinding.inflate(
            layoutInflater, parent, false
        )

        return OpcaoViewHolder( itemView )
    }

    override fun getItemCount(): Int {
        return listaOpcao.size
    }

    override fun onBindViewHolder(holder: OpcaoViewHolder, position: Int) {
        val opcao = listaOpcao[position]
        holder.bind(opcao)
    }
}