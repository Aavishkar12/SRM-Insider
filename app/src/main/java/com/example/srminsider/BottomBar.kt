package com.example.srminsider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Box {

        NavigationBar(
            containerColor = Color.Black,
            tonalElevation = 8.dp
        ) {

            //  HOME
            NavigationBarItem(
                selected = currentRoute == "home",
                onClick = {
                    navController.navigate("home") {
                        popUpTo("home")
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Home",
                        tint = if (currentRoute == "home") Color(0xFF4DA3FF) else Color.Gray
                    )
                },
                label = {
                    Text(
                        "Home",
                        color = if (currentRoute == "home") Color(0xFF4DA3FF) else Color.Gray
                    )
                }
            )

            // EVENTS
            NavigationBarItem(
                selected = currentRoute == "events",
                onClick = {
                    navController.navigate("events") {
                        popUpTo("home")
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        Icons.Default.DateRange,
                        contentDescription = "Events",
                        tint = if (currentRoute == "events") Color(0xFF4DA3FF) else Color.Gray
                    )
                },
                label = {
                    Text(
                        "Events",
                        color = if (currentRoute == "events") Color(0xFF4DA3FF) else Color.Gray
                    )
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            //  NOTIFICATIONS
            NavigationBarItem(
                selected = currentRoute == "notifications",
                onClick = {
                    navController.navigate("notifications") {
                        popUpTo("home")
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = if (currentRoute == "notifications") Color(0xFF4DA3FF) else Color.Gray
                    )
                },
                label = {
                    Text(
                        "Notifications",
                        color = if (currentRoute == "notifications") Color(0xFF4DA3FF) else Color.Gray
                    )
                }
            )

            //  PROFILE
            NavigationBarItem(
                selected = currentRoute == "profile",
                onClick = {
                    navController.navigate("profile") {
                        popUpTo("home")
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = if (currentRoute == "profile") Color(0xFF4DA3FF) else Color.Gray
                    )
                },
                label = {
                    Text(
                        "Profile",
                        color = if (currentRoute == "profile") Color(0xFF4DA3FF) else Color.Gray
                    )
                }
            )
        }

        //  CENTER BUTTON → MY EVENTS
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-30).dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .shadow(12.dp, CircleShape)
                    .background(
                        brush = Brush.radialGradient(
                            listOf(
                                Color(0xFF4DA3FF),
                                Color(0xFF9B5CFF)
                            )
                        ),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {
                        navController.navigate("my_events") {
                            popUpTo("home")
                            launchSingleTop = true
                        }
                    }
                ) {
                    Icon(
                        Icons.Default.Event,
                        contentDescription = "My Events",
                        tint = Color.White
                    )
                }
            }
        }
    }
}