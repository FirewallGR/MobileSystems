package ru.meowmure.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import ru.meowmure.lab1.ui.theme.Lab1Theme

class SumDialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme{
                SumDialogScreen()
            }
        }
    }

    @Composable
    fun SumDialogScreen() {
        var showDialog by remember { mutableStateOf(false) }
        var number1 by remember { mutableStateOf(TextFieldValue()) }
        var number2 by remember { mutableStateOf(TextFieldValue()) }
        var sum by remember { mutableStateOf(0) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Кнопка для открытия диалога
            Button(onClick = { showDialog = true }) {
                Text(text = "Открыть диалог")
            }

            // Текст для отображения суммы
            Text(text = "Сумма: $sum", modifier = Modifier.padding(top = 16.dp))

            // Диалог для ввода чисел
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Введите числа") },
                    text = {
                        Column {
                            TextField(
                                value = number1,
                                onValueChange = { number1 = it },
                                label = { Text("Число 1") }

                            )
                            TextField(
                                value = number2,
                                onValueChange = { number2 = it },
                                label = { Text("Число 2") },
                            )
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                // Вычисляем сумму и закрываем диалог
                                val num1 = number1.text.toIntOrNull() ?: 0
                                val num2 = number2.text.toIntOrNull() ?: 0
                                sum = num1 + num2
                                showDialog = false
                            }
                        ) {
                            Text("Подтвердить")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { showDialog = false }) {
                            Text("Отмена")
                        }
                    }
                )
            }
            Button(onClick = { finish() }, modifier = Modifier.padding(top = 16.dp)) {
                Text(text = "Назад в меню")
            }
        }
    }
}
