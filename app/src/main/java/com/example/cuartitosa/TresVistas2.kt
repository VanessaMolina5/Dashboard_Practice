package com.example.cuartitosa

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun TresVistas2(estudiantes: List<Estudiante>) {
    var vistaSeleccionada by remember { mutableIntStateOf(0) }

    Column {
        TabRow(selectedTabIndex = vistaSeleccionada) {
            Tab(
                selected = vistaSeleccionada == 0,
                onClick = { vistaSeleccionada = 0 },
                text = { Text("Promedio por Grupo") }
            )
            Tab(
                selected = vistaSeleccionada == 1,
                onClick = { vistaSeleccionada = 1 },
                text = { Text("Alumno con Mayor Rezago") }
            )
            Tab(
                selected = vistaSeleccionada == 2,
                onClick = { vistaSeleccionada = 2 },
                text = { Text("Top 3 Mayor Promedio") }
            )
        }

        when (vistaSeleccionada) {
            0 -> PromedioGrupoVista(estudiantes)
            1 -> AlumnoMayorRezagoVista(estudiantes)
            2 -> Top3MayorPromedioVista(estudiantes)
        }
    }
}