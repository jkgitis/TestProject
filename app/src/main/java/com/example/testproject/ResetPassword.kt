package com.example.testproject


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ResetPasswordScreen() {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back Button
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF2F2F2))
                    .clickable { /* Handle back */ },
                contentAlignment = Alignment.Center
            ) {
                Text("←", fontSize = 18.sp)
            }
        }


        Spacer(modifier = Modifier.height(24.dp))

        // Title
        Text(
            text = "Forgot Password",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Enter Email address") },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedContainerColor = Color(0xFFF2F2F2),
                unfocusedContainerColor = Color(0xFFF2F2F2)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Continue Button
        Button(
            onClick = { /* Handle continue */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF936EF6))
        ) {
            Text("Continue", color = Color.White)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ResetPasswordScreenPreview() {
    ResetPasswordScreen()
}
