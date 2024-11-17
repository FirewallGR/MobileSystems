package ru.meowmure.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import ru.meowmure.lab1.ui.theme.Lab1Theme

class AnimationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme {
                AnimatedSquare()
            }
        }
    }
    @Composable
    fun AnimatedSquare(modifier: Modifier = Modifier) {
        // Состояние для анимации
        var isAnimating by remember { mutableStateOf(false) }

        // Анимация размера квадрата
        val size by animateDpAsState(if (isAnimating) 200.dp else 100.dp)

        // Анимация вертикального смещения
        val offsetY by animateDpAsState(if (isAnimating) 300.dp else 0.dp)

        // Запускаем анимацию при нажатии на квадрат
        LaunchedEffect(isAnimating) {
            if (isAnimating) {
                delay(1000) // Задержка перед завершением анимации
                isAnimating = false // Завершаем анимацию через секунду
            }
        }
        Column(modifier = Modifier
            .fillMaxSize(),
        ) {
            // Основной контейнер
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .clickable { isAnimating = true } // Запуск анимации по клику
            ) {
                // Рисуем квадрат
                Canvas(
                    modifier = Modifier
                        .size(size)
                        .offset(x = (LocalConfiguration.current.screenWidthDp.dp - size) / 2, y = offsetY) // Применяем смещение по оси Y
                ) {
                    drawRect(
                        color = Color.Blue,
                        size = Size(size.toPx(), size.toPx()) // Квадрат с анимированным размером
                    )
                }
            }
        }
        Column (modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { finish() }, modifier = Modifier.padding(top = 16.dp)) {
                Text(text = "Назад в меню")
            }
        }

    }
}