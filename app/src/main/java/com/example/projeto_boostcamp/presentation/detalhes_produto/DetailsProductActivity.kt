package com.example.projeto_boostcamp.presentation.detalhes_produto

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_boostcamp.R
import com.example.projeto_boostcamp.presentation.confirmacao.ConfirmationActivity
import com.example.projeto_boostcamp.presentation.detalhes_restaurantes.DetailsRestaurantsActivity


class DetailsProductActivity : AppCompatActivity() {

    private lateinit var rvDetalheEProdutos: RecyclerView
    private lateinit var detalheEProdutosAdapter: DetalheEProdutosAdapter
    private lateinit var botaoConfirmar: Button
    private lateinit var botaoVoltar: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        @SuppressLint("SourceLockedOrientationActivity")
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        enableEdgeToEdge()
        setContentView(R.layout.activity_details_product)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        botaoConfirmar = findViewById(R.id.btn_confirmar)
        botaoVoltar = findViewById(R.id.btn_onback)

        rvDetalheEProdutos = findViewById(R.id.rv_detalhe_produto)

        val lista = listOf(
            DetalheProdutos(
                "Yakisoba clássico grande - 900g",
                "+R$ 68,90",
                "1",
                R.drawable.yakisoba_bowl
            ),
            DetalheProdutos(
                "Yakisoba clássico pequeno - 510g",
                "+R$ 49,90",
                "1",
                R.drawable.yakisoba_bowl
            ),
            DetalheProdutos(
                "Rolinho de Kit Kat - 1 unidade",
                "+R$ 12,90",
                "0",
                R.drawable.rolinho_kit_kat
            ),
            DetalheProdutos(
                "Rolinho de Kit Kat - 2 unidades",
                "+R$ 21,90",
                "1",
                R.drawable.rolinho_kit_kat
            ),
            DetalheProdutos(
                "Rolinho primavera - 1 unidade",
                "+R$ 12,00",
                "0",
                R.drawable.rolinho_primavera
            ),
            DetalheProdutos(
                "Rolinho primavera - 2 unidades",
                "+R$ 15,90",
                "1",
                R.drawable.rolinho_primavera
            ),
            DetalheProdutos(
                "Rolinho banana com chocolate - 1 unidade",
                "+R$ 9,90",
                "0",
                R.drawable.rolinho_banana
            ),
            DetalheProdutos(
                "Rolinho banana com chocolate - 2 unidades",
                "+R$ 16,00",
                "1",
                R.drawable.rolinho_banana
            ),
            DetalheProdutos("Coca-Cola 350ml", "+RS 7,90", "1", R.drawable.coca_cola),
            DetalheProdutos("Coca-Cola sem açúcar 350ml", "+RS 7,90", "0", R.drawable.coca_cola)
        )


        //Adapter
        detalheEProdutosAdapter = DetalheEProdutosAdapter()
        rvDetalheEProdutos.adapter = detalheEProdutosAdapter
        detalheEProdutosAdapter.configurarLista(lista)


        //Layout
        rvDetalheEProdutos.layoutManager = LinearLayoutManager(this)


        //Telas
        botaoConfirmar.setOnClickListener {
            val intent = Intent(this, ConfirmationActivity::class.java)
            startActivity(intent)
        }

        botaoVoltar.setOnClickListener {
            val intent = Intent(this, DetailsRestaurantsActivity::class.java)
            startActivity(intent)
        }


    }
}