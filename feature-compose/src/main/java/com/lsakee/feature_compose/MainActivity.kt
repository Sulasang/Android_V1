package com.lsakee.feature_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lsakee.suwon_sulasang.design_system.style.Suwon_SulasangTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Suwon_SulasangTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.White)
            .padding(start = 20.dp, top = 60.dp) // 시작 마진과 상단 마진 설정
    ) {
        Text(
            text = "반가워요:)\n오늘의 학식을 확인해보세요!",
            modifier = Modifier.padding(16.dp),
            style = TextStyle.Default.copy(
//                fontFamily = FontFamily.Serif,
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold
            ),
            color = Color.Red
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Suwon_SulasangTheme {
        Greeting("Android")
    }
}