package com.paladinsandallgame.upominashka.ui.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.paladinsandallgame.upominashka.ui.viewmodels.StartViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@Composable
@Destination
@RootNavGraph(start = true)
fun MenuScreen (menuViewModel: StartViewModel = hiltViewModel()){

}