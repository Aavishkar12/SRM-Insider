package com.example.srminsider

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

// ---------------- DATA ----------------
data class DiscussionItem(
    val name: String,
    val role: String,
    val message: String,
    val time: String,
    val replies: Int
)

data class Participant(
    val name: String,
    val role: String,
    val isOnline: Boolean
)

// ---------------- SCREEN ----------------
@Composable
fun HackathonDetailScreen(onBackClick: () -> Unit) {

    var selectedTab by remember { mutableStateOf("discussion") }

    val discussions = listOf(
        DiscussionItem("Sarah Chen", "Team Lead", "Looking for frontend dev...", "10:45 AM", 3),
        DiscussionItem("Michael Torres", "Backend Dev", "API docs available?", "11:20 AM", 5),
        DiscussionItem("Priya Sharma", "UI/UX Designer", "Wireframes done!", "12:15 PM", 2),
        DiscussionItem("Alex Kim", "Data Scientist", "ML project idea!", "1:30 PM", 7)
    )

    val participants = listOf(
        Participant("Sarah Chen", "Team Lead", true),
        Participant("Michael Torres", "Backend Dev", true),
        Participant("Priya Sharma", "UI/UX Designer", false),
        Participant("Alex Kim", "Data Scientist", true),
        Participant("Emma Wilson", "Product Manager", true),
        Participant("David Park", "Full Stack Dev", false)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0D0D))
    ) {

        Spacer(modifier = Modifier.height(28.dp))

        // -------- TOP BAR --------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.clickable { onBackClick() }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text("Hackathon 2026", color = Color.White)
                Text("142 participants", color = Color.Gray)
            }

            Icon(Icons.Outlined.Search, contentDescription = null, tint = Color.White)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // -------- TABS --------
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {

            Text(
                "Discussion",
                color = if (selectedTab == "discussion") Color.White else Color.Gray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable { selectedTab = "discussion" }
                    .padding(end = 20.dp)
            )

            Text(
                "Participants",
                color = if (selectedTab == "participants") Color.White else Color.Gray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { selectedTab = "participants" }
            )
        }

        Spacer(modifier = Modifier.height(6.dp))
        Divider(color = Color.DarkGray)

        // -------- CONTENT SWITCH --------
        if (selectedTab == "discussion") {

            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(discussions) {
                    DiscussionCard(it)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            // INPUT BAR
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .background(Color(0xFF1A1A1A), RoundedCornerShape(24.dp))
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Ask a question or start a discussion...",
                    color = Color.Gray,
                    modifier = Modifier.weight(1f)
                )
                Icon(Icons.Outlined.Send, contentDescription = null, tint = Color(0xFF4A90E2))
            }

        } else {

            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(participants) {
                    ParticipantItem(it)
                    Spacer(modifier = Modifier.height(14.dp))
                }
            }
        }
    }
}

// ---------------- DISCUSSION CARD ----------------
@Composable
fun DiscussionCard(item: DiscussionItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1A1A1A), RoundedCornerShape(14.dp))
            .padding(14.dp)
    ) {

        Text(item.name, color = Color.White, fontWeight = FontWeight.Bold)
        Text(item.role, color = Color.Gray)

        Spacer(modifier = Modifier.height(5.dp))
        Text(item.message, color = Color.LightGray)

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(item.time, color = Color.Gray)
            Text("${item.replies} replies", color = Color(0xFF4A90E2))
        }
    }
}

// ---------------- PARTICIPANT ITEM ----------------
@Composable
fun ParticipantItem(user: Participant) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Avatar + status dot
        Box {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.DarkGray, CircleShape)
            )

            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(
                        if (user.isOnline) Color.Green else Color.Gray,
                        CircleShape
                    )
                    .align(Alignment.BottomEnd)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(user.name, color = Color.White, fontWeight = FontWeight.Bold)
            Text(user.role, color = Color.Gray)
        }

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A90E2)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Chat", color = Color.White)
        }
    }
}