package com.example.projeto_boostcamp.presentation.perfil

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_boostcamp.R
import com.example.projeto_boostcamp.databinding.ActivityPerfilBinding
import com.example.projeto_boostcamp.presentation.principal.MainActivity

class PerfilActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityPerfilBinding.inflate(layoutInflater)
    }

    private lateinit var opcaoAdapter: OpcaoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        iniciarOpcaoAdapter()
    }

    private fun iniciarOpcaoAdapter() {
        opcaoAdapter = OpcaoAdapter { opcao ->
            if (opcao.titulo == "Conversas") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        binding.rvOpcao.adapter = opcaoAdapter
        binding.rvOpcao.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvOpcao.addItemDecoration( DividerItemDecoration(this, RecyclerView.VERTICAL))
    }
}