package com.example.testproject

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CreateAccount() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back button
        IconButton(
            onClick = { /* handle back */ },
            modifier = Modifier
                .align(Alignment.Start)
                .size(36.dp)
                .background(Color(0xFFF2F2F2), shape = CircleShape)
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Title
        Text(
            text = "Create Account",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(24.dp))

        val fieldModifier = Modifier
            .fillMaxWidth()
            .height(56.dp)

        val fieldColors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = Color(0xFFF2F2F2),
            unfocusedContainerColor = Color(0xFFF2F2F2)
        )

        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            placeholder = { Text("Firstname") },
            modifier = fieldModifier,
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = fieldColors
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            placeholder = { Text("Lastname") },
            modifier = fieldModifier,
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = fieldColors
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Email Address") },
            modifier = fieldModifier,
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = fieldColors
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
            modifier = fieldModifier,
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = fieldColors
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { /* Handle create account */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF936EF6))
        ) {
            Text("Continue", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Forgot Password ? ",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Text(
                text = "Reset",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.clickable { /* navigate to reset */ }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CreateAccountPreview() {
    CreateAccount()
}


