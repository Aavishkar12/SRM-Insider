package com.example.srminsider

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController


@Composable
fun ProfileScreen(navController: NavController) {

    val bgGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0D0F1A),
            Color(0xFF05060A)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgGradient)
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp),
            contentPadding = PaddingValues(bottom = 120.dp)
        ) {

            item { Spacer(modifier = Modifier.height(20.dp)) }

            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Box(
                        modifier = Modifier
                            .size(110.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(
                                Brush.linearGradient(
                                    listOf(
                                        Color(0xFF5F6AFF),
                                        Color(0xFFB44CFF)
                                    )
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "A",
                            color = Color.White,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(Color(0xFF2A2F45))
                            .padding(horizontal = 14.dp, vertical = 5.dp)
                    ) {
                        Text("Verified", color = Color.White, fontSize = 12.sp)
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        "Aavishkar",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(
                                Brush.horizontalGradient(
                                    listOf(
                                        Color(0xFF3B82F6),
                                        Color(0xFF8B5CF6)
                                    )
                                )
                            )
                            .padding(horizontal = 16.dp, vertical = 6.dp)
                    ) {
                        Text(
                            "APP DEVELOPMENT",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        "Building innovative solutions for tomorrow's challenges",
                        color = Color.Gray,
                        fontSize = 13.sp,
                        lineHeight = 18.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        IconCircle(Icons.Default.AutoAwesome)
                        IconCircle(Icons.Default.Group)
                        IconCircle(Icons.Default.Favorite)
                    }
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    StatBox("12", "Events", Icons.Default.DateRange)
                    StatBox("8", "Saved", Icons.Default.Bookmark)
                    StatBox("5d", "Streak", Icons.Default.Bolt)
                }
            }

            item { ProfileItem("Edit Profile", "Update your information", Icons.Default.Person) }
            item { ProfileItem("Notifications", "Manage alerts", Icons.Default.Notifications) }
            item { ProfileItem("My Activity", "View your history", Icons.Default.List) }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    ProfileItem("Settings", "App preferences", Icons.Default.Settings)
                }
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp))
                        .background(Color(0xFF2A0E12))
                        .padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.ExitToApp, contentDescription = null, tint = Color.Red)
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text("Sign Out", color = Color.Red, fontWeight = FontWeight.Bold)
                            Text("See you later!", color = Color.Gray, fontSize = 12.sp)
                        }
                    }
                }
            }

            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("• Trusted by 10K+ students •", color = Color.Gray, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("SRM Insider v1.0.0", color = Color.DarkGray, fontSize = 11.sp)
                }
            }

            item { Spacer(modifier = Modifier.height(20.dp)) }
        }
    }
}

@Composable
fun StatBox(value: String, label: String, icon: ImageVector) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(90.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF11131F)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Icon(icon, contentDescription = null, tint = Color(0xFF7AA2FF))

            Spacer(modifier = Modifier.height(6.dp))

            Text(value, color = Color.White, fontWeight = FontWeight.Bold)

            Text(label, color = Color.Gray, fontSize = 12.sp)
        }
    }
}

@Composable
fun IconCircle(icon: ImageVector) {
    Box(
        modifier = Modifier
            .size(45.dp)
            .clip(CircleShape)
            .background(Color(0xFF11131F)),
        contentAlignment = Alignment.Center
    ) {
        Icon(icon, contentDescription = null, tint = Color(0xFF7AA2FF))
    }
}

@Composable
fun ProfileItem(title: String, subtitle: String, icon: ImageVector) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(Color(0xFF11131F))
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(icon, contentDescription = null, tint = Color(0xFF7AA2FF))

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = Color.White, fontWeight = FontWeight.Medium)
                Text(subtitle, color = Color.Gray, fontSize = 12.sp)
            }

            Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.Gray)
        }
    }
}

@Composable
fun ProfileScreenWrapper(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding))
        ProfileScreen(navController)
    }
}