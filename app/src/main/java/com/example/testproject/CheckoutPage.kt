package com.example.testproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CheckoutPage() {
    Column(
        modifier = Modifier
            .width(390.dp)
            .height(844.dp)
            .background(Color.White)
            .padding(horizontal = 24.dp, vertical = 24.dp)
    ) {
        // Top App Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Checkout",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Shipping Address
        AddressOrPaymentSection(
            label = "Shipping Address",
            value = "Add Shipping Address" // replace with actual address
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Payment Method
        AddressOrPaymentSection(
            label = "Payment Method",
            value = "Add Payment Method" // replace with **** 4187 🟠 for filled view
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Cost Summary
        Column(modifier = Modifier.fillMaxWidth()) {
            SummaryRow("Subtotal", "$200")
            SummaryRow("Shipping Cost", "$8.00")
            SummaryRow("Tax", "$0.00")
            SummaryRow("Total", "$208", bold = true)
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Bar with Place Order
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$208",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Button(
                onClick = { /* Place order */ },
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF936EF6))
            ) {
                Text("Place Order", color = Color.White)
            }
        }
    }
}

@Composable
fun AddressOrPaymentSection(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF2F2F2))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(text = label, fontSize = 12.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = value, fontSize = 14.sp, fontWeight = FontWeight.Medium)
            Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.Gray)
        }
    }
}

@Composable
fun SummaryRow(label: String, value: String, bold: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
        )
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun CheckoutPagePreview() {
    CheckoutPage()
}
