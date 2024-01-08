package com.anonixteam.anonixvpn.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anonixteam.anonixvpn.R
import com.anonixteam.anonixvpn.ui.screens.destinations.MainScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ui.simplestories.Stories
import kotlin.random.Random

@Composable
@Destination
fun OnboardingScreen(
    navigator: DestinationsNavigator
) {
    val images = listOf(
        R.drawable.onboard_1,
        R.drawable.onboard_2,
        R.drawable.onboard_3,
        R.drawable.onboard_4,
        R.drawable.onboard_5,
    )
    val titles = listOf("Безопасность", "Широкий выбор серверов", "Быстрая скорость соединения")
    val contents = listOf(
        "Наш сервис обеспечивает высокий уровень безопасности для ваших данных, используя передовые технологии шифрования.",
        "У нас есть серверы по всему миру, что позволяет выбрать наиболее подходящий для вас сервер.",
        "Наши серверы оптимизированы для обеспечения высокой скорости соединения."
    )
    val buttons = listOf("Хорошо", "Отлично", "Понял!")

    Stories(numberOfPages = buttons.size, onComplete = {
        navigator.navigate(MainScreenDestination)
    }) {
        Image(
            painter = painterResource(id = images.random()),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.lighting(
                MaterialTheme.colorScheme.onBackground, MaterialTheme.colorScheme.onBackground
            ),
            modifier = Modifier.fillMaxSize()
        )


        Column(
            modifier = Modifier
                .padding(16.dp, 128.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = titles[it],
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = contents[it],
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.surface
                )
            }
            /*
                        Button(modifier = Modifier
                            .align(Alignment.End)
                            .padding(16.dp, 0.dp), onClick = {

                        }) {
                            Text(text = buttons[it])
                        }*/
        }
    }
}