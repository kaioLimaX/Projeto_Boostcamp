package com.example.projeto_boostcamp.presentation.confirmacao

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projeto_boostcamp.R
import com.example.projeto_boostcamp.databinding.ActivityConfirmationBinding
import com.example.projeto_boostcamp.presentation.principal.MainActivity
import com.example.projeto_boostcamp.presentation.principal.PromoAdapter
import java.util.zip.Inflater

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityConfirmationBinding
    private lateinit var  produtosAdapter: PromoAdapter




    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


            override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View? {

                 binding = ActivityConfirmationBinding.inflate(
                     inflater,
                     container,
                     false
                 )

                voltarTelaInical = findViewById(R.id.image_btn_voltar_inicial)
                irDetalhesProdutos = findViewById(R.id.view_ir_detalhes_produtos)
                irDetalhesProdutos2 = findViewById(R.id.view_ir_detalhes_produtos_2)
                irDestaque1 = findViewById(R.id.image_view_destaque_1_china_in_box)
                irDestaque2 = findViewById(R.id.image_view_destaque_2_china_in_box)





                return binding.root


            }

        }
    }
}