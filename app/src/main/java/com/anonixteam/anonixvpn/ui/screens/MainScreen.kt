package com.anonixteam.anonixvpn.ui.screens

import androidx.compose.material3.IconButton
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExtendedFloatingActionButton
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Size
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
import coil.compose.AsyncImage
import com.anonixteam.anonixvpn.R
import com.anonixteam.anonixvpn.ui.fragments.headers.MainScreenHeader
import com.anonixteam.anonixvpn.ui.fragments.indicator.PulseLoadingIndicator
import com.anonixteam.anonixvpn.ui.viewmodels.StartViewModel
import com.anonixteam.anonixvpn.utils.NetworkUtils
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@Composable
@RootNavGraph(start = true)
@Destination
fun MainScreen(menuViewModel: StartViewModel = hiltViewModel()) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            MainScreenHeader()
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row {
                        AsyncImage(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape),
                            model = "https://raw.githubusercontent.com/hampusborgos/country-flags/main/png250px/ru.png",
                            contentDescription = "Country icon",
                            contentScale = ContentScale.Crop
                        )
                        
                        Text(text = "Russia")
                    }

                    PulseLoadingIndicator(
                        false,
                        size = 250f,
                        color = MaterialTheme.colorScheme.primaryContainer
                    ) {
                        Button(
                            modifier = Modifier
                                .size(180.dp)
                                .clip(CircleShape),
                            onClick = { /*TODO*/ }) {
                            Icon(
                                modifier = Modifier.size(64.dp),
                                painter = painterResource(id = R.drawable.power),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}