package ru.meowmure.lab1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.meowmure.lab1.ui.theme.Lab1Theme

class TaskMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme {
                TaskMenuScreen()
            }
        }
    }

    @Composable
    fun TaskMenuScreen(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Выберите задание:", modifier = Modifier.padding(bottom = 16.dp))

            Button(onClick = {
                val intent = Intent(this@TaskMenuActivity, CounterActivity::class.java)
                startActivity(intent)
            }) {
                Text(text = "Задание 1: Счетчик")
            }

            Button(onClick = {
                val intent = Intent(this@TaskMenuActivity, SquaresActivity::class.java)
                startActivity(intent)
            }) {
                Text(text = "Задание 2.1: Квадраты")
            }

            Button(onClick = {
                val intent = Intent(this@TaskMenuActivity, SquaresRowColumnActivity::class.java)
                startActivity(intent)
            }) {
                Text(text = "Задание 2.2: Квадраты")
            }

            Button(onClick = {
                val intent = Intent(this@TaskMenuActivity, RectangleTransform::class.java)
                startActivity(intent)
            }) {
                Text(text = "Задание 2.3: Преобразования квадрата")
            }

            Button(onClick = {
                val intent = Intent(this@TaskMenuActivity, AnimationActivity::class.java)
                startActivity(intent)
            }) {
                Text(text = "Задание 2.4: Анимация квадрата")
            }

            Button(onClick = {
                val intent = Intent(this@TaskMenuActivity, SumDialogActivity::class.java)
                startActivity(intent)
            }) {
                Text(text = "Задание 2.5: Калькулирования")
            }

            Button(onClick = {
                val intent = Intent(this@TaskMenuActivity, ButtonActivity::class.java)
                startActivity(intent)
            }) {
                Text(text = "Задание 3: Кнопки")
            }

            // Здесь можно добавить больше кнопок для других заданий
            // Например:
            // Button(onClick = { /* обработка других заданий */ }) {
            //     Text(text = "Задание 2: Другие функции")
            // }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TaskMenuScreenPreview() {
        Lab1Theme {
            TaskMenuScreen()
        }
    }
}

