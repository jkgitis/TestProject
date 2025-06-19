package com.example.testproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun OrderSuccess() {
    Column(
        modifier = Modifier
            .width(390.dp)
            .height(844.dp)
            .background(Color(0xFF936EF6)) // purple background
    ) {
        // Image Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.order_success), // Replace with your asset
                contentDescription = "Success Illustration",
                modifier = Modifier
                    .width(250.dp)
                    .height(250.dp)
            )
        }

        // Bottom White Rounded Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
                .padding(horizontal = 24.dp, vertical = 32.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Order Placed\nSuccessfully",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "You will receive an email confirmation",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = { /* Navigate to order details */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF936EF6)),
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "See Order details", color = Color.White)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun OrderSuccessPreview() {
    OrderSuccess()
}
