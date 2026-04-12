package com.example.srminsider

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController

//  DATA CLASS
data class Event(
    val image: Int,
    val tag: String,
    val title: String,
    val date: String,
    val location: String
)

@Composable
fun EventsScreen(navController: NavHostController) {

    val bg = Brush.verticalGradient(
        listOf(Color(0xFF0D0D0D), Color(0xFF121212))
    )

    var selectedFilter by remember { mutableStateOf("All") }

    // IMAGES
    val allEvents = listOf(
        Event(R.drawable.hackathon, "Tech", "Hackathon 2026", "Apr 15, 2026 • 9:00 AM", "Tech Park"),
        Event(R.drawable.design, "Design", "Design Workshop", "Apr 8, 2026 • 2:00 PM", "Design Lab"),
        Event(R.drawable.ai, "Tech", "Tech Talk: AI Future", "Apr 12, 2026 • 4:00 PM", "Main Auditorium"),
        Event(R.drawable.startup, "Workshop", "Startup Pitch Competition", "Apr 20, 2026 • 10:00 AM", "Business Center"),
        Event(R.drawable.computer, "Design", "UI/UX Masterclass", "Apr 18, 2026 • 3:00 PM", "Innovation Hub"),
        Event(R.drawable.blockchain, "Tech", "Blockchain Basics", "Apr 25, 2026 • 11:00 AM", "CS Department")
    )

    // HORIZONTAL FILTER
    val filteredEvents = when (selectedFilter) {
        "All" -> allEvents
        "Upcoming" -> allEvents
        else -> allEvents.filter { it.tag == selectedFilter }
    }

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(bg)
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {

            //  TITLE
            Text(
                text = "Events",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            //  FILTER CHIPS
            val filters = listOf("All", "Upcoming", "Tech", "Design", "Workshop")

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(filters) { filter ->
                    FilterChipUI(
                        text = filter,
                        selected = selectedFilter == filter,
                        onClick = { selectedFilter = filter }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            //  EVENTS LIST
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(filteredEvents) { event ->
                    EventCard(event)
                }
            }
        }
    }
}


//  FILTER CHUP
@Composable
fun FilterChipUI(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (selected) Color(0xFF4DA3FF)
                else Color(0xFF1A1A1A)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            color = if (selected) Color.White else Color.Gray,
            fontSize = 12.sp
        )
    }
}


//  EVENT
@Composable
fun EventCard(event: Event) {

    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)),
        modifier = Modifier.fillMaxWidth()
    ) {

        Column {

            Box {

                Image(
                    painter = painterResource(id = event.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )

                // Gradient overlay
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color.Transparent, Color.Black)
                            )
                        )
                )

                // Bookmark icon
                Icon(
                    Icons.Outlined.BookmarkBorder,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(10.dp)
                )

                // Tag
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(10.dp)
                        .background(
                            Color.Black.copy(alpha = 0.6f),
                            RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = event.tag,
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
            }

            Column(modifier = Modifier.padding(14.dp)) {

                Text(
                    text = event.title,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Outlined.CalendarToday,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(event.date, color = Color.Gray, fontSize = 12.sp)
                }

                Spacer(modifier = Modifier.height(6.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Outlined.LocationOn,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(event.location, color = Color.Gray, fontSize = 12.sp)
                }
            }
        }
    }
}