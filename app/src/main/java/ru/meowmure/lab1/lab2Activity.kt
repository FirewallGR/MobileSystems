package ru.meowmure.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SquaresActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // Создаем Surface
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        // Зеленый квадрат
                        Box(
                            modifier = Modifier
                                .layout { measurable, constraints ->
                                    val placeable = measurable.measure(constraints)
                                    layout(placeable.width, placeable.height) {
                                        placeable.placeRelative(0, 0) // Положение верхнего левого угла
                                    }
                                }
                                .size(100.dp)
                                .background(Color.Green)
                                .align(Alignment.Center)
                        )
                        // Красный квадрат с смещением
                        Box(
                            modifier = Modifier
                                .layout { measurable, constraints ->
                                    val placeable = measurable.measure(constraints)
                                    layout(placeable.width, placeable.height) {
                                        placeable.placeRelative(-260, -140) // Сдвиг вправо на 100dp
                                    }
                                }
                                .size(100.dp)
                                .background(Color.Red)
                                .align(Alignment.Center)
                        )
                        // Синий квадрат с другим смещением
                        Box(
                            modifier = Modifier
                                .layout { measurable, constraints ->
                                    val placeable = measurable.measure(constraints)
                                    layout(placeable.width, placeable.height) {
                                        placeable.placeRelative(140, -140) // Сдвиг вправо на 50dp и вверх на 50dp
                                    }
                                }
                                .size(100.dp)
                                .background(Color.Blue)
                                .align(Alignment.Center)
                        )
                    }
                }
                Button(onClick = { finish() }, modifier = Modifier.padding(top = 16.dp)) {
                    Text(text = "Назад в меню")

                }
            }
        }
    }
}


//class SquaresActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MaterialTheme {
//                SquaresScreen()
//            }
//        }
//    }
//
//    @Composable
//    fun SquaresScreen(modifier: Modifier = Modifier) {
//        Box(
//            modifier = Modifier
//            .size(100.dp)
//            .background(Color.Green)
//                .offset (x = 100.dp, y = 50.dp)
//        ) {}
////        Column(
////            modifier = modifier
////                .fillMaxSize()
////                .padding(16.dp),
////            verticalArrangement = Arrangement.Center,
////            horizontalAlignment = Alignment.CenterHorizontally
////        ) {
////            Box(
////                modifier = Modifier.fillMaxWidth(),
////                contentAlignment = Alignment.Center
////            ) {
////                // Зеленый квадрат
////                Box(
////                    modifier = Modifier
////                        .size(100.dp)
////                        .background(Color.Green)
////                )
////
////                // Красный квадрат
////                Box(
////                    modifier = Modifier
////                        .size(100.dp)
////                        .background(Color.Red)
////                        .offset(x = 100.dp, y = 0.dp) // Сдвиг вправо
////                )
////
////                // Синий квадрат
////                Box(
////                    modifier = Modifier
////                        .size(100.dp)
////                        .background(Color.Blue)
////                        .offset(x = 100.dp, y = -50.dp) // Сдвиг вправо и вверх
////                )
////            }
//
////            // Кнопка для возврата в меню
////            Button(onClick = { /* Ваш код для возврата в меню */ }, modifier = Modifier.padding(top = 16.dp)) {
////                Text(text = "Назад в меню")
////            }
////        }
//    }
//
//
//    @Preview(showBackground = true)
//    @Composable
//    fun SquaresScreenPreview() {
//        MaterialTheme {
//            SquaresScreen()
//        }
//    }
//}