package com.example.cuartitosa.studentData

import com.example.cuartitosa.R
import com.example.cuartitosa.model.Student


object StudentData {


    private val allStudents = listOf(
        // Dashboard 1
        Student(1, "María López", "Apasionada por la programación.", R.drawable.student1),
        Student(2, "Juan Pérez", "Le gusta la astronomía.", R.drawable.student2),
        Student(
            3,
            "Vanessa Molina",
            "Apasionada por la química y el universo.",
            R.drawable.student3
        ),
        Student(4, "David Gómez", "Apasionado por la gastronomía.", R.drawable.student4),
        // Dashboard 2
        Student(5, "Carlos Ruiz", "Fanático de la ciencia ficción.", R.drawable.student1),
        Student(6, "Ana Torres", "Interesada en la biología marina.", R.drawable.student2),
        Student(7, "Pedro Morales", "Experto en videojuegos retro.", R.drawable.student3),
        Student(8, "Lucía Fernández", "Ama la fotografía de paisajes.", R.drawable.student4),
        // Dashboard 3
        Student(9, "Elena Jiménez", "Exploradora urbana y viajera.", R.drawable.student1),
        Student(10, "Miguel Ángel", "Músico y compositor.", R.drawable.student2),
        Student(11, "Sofía Vargas", "Voluntaria en refugios de animales.", R.drawable.student3),
        Student(12, "Jorge Díaz", "Entusiasta del senderismo.", R.drawable.student4),
        // Dashboard 4
        Student(13, "Ricardo Vega", "Interesado en la robótica.", R.drawable.student1),
        Student(14, "Gabriela Solís", "Chef de repostería.", R.drawable.student2),
        Student(15, "Mateo Guerra", "Aficionado al cine clásico.", R.drawable.student3),
        Student(16, "Isabela Reyes", "Diseñadora gráfica freelance.", R.drawable.student4)
    )

    fun getStudentById(id: Int): Student? {
        return allStudents.find { it.id == id }
    }
}
