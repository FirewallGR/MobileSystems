package ru.meowmure.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.meowmure.lab1.ui.theme.Lab1Theme

class CounterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme {
                CounterScreen()
            }
        }
    }

    @Composable
    fun CounterScreen(modifier: Modifier = Modifier) {
        // Состояние для счетчика
        val count = remember { mutableStateOf(0) }

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Отображение текущего значения счетчика
            Text(
                text = "Счетчик: ${count.value}",
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Кнопка для увеличения счетчика
            Button(onClick = { count.value += 1 }) {
                Text(text = "Увеличить счетчик")
            }

            // Кнопка для возврата в меню
            Button(onClick = { finish() }, modifier = Modifier.padding(top = 16.dp)) {
                Text(text = "Назад в меню")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun CounterScreenPreview() {
        Lab1Theme {
            CounterScreen()
        }
    }
}
