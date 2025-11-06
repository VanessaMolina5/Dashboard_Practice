package com.example.cuartitosa.screens



import com.example.cuartitosa.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.cuartitosa.components.StudentItem
import com.example.cuartitosa.model.Student

@Composable
fun Dashboard2(navController: NavHostController) {

    val students = listOf(
        Student(5, "Carlos Ruiz", "Fanático de la ciencia ficción.", R.drawable.student1),
        Student(6, "Ana Torres", "Interesada en la biología marina.", R.drawable.student2),
        Student(7, "Pedro Morales", "Experto en videojuegos retro.", R.drawable.student3),
        Student(8, "Lucía Fernández", "Ama la fotografía de paisajes.", R.drawable.student4),

        )

    LazyColumn {
        items(students) { student ->
            StudentItem(student) {
                navController.navigate("detail/${student.id}")
            }
        }
    }
}
