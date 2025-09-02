package com.example.projeto_boostcamp.presentation.principal

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_boostcamp.R
import com.example.projeto_boostcamp.databinding.ActivityMainBinding
import com.example.projeto_boostcamp.presentation.detalhes_restaurantes.DetailsRestaurantsActivity
import com.example.projeto_boostcamp.presentation.perfil.PerfilActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var promoAdapter: PromoAdapter
    private lateinit var lojaAdapter: LojaAdapter
    private lateinit var categoriasAdapter: CategoriasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Ifood Clone"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        iniciarCategoriasAdapter()
        iniciarPromoAdapter()
        iniciarLojaAdapter()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> {
                startActivity(Intent(this, PerfilActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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