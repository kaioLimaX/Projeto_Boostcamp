package com.example.projeto_boostcamp.presentation.perfil

data class Opcao(
    val icone: Int,
    val titulo: String,
    val descricao: String,
    var informacao_adicional: String = ""
)
