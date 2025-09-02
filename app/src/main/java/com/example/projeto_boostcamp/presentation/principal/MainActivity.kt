package com.example.projeto_boostcamp.presentation.principal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_boostcamp.databinding.ActivityMainBinding
import com.example.projeto_boostcamp.presentation.detalhes_restaurantes.DetailsRestaurantsActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var promoAdapter: PromoAdapter
    private lateinit var lojaAdapter: LojaAdapter
    private lateinit var categoriasAdapter: CategoriasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        iniciarCategoriasAdapter()
        iniciarPromoAdapter()
        iniciarLojaAdapter()
    }

    private fun iniciarCategoriasAdapter() {
        categoriasAdapter = CategoriasAdapter { categoria ->

        }
        binding.rvCategorias.adapter = categoriasAdapter
        binding.rvCategorias.layoutManager = GridLayoutManager(
            this,
            2,
            RecyclerView.HORIZONTAL,
            false
        )
    }


    private fun iniciarPromoAdapter() {
        promoAdapter = PromoAdapter()
        binding.rvPromo.adapter = promoAdapter
        binding.rvPromo.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvPromo)
    }

    private fun iniciarLojaAdapter() {
        lojaAdapter = LojaAdapter { loja ->
            val intent = Intent(this, DetailsRestaurantsActivity::class.java)
            intent.putExtra("loja", loja)
            startActivity(intent)
        }

        binding.rvLojas.adapter = lojaAdapter
        binding.rvLojas.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}