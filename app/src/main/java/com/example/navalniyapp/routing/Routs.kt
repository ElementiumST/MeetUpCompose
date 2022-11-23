package com.example.meetup.routing

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.meetup.ui.auth.view.SignInScreen
import com.example.meetup.ui.auth.view.SignUpScreen
import com.example.meetup.ui.splash.view.LoadScreen

fun NavGraphBuilder.getRouts() {
    composable(Screens.Loading.Splash.route) {
        LoadScreen()
    }
    composable(Screens.Auth.SignIn.route) {
        SignInScreen()
    }
    composable(Screens.Auth.SignUp.route) {
        SignUpScreen()
    }
}