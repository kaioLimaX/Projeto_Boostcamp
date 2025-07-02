package com.example.projeto_boostcamp.presentation.principal

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Loja(
    val nome: String,
    val imagem: Int
) : Parcelable
