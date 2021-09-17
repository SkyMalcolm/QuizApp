package com.example.quizapp

object Konstanter {

    fun getQuestions(): MutableList<Questions> {
        val questionsList = mutableListOf<Questions>()


        val question1 = Questions(
            1,
            "Which carbrand is Swedish?",
            "Volvo",
            "BMW",
            "Audi",
            "Mercedes",
            1
        )

        questionsList.add(question1)

        val question2 = Questions(
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
            "In which city is KTH?",
            "Gothenburg",
            "Uppsala",
            "Malmö",
            "Stockholm",
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

        return questionsList


    }
}