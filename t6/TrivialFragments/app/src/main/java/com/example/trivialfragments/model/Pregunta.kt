package com.example.trivialfragments.model

import java.io.Serializable


class Pregunta( val type: String, val difficulty: String, val question: String,val category:String, val correct_answer: String, val incorrect_answers: ArrayList<String>)
    : Serializable
