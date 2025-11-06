package com.example.cuartitosa.screens

import com.example.cuartitosa.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.cuartitosa.components.StudentItem
import com.example.cuartitosa.model.Student

@Composable
fun Dashboard4(navController: NavHostController) {

    val students = listOf(
        Student(13, "Ricardo Vega", "Interesado en la robótica.", R.drawable.student1),
        Student(14, "Gabriela Solís", "Chef de repostería.", R.drawable.student2),
        Student(15, "Mateo Guerra", "Aficionado al cine clásico.", R.drawable.student3),
        Student(16, "Isabela Reyes", "Diseñadora gráfica freelance.", R.drawable.student4),
    )

    LazyColumn {
        items(students) { student ->
            StudentItem(student) {
                navController.navigate("detail/${student.id}")
            }
        }
    }
}

