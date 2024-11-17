package ru.meowmure.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

class SquaresRowColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Обернем в Surface для применения темы
            Surface(color = MaterialTheme.colorScheme.background) {
                SquaresScreen()
            }
        }
    }



    @Composable
    fun SquaresScreen(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Первая строка с тремя квадратами
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Red)
                )
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Green)
                )
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Blue)
                )
            }

            // Вторая строка с одним квадратом, пустым местом и еще одним квадратом
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Magenta)
                )
                // Пустое место во второй колонке
                Spacer(modifier = Modifier.size(100.dp))
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Black)
                )
            }

            // Кнопка для возврата в меню
            Button(onClick = { finish() }, modifier = Modifier.padding(top = 16.dp)) {
                Text(text = "Назад в меню")
            }
        }
    }
}
