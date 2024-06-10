package com.example.quizapp.data

import com.example.quizapp.R
import com.example.quizapp.data.Question

fun createQuestions(): List<Question> {
    return listOf(
        Question(
            "Qual é o maior rio do mundo?",
            listOf("Amazonas", "Nilo", "Yangtze", "Mississippi"),
            "Amazonas",
            R.drawable.river
        ),
        Question(
            "Qual é o ponto mais alto da Terra?",
            listOf("Everest", "K2", "Annapurna", "Kilimanjaro"),
            "Everest",
            R.drawable.mountain
        ),
        Question(
            "Qual é o maior deserto do mundo?",
            listOf("Saara", "Deserto da Antártica", "Deserto do Atacama", "Deserto do Saara"),
            "Deserto do Saara",
            R.drawable.desert
        ),
        Question(
            "Qual é o país com a maior área territorial?",
            listOf("Rússia", "Canadá", "China", "Estados Unidos"),
            "Rússia",
            R.drawable.earth
        ),
        Question(
            "Onde está localizada a Grande Barreira de Coral?",
            listOf("Austrália", "Havaí", "Filipinas", "Indonésia"),
            "Austrália",
            R.drawable.corals
        ),
        Question(
            "Qual é o menor país do mundo em área territorial?",
            listOf("Vaticano", "Mônaco", "Nauru", "Tuvalu"),
            "Vaticano",
            R.drawable.earth
        ),
        Question(
            "Qual é o maior oceano do mundo?",
            listOf("Pacífico", "Atlântico", "Índico", "Ártico"),
            "Pacífico",
            R.drawable.ocean
        ),
        Question(
            "Qual é o país mais populoso do mundo?",
            listOf("China", "Índia", "Estados Unidos", "Brasil"),
            "China",
            R.drawable.earth
        ),
        Question(
            "Qual é o continente mais frio do mundo?",
            listOf("Antártica", "África", "Europa", "América do Sul"),
            "Antártica",
            R.drawable.cold
        ),
        Question(
            "Qual é a cidade mais populosa do mundo?",
            listOf("Tóquio", "Delhi", "Xangai", "Cidade do México"),
            "Tóquio",
            R.drawable.city
        ),
        Question(
            "Em qual país está localizado o Monte Kilimanjaro?",
            listOf("Tanzânia", "Quênia", "Uganda", "África do Sul"),
            "Tanzânia",
            R.drawable.mountain
        ),
        Question(
            "Qual é o maior lago da América do Sul?",
            listOf("Lago Titicaca", "Lago de Maracaibo", "Lago Baikal", "Lago Vitória"),
            "Lago Titicaca",
            R.drawable.lake
        ),
        Question(
            "Qual é o país com maior número de ilhas no mundo?",
            listOf("Suécia", "Noruega", "Indonésia", "Japão"),
            "Indonésia",
            R.drawable.earth
        ),
        Question(
            "Qual é o estado mais populoso do Brasil?",
            listOf("São Paulo", "Rio de Janeiro", "Minas Gerais", "Bahia"),
            "São Paulo",
            R.drawable.city
        ),
        Question(
            "Qual é o país com a maior quantidade de fronteiras terrestres?",
            listOf("Rússia", "China", "Brasil", "Índia"),
            "China",
            R.drawable.earth
        )
    )
}