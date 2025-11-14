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
fun PromedioGrupoVista(estudiantes: List<Estudiante>) {
    val promediosPorGrupo = estudiantes.groupBy { it.group }
        .mapValues { entry ->
            entry.value.map { it.score }.average()
        }
        .entries
        .sortedByDescending { it.value }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(promediosPorGrupo.toList()) { (grupo, promedio) ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Grupo: $grupo",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Promedio: %.2f".format(promedio),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}