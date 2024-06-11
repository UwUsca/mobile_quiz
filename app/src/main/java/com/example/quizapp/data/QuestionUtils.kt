package com.example.quizapp.data

import com.example.quizapp.R

fun createQuestions(theme: String? = null): List<Question> {
    val allQuestions = listOf(

        //------ PERGUNTAS GEOGRAFIA ------

        Question(
            "Qual é o maior rio do mundo?",
            listOf("Amazonas", "Nilo", "Yangtze", "Mississippi"),
            "Amazonas",
            R.drawable.river,
            "Geografia"
        ),
        Question(
            "Qual é o ponto mais alto da Terra?",
            listOf("Everest", "K2", "Annapurna", "Kilimanjaro"),
            "Everest",
            R.drawable.mountain,
            "Geografia"
        ),
        Question(
            "Qual é o maior deserto do mundo?",
            listOf("Saara", "Deserto da Antártica", "Deserto do Atacama", "Deserto do Saara"),
            "Deserto do Saara",
            R.drawable.desert,
            "Geografia"
        ),
        Question(
            "Qual é o país com a maior área territorial?",
            listOf("Rússia", "Canadá", "China", "Estados Unidos"),
            "Rússia",
            R.drawable.earth,
            "Geografia"
        ),
        Question(
            "Onde está localizada a Grande Barreira de Coral?",
            listOf("Austrália", "Havaí", "Filipinas", "Indonésia"),
            "Austrália",
            R.drawable.corals,
            "Geografia"
        ),
        Question(
            "Qual é o menor país do mundo em área territorial?",
            listOf("Vaticano", "Mônaco", "Nauru", "Tuvalu"),
            "Vaticano",
            R.drawable.earth,
            "Geografia"
        ),
        Question(
            "Qual é o maior oceano do mundo?",
            listOf("Pacífico", "Atlântico", "Índico", "Ártico"),
            "Pacífico",
            R.drawable.ocean,
            "Geografia"
        ),
        Question(
            "Qual é o país mais populoso do mundo?",
            listOf("China", "Índia", "Estados Unidos", "Brasil"),
            "China",
            R.drawable.earth,
            "Geografia"
        ),
        Question(
            "Qual é o continente mais frio do mundo?",
            listOf("Antártica", "África", "Europa", "América do Sul"),
            "Antártica",
            R.drawable.cold,
            "Geografia"
        ),
        Question(
            "Qual é a cidade mais populosa do mundo?",
            listOf("Tóquio", "Delhi", "Xangai", "Cidade do México"),
            "Tóquio",
            R.drawable.city,
            "Geografia"
        ),
        Question(
            "Em qual país está localizado o Monte Kilimanjaro?",
            listOf("Tanzânia", "Quênia", "Uganda", "África do Sul"),
            "Tanzânia",
            R.drawable.mountain,
            "Geografia"
        ),
        Question(
            "Qual é o maior lago da América do Sul?",
            listOf("Lago Titicaca", "Lago de Maracaibo", "Lago Baikal", "Lago Vitória"),
            "Lago Titicaca",
            R.drawable.lake,
            "Geografia"
        ),
        Question(
            "Qual é o país com maior número de ilhas no mundo?",
            listOf("Suécia", "Noruega", "Indonésia", "Japão"),
            "Indonésia",
            R.drawable.earth,
            "Geografia"
        ),
        Question(
            "Qual é o estado mais populoso do Brasil?",
            listOf("São Paulo", "Rio de Janeiro", "Minas Gerais", "Bahia"),
            "São Paulo",
            R.drawable.city,
            "Geografia"
        ),
        Question(
            "Qual é o país com a maior quantidade de fronteiras terrestres?",
            listOf("Rússia", "China", "Brasil", "Índia"),
            "China",
            R.drawable.earth,
            "Geografia"
        ),

        //------ PERGUNTAS CIENCIAS ------


        Question(
            "Qual é a molécula que transporta o código genético?",
            listOf("RNA", "DNA", "Proteína", "Lipídio"),
            "DNA",
            R.drawable.dna,
            "Ciências"
        ),
        Question(
            "Qual é a unidade básica da vida?",
            listOf("Célula", "Átomo", "Molécula", "Organoide"),
            "Célula",
            R.drawable.plants,
            "Ciências"
        ),
        Question(
            "Qual é o elemento químico mais abundante no universo?",
            listOf("Hélio", "Oxigênio", "Hidrogênio", "Carbono"),
            "Hidrogênio",
            R.drawable.elements,
            "Ciências"
        ),
        Question(
            "Qual é o processo pelo qual as plantas produzem energia?",
            listOf("Fotossíntese", "Respiração", "Fermentação", "Quimiossíntese"),
            "Fotossíntese",
            R.drawable.plants,
            "Ciências"
        ),
        Question(
            "Quem formulou a teoria da relatividade?",
            listOf("Isaac Newton", "Albert Einstein", "Galileu Galilei", "Nikola Tesla"),
            "Albert Einstein",
            R.drawable.study,
            "Ciências"
        ),
        Question(
            "Qual é o maior órgão do corpo humano?",
            listOf("Coração", "Pulmão", "Fígado", "Pele"),
            "Pele",
            R.drawable.body,
            "Ciências"
        ),
        Question(
            "Qual é o nome do processo de divisão celular que resulta em duas células filhas idênticas?",
            listOf("Meiose", "Mitose", "Citocinese", "Bipartição"),
            "Mitose",
            R.drawable.dna,
            "Ciências"
        ),
        Question(
            "Qual é a fórmula química da água?",
            listOf("H2O", "CO2", "O2", "NaCl"),
            "H2O",
            R.drawable.elements,
            "Ciências"
        ),
        Question(
            "Qual planeta é conhecido como o 'Planeta Vermelho'?",
            listOf("Júpiter", "Marte", "Saturno", "Vênus"),
            "Marte",
            R.drawable.solar,
            "Ciências"
        ),
        Question(
            "Qual é o metal líquido à temperatura ambiente?",
            listOf("Mercúrio", "Ferro", "Cobre", "Prata"),
            "Mercúrio",
            R.drawable.elements,
            "Ciências"
        ),
        Question(
            "Qual é a unidade de medida da força no Sistema Internacional de Unidades?",
            listOf("Joule", "Pascal", "Newton", "Watt"),
            "Newton",
            R.drawable.study,
            "Ciências"
        ),
        Question(
            "Qual é a camada mais externa da Terra?",
            listOf("Manto", "Crosta", "Núcleo Externo", "Núcleo Interno"),
            "Crosta",
            R.drawable.earth,
            "Ciências"
        ),
        Question(
            "Qual gás é essencial para a respiração humana?",
            listOf("Nitrogênio", "Dióxido de Carbono", "Oxigênio", "Hélio"),
            "Oxigênio",
            R.drawable.elements,
            "Ciências"
        ),
        Question(
            "Qual é o nome do cientista que propôs as três leis do movimento?",
            listOf("Galileu Galilei", "Nikola Tesla", "Isaac Newton", "Albert Einstein"),
            "Isaac Newton",
            R.drawable.study,
            "Ciências"
        ),
        Question(
            "Qual é a principal função das mitocôndrias nas células?",
            listOf("Produzir energia", "Sintetizar proteínas", "Armazenar nutrientes", "Controlar a divisão celular"),
            "Produzir energia",
            R.drawable.plants,
            "Ciências"
        ),


        //------ PERGUNTAS HISTORIA ------


        Question(
            "Quem foi o primeiro presidente dos Estados Unidos?",
            listOf("Thomas Jefferson", "Abraham Lincoln", "George Washington", "John Adams"),
            "George Washington",
            R.drawable.eua,
            "História"
        ),
        Question(
            "Em que ano ocorreu a Revolução Francesa?",
            listOf("1776", "1789", "1815", "1848"),
            "1789",
            R.drawable.france,
            "História"
        ),
        Question(
            "Qual foi o nome da guerra civil americana?",
            listOf("Guerra Civil Inglesa", "Guerra Civil Espanhola", "Guerra Civil Americana", "Guerra Civil Francesa"),
            "Guerra Civil Americana",
            R.drawable.americawar,
            "História"
        ),
        Question(
            "Quem foi o líder do movimento pelos direitos civis nos EUA na década de 1960?",
            listOf("Malcolm X", "Martin Luther King Jr.", "Nelson Mandela", "Rosa Parks"),
            "Martin Luther King Jr.",
            R.drawable.eua,
            "História"
        ),
        Question(
            "Qual era o nome da rota comercial que ligava o Oriente ao Ocidente?",
            listOf("Rota do Ouro", "Rota da Seda", "Rota das Especiarias", "Rota da Prata"),
            "Rota da Seda",
            R.drawable.silk,
            "História"
        ),
        Question(
            "Quem foi o conquistador espanhol que derrotou o Império Asteca?",
            listOf("Francisco Pizarro", "Hernán Cortés", "Vasco da Gama", "Ferdinand Magellan"),
            "Hernán Cortés",
            R.drawable.astec,
            "História"
        ),
        Question(
            "Qual era o nome do navio que trouxe os peregrinos para a América em 1620?",
            listOf("Santa Maria", "Pinta", "Mayflower", "Nina"),
            "Mayflower",
            R.drawable.mayflower,
            "História"
        ),
        Question(
            "Quem foi o primeiro imperador de Roma?",
            listOf("Nero", "Calígula", "Augusto", "Júlio César"),
            "Augusto",
            R.drawable.rome,
            "História"
        ),
        Question(
            "Em que ano caiu o Muro de Berlim?",
            listOf("1987", "1989", "1991", "1993"),
            "1989",
            R.drawable.berlin,
            "História"
        ),
        Question(
            "Quem descobriu o caminho marítimo para a Índia em 1498?",
            listOf("Cristóvão Colombo", "Vasco da Gama", "Pedro Álvares Cabral", "Ferdinand Magellan"),
            "Vasco da Gama",
            R.drawable.silk,
            "História"
        ),
        Question(
            "Qual foi a primeira civilização a usar a escrita cuneiforme?",
            listOf("Egípcios", "Sumérios", "Babilônios", "Fenícios"),
            "Sumérios",
            R.drawable.writing,
            "História"
        ),
        Question(
            "Quem foi a rainha do Reino Unido durante a era vitoriana?",
            listOf("Elizabeth I", "Victoria", "Mary I", "Elizabeth II"),
            "Victoria",
            R.drawable.uk,
            "História"
        ),
        Question(
            "Qual foi a principal causa da Primeira Guerra Mundial?",
            listOf("Assassinato do arquiduque Francisco Ferdinando", "Invasão da Polônia", "Ataque a Pearl Harbor", "Revolução Russa"),
            "Assassinato do arquiduque Francisco Ferdinando",
            R.drawable.ww1,
            "História"
        ),
        Question(
            "Quem foi o líder revolucionário cubano que tomou o poder em 1959?",
            listOf("Che Guevara", "Fulgencio Batista", "Raúl Castro", "Fidel Castro"),
            "Fidel Castro",
            R.drawable.cuba,
            "História"
        ),
        Question(
            "Em que ano Colombo chegou à América?",
            listOf("1492", "1498", "1500", "1512"),
            "1492",
            R.drawable.colombus,
            "História"
        ),


        //------ PERGUNTAS ESPORTES ------


        Question(
            "Qual é o país com mais títulos na Copa do Mundo de Futebol?",
            listOf("Alemanha", "Brasil", "Itália", "Argentina"),
            "Brasil",
            R.drawable.cup,
            "Esportes"
        ),
        Question(
            "Quem é o maior artilheiro da história da NBA?",
            listOf("Michael Jordan", "LeBron James", "Kareem Abdul-Jabbar", "Kobe Bryant"),
            "Kareem Abdul-Jabbar",
            R.drawable.nba,
            "Esportes"
        ),
        Question(
            "Qual país sediou os Jogos Olímpicos de 2016?",
            listOf("Londres", "Pequim", "Rio de Janeiro", "Tóquio"),
            "Rio de Janeiro",
            R.drawable.olympics,
            "Esportes"
        ),
        Question(
            "Quem é conhecido como 'O Rei do Futebol'?",
            listOf("Diego Maradona", "Lionel Messi", "Pelé", "Cristiano Ronaldo"),
            "Pelé",
            R.drawable.cup,
            "Esportes"
        ),
        Question(
            "Em qual esporte é utilizado o termo 'love' para indicar um placar de zero pontos?",
            listOf("Tênis", "Vôlei", "Basquete", "Críquete"),
            "Tênis",
            R.drawable.olympics,
            "Esportes"
        ),
        Question(
            "Qual é a duração de uma partida de futebol regulamentar?",
            listOf("80 minutos", "90 minutos", "100 minutos", "120 minutos"),
            "90 minutos",
            R.drawable.cup,
            "Esportes"
        ),
        Question(
            "Quem ganhou a medalha de ouro nos 100 metros rasos nas Olimpíadas de 2008, 2012 e 2016?",
            listOf("Usain Bolt", "Carl Lewis", "Asafa Powell", "Justin Gatlin"),
            "Usain Bolt",
            R.drawable.olympics,
            "Esportes"
        ),
        Question(
            "Qual é o esporte nacional do Japão?",
            listOf("Judô", "Sumô", "Karatê", "Beisebol"),
            "Sumô",
            R.drawable.japan,
            "Esportes"
        ),
        Question(
            "Qual jogador de futebol tem o apelido de 'La Pulga'?",
            listOf("Cristiano Ronaldo", "Neymar", "Zlatan Ibrahimović", "Lionel Messi"),
            "Lionel Messi",
            R.drawable.cup,
            "Esportes"
        ),
        Question(
            "Em qual esporte um 'hole-in-one' é um feito notável?",
            listOf("Golfe", "Beisebol", "Críquete", "Hóquei"),
            "Golfe",
            R.drawable.olympics,
            "Esportes"
        ),
        Question(
            "Qual é o time com mais títulos na Liga dos Campeões da UEFA?",
            listOf("Barcelona", "Manchester United", "Bayern de Munique", "Real Madrid"),
            "Real Madrid",
            R.drawable.cup,
            "Esportes"
        ),
        Question(
            "Qual é a distância de uma maratona?",
            listOf("21 km", "26.2 km", "30 km", "42.2 km"),
            "42.2 km",
            R.drawable.olympics,
            "Esportes"
        ),
        Question(
            "Quem é o maior vencedor da Fórmula 1 em número de campeonatos?",
            listOf("Michael Schumacher", "Lewis Hamilton", "Ayrton Senna", "Sebastian Vettel"),
            "Michael Schumacher",
            R.drawable.f1,
            "Esportes"
        ),
        Question(
            "Qual país é conhecido por dominar o esporte do hóquei no gelo?",
            listOf("Suécia", "Rússia", "Canadá", "Estados Unidos"),
            "Canadá",
            R.drawable.olympics,
            "Esportes"
        ),
        Question(
            "Qual atleta é conhecido como 'Lightning Bolt'?",
            listOf("Usain Bolt", "Michael Johnson", "Carl Lewis", "Tyson Gay"),
            "Usain Bolt",
            R.drawable.olympics,
            "Esportes"
        ),


        //------ PERGUNTAS ARTES ------


        Question(
            "Quem pintou a Mona Lisa?",
            listOf("Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet"),
            "Leonardo da Vinci",
            R.drawable.monalisa,
            "Artes"
        ),
        Question(
            "Qual movimento artístico é conhecido pelo uso de formas geométricas e sobreposição de planos?",
            listOf("Cubismo", "Impressionismo", "Surrealismo", "Barroco"),
            "Cubismo",
            R.drawable.artstyle,
            "Artes"
        ),
        Question(
            "Quem compôs a ópera 'A Flauta Mágica'?",
            listOf("Ludwig van Beethoven", "Johann Sebastian Bach", "Wolfgang Amadeus Mozart", "Franz Schubert"),
            "Wolfgang Amadeus Mozart",
            R.drawable.opera,
            "Artes"
        ),
        Question(
            "Qual é o nome do famoso museu localizado em Paris que abriga a Mona Lisa?",
            listOf("Museu do Prado", "Galeria Uffizi", "Museu do Louvre", "Museu Britânico"),
            "Museu do Louvre",
            R.drawable.museum,
            "Artes"
        ),
        Question(
            "Qual artista é conhecido por sua obra 'Noite Estrelada'?",
            listOf("Claude Monet", "Vincent van Gogh", "Paul Cézanne", "Edgar Degas"),
            "Vincent van Gogh",
            R.drawable.estrelada,
            "Artes"
        ),
        Question(
            "Qual técnica de pintura utiliza pigmentos suspensos em óleo?",
            listOf("Aquarela", "Têmpera", "Óleo sobre tela", "Gouache"),
            "Óleo sobre tela",
            R.drawable.artstyle,
            "Artes"
        ),
        Question(
            "Quem é o autor da escultura 'David'?",
            listOf("Donatello", "Gian Lorenzo Bernini", "Michelangelo", "Auguste Rodin"),
            "Michelangelo",
            R.drawable.david,
            "Artes"
        ),
        Question(
            "Qual compositor é conhecido por suas sinfonias, incluindo a 'Nona Sinfonia'?",
            listOf("Johannes Brahms", "Ludwig van Beethoven", "Franz Joseph Haydn", "Antonín Dvořák"),
            "Ludwig van Beethoven",
            R.drawable.opera,
            "Artes"
        ),
        Question(
            "Qual movimento artístico buscava representar a realidade de forma objetiva e precisa?",
            listOf("Realismo", "Impressionismo", "Expressionismo", "Surrealismo"),
            "Realismo",
            R.drawable.artstyle,
            "Artes"
        ),
        Question(
            "Quem é o autor da obra 'O Grito'?",
            listOf("Edvard Munch", "Gustav Klimt", "Francisco Goya", "Jackson Pollock"),
            "Edvard Munch",
            R.drawable.scream,
            "Artes"
        ),
        Question(
            "Qual é o nome da técnica de pintura que utiliza pequenos pontos de cor pura justapostos?",
            listOf("Pontilhismo", "Impressionismo", "Futurismo", "Dadaísmo"),
            "Pontilhismo",
            R.drawable.artstyle,
            "Artes"
        ),
        Question(
            "Qual artista é famoso por suas obras de 'pop art', incluindo imagens de latas de sopa Campbell?",
            listOf("Roy Lichtenstein", "Keith Haring", "Andy Warhol", "Jean-Michel Basquiat"),
            "Andy Warhol",
            R.drawable.popart,
            "Artes"
        ),
        Question(
            "Quem compôs 'As Quatro Estações'?",
            listOf("Antonio Vivaldi", "Johann Sebastian Bach", "Georg Friedrich Händel", "Pyotr Ilyich Tchaikovsky"),
            "Antonio Vivaldi",
            R.drawable.stations,
            "Artes"
        ),
        Question(
            "Qual é o estilo arquitetônico caracterizado por arcos pontiagudos, abóbadas de nervuras e vitrais?",
            listOf("Barroco", "Gótico", "Renascentista", "Neoclássico"),
            "Gótico",
            R.drawable.arcthect,
            "Artes"
        ),
        Question(
            "Quem é o autor do famoso quadro 'A Última Ceia'?",
            listOf("Raphael", "Leonardo da Vinci", "Sandro Botticelli", "Michelangelo"),
            "Leonardo da Vinci",
            R.drawable.last,
            "Artes"
        ),


        //------ PERGUNTAS ENTRETERIMENTO ------


        Question(
            "Qual filme ganhou o Oscar de Melhor Filme em 2020?",
            listOf("1917", "Coringa", "Era uma Vez em... Hollywood", "Parasita"),
            "Parasita",
            R.drawable.oscar,
            "Entretenimento"
        ),
        Question(
            "Qual é o nome verdadeiro do Homem de Ferro nos filmes da Marvel?",
            listOf("Bruce Wayne", "Clark Kent", "Peter Parker", "Tony Stark"),
            "Tony Stark",
            R.drawable.ironman,
            "Entretenimento"
        ),
        Question(
            "Qual série de TV é famosa pela frase 'Winter is coming'?",
            listOf("Breaking Bad", "Game of Thrones", "Vikings", "The Witcher"),
            "Game of Thrones",
            R.drawable.got,
            "Entretenimento"
        ),
        Question(
            "Quem é conhecido como o 'Rei do Pop'?",
            listOf("Elvis Presley", "Prince", "Michael Jackson", "Freddie Mercury"),
            "Michael Jackson",
            R.drawable.music,
            "Entretenimento"
        ),
        Question(
            "Qual banda lançou o álbum 'Abbey Road'?",
            listOf("The Rolling Stones", "The Beatles", "Led Zeppelin", "Pink Floyd"),
            "The Beatles",
            R.drawable.music,
            "Entretenimento"
        ),
        Question(
            "Qual série animada apresenta personagens como Homer, Marge, Bart, Lisa e Maggie?",
            listOf("South Park", "Family Guy", "Os Simpsons", "Rick and Morty"),
            "Os Simpsons",
            R.drawable.cartoon,
            "Entretenimento"
        ),
        Question(
            "Qual ator interpretou o personagem 'Coringa' no filme 'O Cavaleiro das Trevas'?",
            listOf("Jared Leto", "Jack Nicholson", "Joaquin Phoenix", "Heath Ledger"),
            "Heath Ledger",
            R.drawable.joker,
            "Entretenimento"
        ),
        Question(
            "Qual cantor(a) lançou o álbum 'Lemonade' em 2016?",
            listOf("Rihanna", "Adele", "Beyoncé", "Taylor Swift"),
            "Beyoncé",
            R.drawable.music,
            "Entretenimento"
        ),
        Question(
            "Em qual filme dos anos 90 os personagens principais são Neo, Morpheus e Trinity?",
            listOf("O Sexto Sentido", "O Resgate do Soldado Ryan", "Clube da Luta", "Matrix"),
            "Matrix",
            R.drawable.cinema,
            "Entretenimento"
        ),
        Question(
            "Qual série de TV apresenta uma escola de bruxaria chamada Hogwarts?",
            listOf("Buffy, a Caça-Vampiros", "Supernatural", "Harry Potter", "Sabrina, a Aprendiz de Feiticeira"),
            "Harry Potter",
            R.drawable.series,
            "Entretenimento"
        ),
        Question(
            "Qual é o nome da banda fictícia do filme 'Quase Famosos'?",
            listOf("Stillwater", "The Wonders", "Spinal Tap", "The Commitments"),
            "Stillwater",
            R.drawable.music,
            "Entretenimento"
        ),
        Question(
            "Quem interpretou o papel de Jack Dawson no filme 'Titanic'?",
            listOf("Brad Pitt", "Johnny Depp", "Leonardo DiCaprio", "Tom Cruise"),
            "Leonardo DiCaprio",
            R.drawable.titanic,
            "Entretenimento"
        ),
        Question(
            "Qual série de TV é conhecida por suas referências à cultura pop e diálogos rápidos, centrada na cidade fictícia de Stars Hollow?",
            listOf("Gilmore Girls", "Desperate Housewives", "The O.C.", "One Tree Hill"),
            "Gilmore Girls",
            R.drawable.series,
            "Entretenimento"
        ),
        Question(
            "Qual personagem da série 'Friends' diz a famosa frase 'We were on a break'?",
            listOf("Joey", "Ross", "Rachel", "Chandler"),
            "Ross",
            R.drawable.series,
            "Entretenimento"
        ),
        Question(
            "Qual filme da Disney apresenta a canção 'Let It Go'?",
            listOf("Moana", "Frozen", "Enrolados", "Valente"),
            "Frozen",
            R.drawable.cinema,
            "Entretenimento"
        )
    )
    return if (theme == null) {
        allQuestions
    } else {
        allQuestions.filter { it.theme == theme }
    }
}