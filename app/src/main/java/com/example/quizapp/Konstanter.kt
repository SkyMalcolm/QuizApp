package com.example.quizapp

object Konstanter {

    fun getQuestions(): ArrayList<Questions> {
        val QuestionsList = ArrayList<Questions>()


        val question1 = Questions(
            1,
            "Which carbrand is Swedish?",
            "Volvo",
            "BMW",
            "Audi",
            "Mercedes",
            1
        )

        QuestionsList.add(question1)

        val question2 = Questions(
            2,
            "What year did World War II end?",
            "1939",
            "1946",
            "1945",
            "1940",
            3
        )

        QuestionsList.add(question2)

        val question3 = Questions(
            3,
            "In which city is KTH?",
            "Gothenburg",
            "Uppsala",
            "Malmö",
            "Stockholm",
            4
        )

        QuestionsList.add(question3)

        val question4 = Questions(
            4,
            "How many teeth does a normal human have?",
            "32",
            "42",
            "26",
            "50",
            1
        )

        QuestionsList.add(question4)

        return QuestionsList


    }
}