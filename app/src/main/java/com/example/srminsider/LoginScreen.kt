package com.example.srminsider



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource

@Composable
fun LoginScreen(navController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(60.dp))

        // LOGO
        Image(
            painter = painterResource(id = R.drawable.logo), // 🔥 your logo name
            contentDescription = "App Logo",
            modifier = Modifier
                .height(60.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // TAGLINE
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFF0D2A4D))
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "• WHERE SRMITES UNITE",
                color = Color(0xFF6EA8FE),
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Welcome Back",
            color = Color.White,
            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Sign in to continue your journey",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // email
        CustomTextField(
            value = email,
            placeholder = "your.email@srmist.edu.in"
        ) { email = it }

        Spacer(modifier = Modifier.height(12.dp))

        // password
        CustomTextField(
            value = password,
            placeholder = "Enter your password"
        ) { password = it }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it }
            )

            Text("Remember me", color = Color.Gray)

            Spacer(modifier = Modifier.weight(1f))

            Text("Forgot?", color = Color(0xFF6EA8FE))
        }

        Spacer(modifier = Modifier.height(20.dp))

        // sign in to continue
        Button(
            onClick = {
                navController.navigate("home")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color(0xFF5AA9FF),
                                Color(0xFF9B5CFF)
                            )
                        ),
                        shape = RoundedCornerShape(30.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("Sign In to Continue", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // FOOTER
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(color = Color.Gray, modifier = Modifier.weight(1f))
            Text(
                " 10K+ Active Members ",
                color = Color.Gray,
                fontSize = 12.sp
            )
            Divider(color = Color.Gray, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun CustomTextField(
    value: String,
    placeholder: String,
    onChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF1C1C1E))
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        if (value.isEmpty()) {
            Text(placeholder, color = Color.Gray)
        }

        BasicTextField(
            value = value,
            onValueChange = onChange,
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
            modifier = Modifier.fillMaxWidth()
        )
    }
}