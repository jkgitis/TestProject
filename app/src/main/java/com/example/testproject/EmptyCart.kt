package com.example.testproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EmptyCart() {
    Box(
        modifier = Modifier
            .width(390.dp)
            .height(844.dp)
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        // Top-left back arrow
        IconButton(
            onClick = { /* Handle back */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 24.dp)
                .size(36.dp)
                .clip(CircleShape)
                .background(Color(0xFFF2F2F2))
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        // Centered content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_empty_cart), // replace with your drawable
                contentDescription = "Empty Cart",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Your Cart is Empty",
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { /* Navigate to categories */ },
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF936EF6)),
                modifier = Modifier
                    .height(44.dp)
                    .width(180.dp)
            ) {
                Text("Explore Categories", color = Color.White, fontSize = 14.sp)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun EmptyCartPreview() {
    EmptyCart()
}
