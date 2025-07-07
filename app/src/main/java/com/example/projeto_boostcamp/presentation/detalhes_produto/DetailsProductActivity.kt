package com.example.projeto_boostcamp.presentation.detalhes_produto

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projeto_boostcamp.R
import com.example.projeto_boostcamp.databinding.ActivityDetailsProductBinding
import com.example.projeto_boostcamp.presentation.confirmacao.ConfirmationActivity


class DetailsProductActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailsProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnOnback.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
        binding.btnConfirmar.setOnClickListener {
            val intent = Intent(this, ConfirmationActivity::class.java)
            this.startActivity(intent)
        }
    }
}