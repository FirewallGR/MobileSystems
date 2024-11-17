package ru.meowmure.lab1
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import ru.meowmure.lab1.ui.theme.Lab1Theme
import kotlin.math.cos
import kotlin.math.sin
class RectangleTransform : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme{
                CenteredRectangle()
            }
        }
    }


    @Composable
    fun CenteredRectangle(modifier: Modifier = Modifier) {
        val squareSize = 100.dp
        val offset = 400f // Положение квадрата по оси X и Y

        // Конвертируем dp в пиксели для Canvas
        val squareSizePx = with(LocalDensity.current) { squareSize.toPx() }
        val rectangleHeight = squareSize / 2 // Высота прямоугольника
        val rectangleHeightPx = with(LocalDensity.current) { rectangleHeight.toPx() }
        // Получаем размеры экрана
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val screenHeight = configuration.screenHeightDp.dp

        // Конвертируем размеры экрана в пиксели
        val screenWidthPx = with(LocalDensity.current) { screenWidth.toPx() }
        val screenHeightPx = with(LocalDensity.current) { screenHeight.toPx() }

        // Рассчитываем центр экрана
        val centerX = screenWidthPx / 2
        val centerY = screenHeightPx / 2
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(modifier = Modifier
//                    .fillMaxSize()
                .size(100.dp)
                .background(color = Color.Black)
            ) {}
            // Прямоугольник с трансформациями
            Canvas(Modifier.size(100.dp).offset(-15.dp)) {
                rotate(135f) {
                    drawRect(
                        color = Color.Black,
                        size = Size(squareSizePx, rectangleHeightPx) // Прямоугольник с шириной в 100.dp и высотой в 50.dp
                    )
                }
            }
            Button(onClick = { finish() }, modifier = Modifier.padding(top = 16.dp)) {
                Text(text = "Назад в меню")
            }
        }
    }
}