package com.pogachacha.educationgames.ui.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.pogachacha.educationgames.ui.viewmodels.MenuViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@Composable
@Destination
@RootNavGraph(start = true)
fun MenuScreen (menuViewModel: MenuViewModel = hiltViewModel()){

}