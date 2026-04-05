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

@Composable
fun BottomBar(navController: NavController) {

    var selectedItem by remember { mutableStateOf("home") }

    Box {

        NavigationBar(
            containerColor = Color.Black,
            tonalElevation = 8.dp
        ) {

            // ✅ HOME
            NavigationBarItem(
                selected = selectedItem == "home",
                onClick = {
                    selectedItem = "home"
                    navController.navigate("home") {
                        popUpTo("home")
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Home",
                        tint = if (selectedItem == "home") Color(0xFF4DA3FF) else Color.Gray
                    )
                },
                label = {
                    Text(
                        "Home",
                        color = if (selectedItem == "home") Color(0xFF4DA3FF) else Color.Gray
                    )
                }
            )

            // ✅ EVENTS
            NavigationBarItem(
                selected = selectedItem == "events",
                onClick = {
                    selectedItem = "events"
                    navController.navigate("events") {
                        popUpTo("home")
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        Icons.Default.DateRange,
                        contentDescription = "Events",
                        tint = if (selectedItem == "events") Color(0xFF4DA3FF) else Color.Gray
                    )
                },
                label = {
                    Text(
                        "Events",
                        color = if (selectedItem == "events") Color(0xFF4DA3FF) else Color.Gray
                    )
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            // ✅ NOTIFICATIONS
            NavigationBarItem(
                selected = selectedItem == "notifications",
                onClick = {
                    selectedItem = "notifications"
                    navController.navigate("notifications") {
                        popUpTo("home")
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = if (selectedItem == "notifications") Color(0xFF4DA3FF) else Color.Gray
                    )
                },
                label = {
                    Text(
                        "Notifications",
                        color = if (selectedItem == "notifications") Color(0xFF4DA3FF) else Color.Gray
                    )
                }
            )

            // ✅ PROFILE
            NavigationBarItem(
                selected = selectedItem == "profile",
                onClick = {
                    selectedItem = "profile"
                    navController.navigate("profile") {
                        popUpTo("home")
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = if (selectedItem == "profile") Color(0xFF4DA3FF) else Color.Gray
                    )
                },
                label = {
                    Text(
                        "Profile",
                        color = if (selectedItem == "profile") Color(0xFF4DA3FF) else Color.Gray
                    )
                }
            )
        }

        // 🔥 CENTER BUTTON → MY EVENTS (UPDATED)
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
                        selectedItem = "my_events"
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