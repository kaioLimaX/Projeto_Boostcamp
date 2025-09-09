package com.example.projeto_boostcamp.presentation.detalhes_restaurantes

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_boostcamp.R
import com.example.projeto_boostcamp.presentation.detalhes_produto.DetailsProductActivity
import com.example.projeto_boostcamp.presentation.principal.MainActivity

class DetailsRestaurantsActivity : AppCompatActivity() {

    private lateinit var voltarTelaInicial: ImageButton
    private lateinit var rvList: RecyclerView


    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        enableEdgeToEdge()
        setContentView(R.layout.activity_details_restaurants)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        voltarTelaInicial    = findViewById(R.id.image_btn_voltar_inicial)
        voltarTelaInicial.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

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
        rvList = findViewById(R.id.rv_list)
        rvList.adapter = Itens_restarantsAdapter(listaProduto){
            startActivity(Intent(this, DetailsProductActivity::class.java))
        }
        rvList.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false)

        val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        rvList.addItemDecoration(dividerItemDecoration)
    }
}
