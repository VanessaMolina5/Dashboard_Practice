package com.example.cuartitosa

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Top3MayorPromedioVista(estudiantes: List<Estudiante>) {
    val top3 = estudiantes.sortedByDescending { it.score }.take(3)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(top3) { estudiante ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "${estudiante.name} ${estudiante.lastName}",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text("Grado: ${estudiante.grade}")
                        Text("Grupo: ${estudiante.group}")
                    }
                    Text(
                        text = "%.2f".format(estudiante.score),
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}