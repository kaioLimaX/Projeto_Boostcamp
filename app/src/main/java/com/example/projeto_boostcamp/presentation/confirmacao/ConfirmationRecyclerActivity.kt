package com.example.projeto_boostcamp.presentation.confirmacao

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_boostcamp.R

class ConfirmationRecyclerActivity : AppCompatActivity()
{

    private lateinit var rvLista: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation_recycler)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lista = listOf("Yakissoba Clássico Grande - 900g", "Mega X Burguer Double Trouble")

        rvLista = findViewById(R.id.rvListaConfirmation)
        rvLista.adapter = ConfirmationAdapter( lista )
        rvLista.layoutManager = LinearLayoutManager(this)

    }
}