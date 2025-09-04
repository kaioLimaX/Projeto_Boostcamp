package com.example.projeto_boostcamp.presentation.confirmacao

import android.app.Activity
import android.content.Intent
import android.os.Build.VERSION_CODES.M
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
import com.example.projeto_boostcamp.presentation.principal.PromoAdapter
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

        binding.rvListaConfirmation.adapter = confirmationAdapter
        binding.rvListaConfirmation.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun setupListeners() {
        binding.imageBtnVoltarInicial.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}