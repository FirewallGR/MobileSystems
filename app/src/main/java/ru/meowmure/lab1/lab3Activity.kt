package ru.meowmure.lab1

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter


class ButtonActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun MyApp() {
        var inputNumber by remember { mutableStateOf("") }
        var isButtonPressed by remember { mutableStateOf(false) }
        var buttonStateText by remember { mutableStateOf("Отпущена") }
        var listStateText by remember { mutableStateOf("") }
        var clickCount by remember { mutableStateOf(0) }
        var selectedDate by remember { mutableStateOf(LocalDate.now()) } // Состояние для хранения выбранной даты
        var selectedTime by remember { mutableStateOf(LocalTime.now()) } // Состояние для хранения выбранного времени
        var selectedItem by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Текстовое поле для ввода числа
            TextField(
                value = inputNumber,
                onValueChange = { inputNumber = it },
                label = { Text("Введите число") },
                placeholder = { Text("0") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Кнопка, которая сохраняет визуальное состояние
            Button(
                onClick = {
                    isButtonPressed = !isButtonPressed
                    buttonStateText = if (isButtonPressed) "Нажата" else "Отпущена"
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = if (isButtonPressed) Color.Green else Color.Blue
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = if (isButtonPressed) "Отпустить" else "Нажми меня", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Текстовое поле для отображения состояния кнопки
            Text(
                text = buttonStateText,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )

            Button(onClick = { finish() }, modifier = Modifier.padding(top = 16.dp)) {
                Text(text = "Назад в меню")

            }

            Button(
                onClick = { clickCount++ }, // Увеличиваем счетчик нажатий
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Количество нажатий: $clickCount", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Селектор даты
            DatePicker(selectedDate) { newDate ->
                selectedDate = newDate
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Отображение выбранной даты
            Text(
                text = "Выбранная дата: ${selectedDate.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))}",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Селектор времени
            TimePicker(selectedTime) { newTime ->
                selectedTime = newTime
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Отображение выбранного времени
            Text(
                text = "Выбранное время: ${selectedTime.format(DateTimeFormatter.ofPattern("HH:mm"))}",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Выпадающий список
            DropdownMenuExample(selectedItem) { newItem ->
                selectedItem = newItem
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Отображение выбранного элемента из выпадающего списка
            Text(
                text = "Выбранный элемент: $selectedItem",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun DatePicker(selectedDate: LocalDate, onDateSelected: (LocalDate) -> Unit) {
        // Здесь можно использовать диалог выбора даты или другой компонент
        // Для простоты мы просто создадим кнопку, которая будет менять дату
        Button(onClick = {
            // Здесь можно добавить логику для выбора даты, например, диалог выбора даты
            onDateSelected(selectedDate.plusDays(1)) // Увеличиваем дату на 1 день для примера
        }) {
            Text("Выбрать дату")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun TimePicker(selectedTime: LocalTime, onTimeSelected: (LocalTime) -> Unit) {
        // Здесь можно использовать диалог выбора времени или другой компонент
        // Для простоты мы просто создадим кнопку, которая будет менять время
        Button(onClick = {
            // Здесь можно добавить логику для выбора времени, например, диалог выбора времени
            onTimeSelected(selectedTime.plusHours(1)) // Увеличиваем время на 1 час для примера
        }) {
            Text("Выбрать время")
        }
    }

    @Composable
    fun DropdownMenuExample(selectedItem: String, onItemSelected: (String) -> Unit) {
        var expanded by remember { mutableStateOf(false) }
        val items = listOf("Первый", "Второй", "Третий")

        Column {
            Button(onClick = { expanded = true }) {
                Text("Выбрать элемент")
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(item) },
                        onClick = {
                            onItemSelected(item) // Вызываем функцию обратного вызова
                            expanded = false // Закрываем меню после выбора
                        }
                    )
                }
            }
        }
    }
}



