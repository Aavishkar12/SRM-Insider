package com.example.srminsider

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {
            LoginScreen(navController)
        }

        composable("home") {
            HomeScreen(navController) // ✅ added
        }

        // ✅ ADD THIS BLOCK ONLY
        composable("profile") {
            ProfileScreenWrapper(navController)
        }
        composable("notifications") {
            NotificationScreen(navController)
        }
        composable("Events") {
            EventsScreen(navController)
        }
        composable("my_events") {
            MyProjectsScreen(navController)
        }
        composable("hackathon_detail") {
            HackathonDetailScreen(
                onBackClick = { navController.popBackStack() }
            )
        }


    }
}