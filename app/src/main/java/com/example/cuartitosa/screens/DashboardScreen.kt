package com.example.cuartitosa.screens
import com.example.cuartitosa.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cuartitosa.components.StudentItem
import com.example.cuartitosa.model.Student

@Composable
fun DashboardScreen(navController: NavHostController) {
    val students = listOf(
        Student(1, "María López", "Apasionada por la programación.", R.drawable.student1),
        Student(2, "Juan Pérez", "Le gusta la astronomía.", R.drawable.student2),
        Student(3, "Vanessa Molina", "Apasionada por la química y el universo.", R.drawable.student3),
        Student(4, "David Gómez", "Apasionado por la gastronomía.", R.drawable.student4),
    )

    Column {
        Text(
            text = "Lista de Estudiantes",
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(students) { student ->
                StudentItem(student) {
                    navController.navigate("detail/${student.id}")
                }
            }
        }
    }
}
