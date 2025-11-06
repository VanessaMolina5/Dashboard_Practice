package com.example.cuartitosa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cuartitosa.ui.theme.CuartitosATheme
import com.example.cuartitosa.viewModels.CoroutineViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: CoroutineViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CuartitosATheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(innerPadding, viewModel)
                }
            }
        }
    }
}


@Composable
fun Content(paddingValues: PaddingValues, viewModel: CoroutineViewModel){
    Column(
        modifier= Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick={
                viewModel.callToApi()
            },
            enabled = !viewModel.isLoading.value
        ){
            Text("Call API (No bloquea)")
        }

        Spacer(modifier=Modifier.height(10.dp))

        Button(
            onClick={
                viewModel.block()
            },
            enabled = !viewModel.isLoading.value
        ){
            Text("Block Thread (Congela la UI)")
        }

        Spacer(modifier=Modifier.height(20.dp))

        if (viewModel.isLoading.value){
            CircularProgressIndicator()
        }

        if (viewModel.result.value.isNotEmpty()){
            Text(viewModel.result.value)
        }
    }
}
