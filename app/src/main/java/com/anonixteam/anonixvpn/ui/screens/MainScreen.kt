package com.anonixteam.anonixvpn.ui.screens

import androidx.compose.material3.IconButton
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExtendedFloatingActionButton
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.Person
import androidx.compose.material.icons.twotone.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigator
import coil.compose.AsyncImage
import com.anonixteam.anonixvpn.R
import com.anonixteam.anonixvpn.data.common.navigation.BottomBarDestination
import com.anonixteam.anonixvpn.ui.fragments.headers.MainScreenHeader
import com.anonixteam.anonixvpn.ui.fragments.indicator.PulseDisconnectIndicator
import com.anonixteam.anonixvpn.ui.fragments.indicator.PulseLoadingIndicator
import com.anonixteam.anonixvpn.ui.fragments.navbar.MainNavBar
import com.anonixteam.anonixvpn.ui.viewmodels.StartViewModel
import com.anonixteam.anonixvpn.utils.NetworkUtils
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@RootNavGraph(start = true)
@Destination
fun MainScreen(navigator: DestinationsNavigator, navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(bottomBar = {
            MainNavBar(navController, navigator)
        }) {
            MainScreenContent(it)
        }
    }
}

@Composable
private fun MainScreenContent(it: PaddingValues) {
    //TODO("КИНУТЬ В VIEWMODEL")
    var mutableStateBtn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(16.dp)
    ) {
        MainScreenHeader()
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            AsyncImage(
                                modifier = Modifier
                                    .size(MaterialTheme.typography.displayMedium.fontSize.value.dp)
                                    .clip(CircleShape),
                                model = "https://raw.githubusercontent.com/hampusborgos/country-flags/main/png250px/ru.png",
                                contentDescription = "Country icon",
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = "Russia",
                                style = MaterialTheme.typography.displayMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }

                    Text(
                        text = "Disconnected",
                        style = MaterialTheme.typography.displaySmall,
                        color = MaterialTheme.colorScheme.error
                    )
                }
                VpnPowerButton(mutableStateBtn) {
                    mutableStateBtn = it
                }
            }
        }
    }
}

@Composable
private fun VpnPowerButton(buttonState: Boolean, onClick: (newState: Boolean) -> Unit) {
    if (buttonState) {
        PulseLoadingIndicator(
            false,
            size = 250f,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Button(
                modifier = Modifier
                    .size(180.dp)
                    .clip(CircleShape),
                onClick = { onClick(!buttonState) }) {
                Icon(
                    modifier = Modifier.size(64.dp),
                    painter = painterResource(id = R.drawable.power),
                    contentDescription = null
                )
            }
        }
    } else {
        PulseDisconnectIndicator(
            size = 250f,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            OutlinedButton(
                modifier = Modifier
                    .size(180.dp),
                shape = CircleShape,
                border = BorderStroke(2.dp, MaterialTheme.colorScheme.onSurface),
                onClick = { onClick(!buttonState) }) {
                Icon(
                    modifier = Modifier.size(64.dp),
                    painter = painterResource(id = R.drawable.power),
                    contentDescription = null
                )
            }
        }
    }
}
