package com.example.cuartitosa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.cuartitosa.ui.theme.CuartitosATheme
import com.example.cuartitosa.ui.theme.CuartitosATheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuartitosATheme {
                var tabSeleccionado by remember { mutableIntStateOf(0) }
                val estudiantes = remember { mutableStateListOf<Estudiante>() }

                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text("Sistema de Estudiantes") },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        )
                    }
                ) { paddingValues ->
                    Column(modifier = Modifier.padding(paddingValues)) {
                        TabRow(selectedTabIndex = tabSeleccionado) {
                            Tab(
                                selected = tabSeleccionado == 0,
                                onClick = { tabSeleccionado = 0 },
                                text = { Text("3 Vistas") }
                            )
                            Tab(
                                selected = tabSeleccionado == 1,
                                onClick = { tabSeleccionado = 1 },
                                text = { Text("3 Vistas") }
                            )
                        }
                        when (tabSeleccionado) {
                            0 -> TresVistas1(estudiantes)
                            1 -> TresVistas2(estudiantes)
                        }
                    }
                }
            }
        }
    }
}



