package com.example.projeto_boostcamp.presentation.detalhes_restaurantes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_boostcamp.R
import com.example.projeto_boostcamp.presentation.perfil.Opcao

class itens_restarantsA: AppCompatActivity() {

    private lateinit var rvList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalis_restaurants_recycler)


            val listaProduto = mutableListOf(
            Produto(R.drawable.frango, "Bowl frango tarê", "Bowl com saboroso arroz Yakimeshi, o nosso tradicional arroz soltinho refogado com flocos de ovos, cubinhos de cenoura, presunto, cebolinha picada com óleo de gergelim, coberto com pedaços de frango desossado coberto com molho tarê, gengibre e cebolinha picada.\n" +
                    "Serve 1 pessoa\n" +
                    "(350g)","R$37,90"),
            Produto(R.drawable.peixe, "Macarrão oriental taiwan", "Macarrão com molho à base de shoyu cobertos com porção de pedaços de lombo crispy ou frango crispy e cebolinha picada. Massa tradicional\n" +
                    "Serve 1 pessoa", "R$37,70"),
            Produto(R.drawable.br_colis, "Bowl Carne com Brócolis", "Bowl com saboroso arroz Yakimeshi, o nosso tradicional arroz soltinho refogado com flocos de ovos, cubinhos de cenoura, presunto, cebolinha picada com óleo de gergelim, coberto com fatias de carne, champignons e brócolis, com o nosso molho exclusivo à base de shoyu e alho.\n" +
                    "Serve 1 pessoa\n" +
                    "(350g)","R$39,90"),
            Produto(R.drawable.yakisoba, "Yakisoba bowl", "O Yakisoba mais pedido em um novo formato, macarrão oriental, com carne e frango. Acompanhado por legumes frescos (cenoura, brócolis, acelga, repolho) e cogumelos, finalizados com molho à base de shoyu. Alérgicos, nosso molho contém crustáceo, peixe, soja e derivados. Pode conter trigo, ovos e leite.","R$39,90"),
            )
             rvList = findViewById(R.id.rv_detalhe_produto)
             rvList.adapter = LinearLayoutItens_restaurantesAdapter(listaProduto)
             rvList.layoutManager = LinearLayoutManager(this)
        }
    }
}