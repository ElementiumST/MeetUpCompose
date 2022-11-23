package com.example.meetup.routing

object Screens {
    sealed class Loading(val route: String) {
        object Splash : Loading("splash")
    }
    sealed class Auth(val route: String) {
        object SignIn : Auth("signIn")
        object SignUp: Auth("signUp")
    }
    sealed class Home(val route: String) {
        object NewsPage : Home("newsPage")
        object Map: Home("map")
        object Profile: Home("profile")
    }
}