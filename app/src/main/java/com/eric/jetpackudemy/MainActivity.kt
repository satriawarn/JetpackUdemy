@file:OptIn(ExperimentalMaterial3Api::class)

package com.eric.jetpackudemy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val greetingListState = remember {
        mutableStateListOf<String>("John", "Lennon")
    }

    val newNameStateContent = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GreetingList(greetingListState, {
            greetingListState.add(newNameStateContent.value )
        }, newNameStateContent.value, { newName ->
            newNameStateContent.value = newName
        })
    }
}

@Composable
fun GreetingList(
    nameList: List<String>,
    buttonClick: () -> Unit,
    textFieldValue: String,
    textFieldUpdate: (newName: String) -> Unit
) {
    for (name in nameList) {
        Greeting(name = name)
    }

    TextField(value = textFieldValue, onValueChange = textFieldUpdate)

    Button(onClick = buttonClick) {
        Text(text = "Add New Name")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.headlineLarge,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}