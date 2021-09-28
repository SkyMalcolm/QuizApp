package com.example.quizapp

object Konstanter {

    fun getQuestions(): MutableList<Questions> {
        val questionsList = mutableListOf<Questions>()


        val question1 = Questions(
            1,
            "What does IPA stand for?",
            "India Pale Ale",
            "Irregular Pale Ale",
            "Intensive Pale Ale",
            "Iced Pale Ale",
            1
        )

        questionsList.add(question1)

      /*  val question2 = Questions(
            2,
            "What year did World War II end?",
            "1939",
            "1946",
            "1945",
            "1940",
            3
        )

        questionsList.add(question2)

        val question3 = Questions(
            3,
            "Which country is the brie cheese originally from?",
            "Germany",
            "Italy",
            "Scheweiz",
            "France",
            4
        )

        questionsList.add(question3)

        val question4 = Questions(
            4,
            "How many teeth does a normal human have?",
            "32",
            "42",
            "26",
            "50",
            1
        )

        questionsList.add(question4)

        val question5 = Questions(
            5,
            "What is the biggest animal in the world?",
            "Elephant",
            "Giraffe",
            "Antartic blue whale",
            "Horse",
            3
        )

        questionsList.add(question5)

        val question6 = Questions(
            6,
            "Which planet is closest to the sun?",
            "Mercury",
            "Venus",
            "Saturn",
            "Neptune",
            1
        )

        questionsList.add(question6)

        val question7 = Questions(
            7,
            "How many valves does a human heart have?",
            "6",
            "3",
            "5",
            "4",
            4
        )

        questionsList.add(question7)

        val question8 = Questions(
            8,
            "What is a baby rabbit called?",
            "Pup",
            "Chick",
            "Kitten",
            "Foal",
            3
        )

        questionsList.add(question8)

        val question9 = Questions(
            9,
            "To a single decimal point, how many kilometers is a mile?",
            "1,7",
            "1,6",
            "1,5",
            "1,8",
            2
        )
        questionsList.add(question9)

        val question10 = Questions(
            10,
            "Where was the mojito cocktail created?",
            "Mexico",
            "Cuba",
            "Argentina",
            "Uruguay",
            2
        )

        questionsList.add(question10)

       */

        return questionsList


    }
}