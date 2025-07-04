package com.example.testproject.screens

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.testproject.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SignInScreen(navController: NavController) {
    val context = LocalContext.current
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Sign in",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                errorMessage = ""
            },
            placeholder = { Text("Email Address") },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.Start).padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onClick@{
                if (!Patterns.EMAIL_ADDRESS.matcher(email.text).matches()) {
                    errorMessage = "Invalid email format"
                    return@onClick
                }

                // Proceed to next screen and pass email
                navController.currentBackStackEntry?.savedStateHandle?.set("email", email.text)
                navController.navigate("loginPassword")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF936EF6))
        ) {
            Text("Continue", color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Don't have an Account?",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Text(
            text = "Create One",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.clickable {
                navController.navigate("createAccount")
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        SocialButton(icon = R.drawable.apple_logo, text = "Continue With Apple")
        Spacer(modifier = Modifier.height(12.dp))
        SocialButton(icon = R.drawable.google_logo, text = "Continue With Google")
        Spacer(modifier = Modifier.height(12.dp))
        SocialButton(icon = R.drawable.facebook_logo, text = "Continue With Facebook")
    }
}

@Composable
fun SocialButton(icon: Int, text: String) {
    OutlinedButton(
        onClick = { /* Future: Add Google/Apple/Facebook auth */ },
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0xFFF2F2F2))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text, color = Color.Black)
        }
    }
}
