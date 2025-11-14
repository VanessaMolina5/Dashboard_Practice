package com.example.cuartitosa

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AlumnoMayorRezagoVista(estudiantes: List<Estudiante>) {
    val alumnoMenorScore = estudiantes.minByOrNull { it.score }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (alumnoMenorScore != null) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Alumno con Mayor Rezago",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.error
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${alumnoMenorScore.name} ${alumnoMenorScore.lastName}",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text("Grado: ${alumnoMenorScore.grade}")
                    Text("Grupo: ${alumnoMenorScore.group}")
                    Text(
                        text = "Score: %.2f".format(alumnoMenorScore.score),
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        } else {
            Text(
                text = "No hay estudiantes registrados",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}