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
import com.example.projeto_boostcamp.R
import com.example.projeto_boostcamp.presentation.detalhes_produto.DetailsProductActivity
import com.example.projeto_boostcamp.presentation.principal.MainActivity

class DetailsRestaurantsActivity : AppCompatActivity() {

    private lateinit var voltarTelaInical: ImageButton
    private lateinit var irDetalhesProdutos: View
    private lateinit var irDetalhesProdutos2: View
    private lateinit var irDestaque1: ImageView
    private lateinit var irDestaque2: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        @SuppressLint("SourceLockedOrientationActivity")
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        enableEdgeToEdge()
        setContentView(R.layout.activity_details_restaurants)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        voltarTelaInical = findViewById(R.id.image_btn_voltar_inicial)
        irDetalhesProdutos = findViewById(R.id.view_ir_detalhes_produtos)
        irDetalhesProdutos2 = findViewById(R.id.view_ir_detalhes_produtos_2)
        irDestaque1 = findViewById(R.id.image_view_destaque_1_china_in_box)
        irDestaque2 = findViewById(R.id.image_view_destaque_2_china_in_box)

        cliqueParaDetalhesEDestaque(irDetalhesProdutos)
        cliqueParaDetalhesEDestaque(irDetalhesProdutos2)
        cliqueParaDetalhesEDestaque(irDestaque1)
        cliqueParaDetalhesEDestaque(irDestaque2)


        voltarTelaInical.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun cliqueParaDetalhesEDestaque(view: View) {
        view.setOnClickListener {
            val intent = Intent(this, DetailsProductActivity::class.java)
            startActivity(intent)
        }
    }
}

