package com.example.cuartitosa.screens
import com.example.cuartitosa.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.cuartitosa.components.StudentItem
import com.example.cuartitosa.model.Student

@Composable
fun Dashboard1(navController: NavHostController) {
    val students = listOf(
        Student(1, "María López", "Apasionada por la programación.", R.drawable.student1),
        Student(2, "Juan Pérez", "Le gusta la astronomía.", R.drawable.student2),
        Student(3, "Vanessa Molina", "Apasionada por la química y el universo.", R.drawable.student3),
        Student(4, "David Gómez", "Apasionado por la gastronomía.", R.drawable.student4),

    )

    LazyColumn {
        items(students) { student ->
            StudentItem(student) {
                navController.navigate("detail/${student.id}")
            }
        }
    }
}


