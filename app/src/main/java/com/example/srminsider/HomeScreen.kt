package com.example.srminsider

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController)

 {


    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0D0D0D))
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            item {

                //  WELCOME BACK
                Text(
                    text = "Welcome back, Aavishkar",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                // ANNOUNCEMENT
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF2C2C54))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "📣 New Event Registration Open",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Register now for Hackathon 2026.\nLimited spots available!",
                            color = Color.LightGray,
                            fontSize = 12.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text("Domains", color = Color.White, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                ) {
                    DomainCard("App Dev", "💻")
                    DomainCard("Design", "🎨")
                    DomainCard("AI/ML", "🤖")
                    DomainCard("CyberSec", "🔐")
                    DomainCard("Data Sci", "📊")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text("Recommended Events", color = Color.White, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(12.dp))

                EventCard("Hackathon 2026", "Apr 15, 2026", R.drawable.hackathon)
                EventCard("Design Workshop", "Apr 8, 2026", R.drawable.design)
                EventCard("Tech Talk: AI Future", "Apr 12, 2026", R.drawable.ai)

                Spacer(modifier = Modifier.height(20.dp))

                Text("Saved Events", color = Color.White, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(12.dp))

                EventCard("Design Workshop", "Apr 8, 2026", R.drawable.design)
            }
        }
    }
}

@Composable
fun DomainCard(title: String, icon: String) {
    Box(
        modifier = Modifier
            .padding(end = 12.dp)
            .size(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF1C1C1E)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(icon, fontSize = 28.sp)
            Text(title, color = Color.White, fontSize = 12.sp)
        }
    }
}

@Composable
fun EventCard(title: String, date: String, image: Int) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1C1C1E)
        )
    ) {

        Column {

            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(14.dp)) {

                Text(
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = date,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}