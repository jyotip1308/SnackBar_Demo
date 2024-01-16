package com.android.snackbardemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackBar()
        }
    }
}

@Composable
fun SnackBar(){
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope : CoroutineScope = rememberCoroutineScope()

    Scaffold (scaffoldState = scaffoldState) {it
        Button(onClick = {
            coroutineScope.launch {
               val snackBarResult =  scaffoldState.snackbarHostState.showSnackbar(
                    message = "This is the message",
                    actionLabel = "Undo",
                    duration = SnackbarDuration.Long
                )
                when(snackBarResult){
                    SnackbarResult.ActionPerformed -> Log.i("Jyoti", "Action label clicked")
                    SnackbarResult.Dismissed -> Log.i("Jyoti", "Dismissed")
                    else -> {

                    }
                }
            }
        }) {
            Text(text = "Show Snack Bar ")
        }

    }
}




