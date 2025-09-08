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

    private lateinit var voltarTelaInicial: ImageButton

    // “cards”/views que levam aos detalhes
    private lateinit var irDetalhesProdutos: View
    private lateinit var irDetalhesProdutos2: View

    // Destaques clicáveis (imagens)
    private lateinit var irDestaque1: ImageView
    private lateinit var irDestaque2: ImageView
    private lateinit var irDestaque3: ImageView




    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        enableEdgeToEdge()
        setContentView(R.layout.activity_details_restaurants)

        // Se seu layout tiver uma view raiz com id @id/main, mantém:
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ==== binds ====
        voltarTelaInicial    = findViewById(R.id.image_btn_voltar_inicial)

        irDetalhesProdutos   = findViewById(R.id.view_ir_detalhes_produtos)
        irDetalhesProdutos2  = findViewById(R.id.view_ir_detalhes_produtos_2)

        irDestaque1          = findViewById(R.id.image_view_destaque_1_china_in_box)
        irDestaque2          = findViewById(R.id.image_view_frango)
        irDestaque3          = findViewById(R.id.image_view_macarrao) // NOVO (ex: macarrão)


        // ==== ações ====
        // Qualquer um desses leva para detalhes do produto
        setClickToDetails(irDetalhesProdutos)
        setClickToDetails(irDetalhesProdutos2)

        setClickToDetails(irDestaque1)
        setClickToDetails(irDestaque2)
        setClickToDetails(irDestaque3) // NOVO



        voltarTelaInicial.setOnClickListener {
            // Evita empilhar múltiplos MainActivity; use finish() se veio dela
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun setClickToDetails(view: View) {
        view.setOnClickListener {
            startActivity(Intent(this, DetailsProductActivity::class.java))
        }
    }
}
