package com.anonixteam.anonixvpn.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.anonixteam.anonixvpn.ui.fragments.navbar.MainNavBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun SettingsScreen(
    navigator: DestinationsNavigator, navController: NavController
) {
    Scaffold(bottomBar = {
        MainNavBar(navController, navigator)
    }) {
        Box(Modifier.padding(it)) {

        }
    }
}