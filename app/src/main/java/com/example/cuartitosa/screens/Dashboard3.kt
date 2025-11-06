package com.example.cuartitosa.screens



import com.example.cuartitosa.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.cuartitosa.components.StudentItem
import com.example.cuartitosa.model.Student

@Composable
fun Dashboard3(navController: NavHostController) {

    val students = listOf(
        Student(9, "Elena Jiménez", "Exploradora urbana y viajera.", R.drawable.student1),
        Student(10, "Miguel Ángel", "Músico y compositor.", R.drawable.student2),
        Student(11, "Sofía Vargas", "Voluntaria en refugios de animales.", R.drawable.student3),
        Student(12, "Jorge Díaz", "Entusiasta del senderismo.", R.drawable.student4),
    )

    LazyColumn {
        items(students) { student ->
            StudentItem(student) {
                navController.navigate("detail/${student.id}")
            }
        }
    }
}