package com.goldmedal.jettrivia.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.goldmedal.jettrivia.component.Questions

@Composable
fun TriviaHome(viewModel: QuestionsViewModel = hiltViewModel()) {
    Questions(viewModel)
}