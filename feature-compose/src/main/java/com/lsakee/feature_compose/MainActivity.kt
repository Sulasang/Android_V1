package com.lsakee.feature_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lsakee.suwon_sulasang.design_system.style.icon.SulasangIcon
import com.lsakee.suwon_sulasang.design_system.style.theme.Suwon_SulasangTheme
import com.lsakee.suwon_sulasang.design_system.style.typography.SubHead
import com.lsakee.suwon_sulasang.design_system.style.typography.Title

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
                    HomeScreen("Android")
                }
            }
        }
    }
}

@Composable
fun HomeScreen(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.White)
            .padding(start = 20.dp, top = 60.dp) // 시작 마진과 상단 마진 설정
    ) {
        val menuDateText = remember { mutableStateOf("09.09 (금)") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Title(
                text = "반가워요:)\n오늘의 학식을 확인해보세요!",
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 44.dp)
            ) {
                Icon(
                    painter = painterResource(id = SulasangIcon.Navi_Left.drawableId),
                    contentDescription = SulasangIcon.Navi_Left.contentDescription,
                    modifier = Modifier
                        .clickable { /* Handle left arrow click */ }
                )
                SubHead(
                    text = menuDateText.value,
                    modifier = Modifier
                        .padding(vertical = 10.dp),
                )
                Icon(
                    painter = painterResource(id = SulasangIcon.Navi_Right.drawableId),
                    contentDescription = SulasangIcon.Navi_Right.contentDescription,
                    modifier = Modifier
                        .clickable { /* Handle right arrow click */ }
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Suwon_SulasangTheme {
        HomeScreen("Android")
    }
}