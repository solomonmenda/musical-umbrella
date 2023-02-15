package com.example.incremeter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.incremeter.ui.theme.IncremeterTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncremeterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var name by remember {
        mutableStateOf("")
    }
    var names by remember {
        mutableStateOf(listOf<String>())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { text ->
                    name = text
                },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp) )
            Button(onClick = {
                if(name.isNotBlank()){
                    names = names + name
                }
                name=""
            }) {
                Text(text = "add")
            }
        }

        LazyColumn {
            items(names) { currentItem ->
                Text(text = currentItem,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))

            }
        }
        Divider()
    }

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IncremeterTheme {
        Greeting()
    }
}