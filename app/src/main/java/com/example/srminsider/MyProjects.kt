package com.example.srminsider

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MyProjectsScreen(navController: NavController) {

    val projects = listOf(
        Project("Hackathon 2026", "Apr 5-6, 2026", "Tech Hub", "142 participants", R.drawable.hackathon),
        Project("Technathon 2026", "Apr 12-13, 2026", "Innovation Center", "98 participants", R.drawable.ai),
        Project("Ideathon Sprint", "Apr 20-21, 2026", "Creative Lab", "76 participants", R.drawable.design)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "My Projects",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(projects) { project ->
                ProjectCard(project, navController) // 🔥 PASS NAVCONTROLLER
            }
        }
    }
}

// 📦 DATA CLASS
data class Project(
    val title: String,
    val date: String,
    val location: String,
    val participants: String,
    val image: Int
)

// 🎴 CARD (CLICK ADDED HERE)
@Composable
fun ProjectCard(project: Project, navController: NavController) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // 🔥 ONLY NAVIGATE WHEN HACKATHON IS CLICKED
                if (project.title == "Hackathon 2026") {
                    navController.navigate("hackathon_detail")
                }
            },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))
    ) {
        Column {

            Image(
                painter = painterResource(id = project.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(135.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(10.dp)) {

                Text(project.title, color = Color.White, fontSize = 15.sp)

                Spacer(modifier = Modifier.height(4.dp))
                Text(project.date, color = Color.Gray, fontSize = 11.sp)

                Spacer(modifier = Modifier.height(3.dp))
                Text(project.location, color = Color.Gray, fontSize = 11.sp)

                Spacer(modifier = Modifier.height(3.dp))
                Text(project.participants, color = Color.Gray, fontSize = 11.sp)
            }
        }
    }
}