package com.example.trivialfragments.model

import kotlinx.serialization.Serializable
@Serializable
class Usuario(val nick: String, val correo: String, val password: String,val edad : Int)