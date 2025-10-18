package com.example.cuartitosa.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cuartitosa.R

@Composable
fun DetailScreen(studentId: Int) {
    val student = when (studentId) {
        1 -> Triple("María López", "Apasionada por la programación.", R.drawable.student1)
        2 -> Triple("Juan Pérez", "Le gusta la astronomía.", R.drawable.student2)
        3 -> Triple("Vanessa Molina", "Apasionada por la química y el universo.", R.drawable.student3)
        4 -> Triple("David Gómez", "Apasionado por la gastronomía.", R.drawable.student4)
        else -> Triple("Desconocido", "Sin información.", R.drawable.student1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = student.third),
            contentDescription = student.first,
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(student.first, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text(student.second, fontSize = 16.sp)
    }
}
