package com.example.cuartitosa

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditarVista(estudiantes: MutableList<Estudiante>) {
    var estudianteSeleccionado by remember { mutableStateOf<Estudiante?>(null) }
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var grade by remember { mutableStateOf("") }
    var group by remember { mutableStateOf("") }
    var score by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(estudiantes) { estudiante ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        estudianteSeleccionado = estudiante
                        name = estudiante.name
                        lastName = estudiante.lastName
                        grade = estudiante.grade
                        group = estudiante.group
                        score = estudiante.score.toString()
                    }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("${estudiante.name} ${estudiante.lastName}")
                        Icon(Icons.Default.Edit, contentDescription = null)
                    }
                }
            }
        }

        estudianteSeleccionado?.let {
            Divider()

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Last Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = grade,
                onValueChange = { grade = it },
                label = { Text("Grade") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = group,
                onValueChange = { group = it },
                label = { Text("Group") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = score,
                onValueChange = { score = it },
                label = { Text("Score") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val index = estudiantes.indexOf(it)
                    if (index != -1) {
                        estudiantes[index] = Estudiante(
                            id = it.id,
                            name = name,
                            lastName = lastName,
                            grade = grade,
                            group = group,
                            score = score.toDoubleOrNull() ?: 0.0
                        )
                        estudianteSeleccionado = null
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Actualizar")
            }
        }
    }
}