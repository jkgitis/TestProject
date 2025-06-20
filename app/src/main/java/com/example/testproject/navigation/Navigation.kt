package com.example.testproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testproject.CreateAccount
import com.example.testproject.Onboarding
import com.example.testproject.ResetEmail
import com.example.testproject.ResetPasswordScreen
import com.example.testproject.screens.*

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("login") {
            SignInScreen(navController)
        }
        composable("loginPassword") {
            LoginPassword(navController)
        }
        composable("createAccount") {
            CreateAccount(navController)
        }
        composable("resetPassword") {
            ResetPasswordScreen(navController)
        }
        composable("resetEmail") {
            ResetEmail(navController)
        }
        composable("onboarding") {
            Onboarding(navController)
        }
    }
}


