package com.example.projeto_boostcamp.presentation.confirmacao

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.projeto_boostcamp.R
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_boostcamp.databinding.ActivityConfirmationBinding
import com.example.projeto_boostcamp.presentation.principal.MainActivity
import kotlin.jvm.java

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmationBinding
    private lateinit var confirmationAdapter: ConfirmationAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Corrigido: Inflar via ViewBinding e setar como contentView
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Aplicar paddings para considerar as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnConfirmarPedido = findViewById<Button>(R.id.buttonConfirmarPedido)
        btnConfirmarPedido.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        setupListeners()

        val listaConfirmation = mutableListOf(
            ConfirmationDataClass(R.drawable.yakisoba_bowl,
                "Yakisoba clássico grande - 900g",
                "+R$ 68,90"),
            ConfirmationDataClass(R.drawable.yakisoba_bowl,
                "Yakisoba clássico pequeno - 510g",
                "+R$ 49,90"),
            ConfirmationDataClass(R.drawable.rolinho_kit_kat,
                "Rolinho de Kit Kat - 2 unidades",
                "+R$ 21,90"),
            ConfirmationDataClass(R.drawable.rolinho_primavera,
                "Rolinho primavera - 2 unidades",
                "+R$ 15,90"),
            ConfirmationDataClass(R.drawable.rolinho_banana,
                "Rolinho banana com chocolate - 2 unidades",
                "+R$ 16,00"),
            ConfirmationDataClass(R.drawable.coca_cola,
                "Coca-Cola 350ml",
                "+R$ 7,90"),
        )

        confirmationAdapter = ConfirmationAdapter( listaConfirmation ) //tinha dado um erro aqui
        binding.rvListaConfirmation.adapter = confirmationAdapter
        binding.rvListaConfirmation.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun setupListeners() {
        binding.imageBtnVoltarInicial.setOnClickListener {
            finish()
        }
    }
}