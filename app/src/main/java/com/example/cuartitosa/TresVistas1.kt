package com.example.cuartitosa

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun TresVistas1(estudiantes: MutableList<Estudiante>) {
    var vistaSeleccionada by remember { mutableIntStateOf(0) }

    Column {
        TabRow(selectedTabIndex = vistaSeleccionada) {
            Tab(
                selected = vistaSeleccionada == 0,
                onClick = { vistaSeleccionada = 0 },
                text = { Text("Dashboard") }
            )
            Tab(
                selected = vistaSeleccionada == 1,
                onClick = { vistaSeleccionada = 1 },
                text = { Text("Editar") }
            )
            Tab(
                selected = vistaSeleccionada == 2,
                onClick = { vistaSeleccionada = 2 },
                text = { Text("Agregar") }
            )
        }

        when (vistaSeleccionada) {
            0 -> DashboardVista(estudiantes)
            1 -> EditarVista(estudiantes)
            2 -> AgregarVista(estudiantes)
        }
    }
}