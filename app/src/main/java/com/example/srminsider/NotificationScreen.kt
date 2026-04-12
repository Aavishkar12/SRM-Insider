package com.example.srminsider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// notification screen

@Composable
fun NotificationScreen(navController: NavHostController) {

    val bgGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF0D0D0D), Color(0xFF121212))
    )

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(bgGradient)
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {

            Text(
                text = "Notifications",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                item {
                    NotificationCard(
                        title = "Event Reminder",
                        desc = "Design Workshop starts in 2 hours",
                        time = "1h ago",
                        iconColor = Color(0xFF3B82F6),
                        icon = Icons.Outlined.CalendarToday
                    )
                }

                item {
                    NotificationCard(
                        title = "New Announcement",
                        desc = "Hackathon registration deadline extended to April 10",
                        time = "3h ago",
                        iconColor = Color(0xFF8B5CF6),
                        icon = Icons.Outlined.Notifications
                    )
                }

                item {
                    NotificationCard(
                        title = "New Member",
                        desc = "John Doe joined the App Dev domain",
                        time = "5h ago",
                        iconColor = Color(0xFF10B981),
                        icon = Icons.Outlined.Person
                    )
                }

                item {
                    NotificationCard(
                        title = "Feature Update",
                        desc = "Check out the new idea submission feature!",
                        time = "1d ago",
                        iconColor = Color(0xFFF59E0B),
                        icon = Icons.Outlined.Star
                    )
                }

                item {
                    NotificationCard(
                        title = "Event Update",
                        desc = "Tech Talk venue changed to Main Auditorium",
                        time = "1d ago",
                        iconColor = Color(0xFF3B82F6),
                        icon = Icons.Outlined.CalendarToday
                    )
                }

                item {
                    NotificationCard(
                        title = "System Update",
                        desc = "App will be under maintenance",
                        time = "2d ago",
                        iconColor = Color.Gray,
                        icon = Icons.Outlined.Info
                    )
                }
            }
        }
    }
}

@Composable
fun NotificationCard(
    title: String,
    desc: String,
    time: String,
    iconColor: Color,
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1A1A1A)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(iconColor.copy(alpha = 0.2f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = null, tint = iconColor)
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = desc,
                    color = Color.Gray,
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = time,
                    color = Color.Gray,
                    fontSize = 11.sp
                )
            }

            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(Color(0xFF3B82F6), CircleShape)
            )
        }
    }
}