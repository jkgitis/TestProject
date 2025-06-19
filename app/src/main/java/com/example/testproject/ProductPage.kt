package com.example.testproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.testproject.R

@Composable
fun ProductPage() {
    val screenWidth = 390.dp
    val screenHeight = 1419.dp

    val imageList = listOf(R.drawable.green_jacket1, R.drawable.green_jacket2)
    val sizeOptions = listOf("S", "M", "L", "XL", "2XL")
    val colorOptions = listOf(Color(0xFFFF9800), Color.Black, Color.Red, Color.Yellow, Color.Blue)

    var selectedSize by remember { mutableStateOf("S") }
    var selectedColor by remember { mutableStateOf(Color(0xFFFF9800)) }
    var quantity by remember { mutableStateOf(1) }

    Box(
        modifier = Modifier
            .width(screenWidth)
            .height(screenHeight)
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(imageList) { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(width = 180.dp, height = 220.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                }
            }

            Text("Men's Harrington Jacket", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text("$148", fontSize = 18.sp, fontWeight = FontWeight.Medium, color = Color(0xFF936EF6))

            DropdownField(
                label = "Size",
                selectedOption = selectedSize,
                options = sizeOptions,
                onOptionSelected = { selectedSize = it }
            )

            DropdownColorField(
                label = "Color",
                selectedColor = selectedColor,
                options = colorOptions,
                onColorSelected = { selectedColor = it }
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Quantity", fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.width(16.dp))
                QuantitySelector(quantity, onIncrease = { quantity++ }, onDecrease = { if (quantity > 1) quantity-- })
            }

            Text(
                "Built to be fine and made to last, this full-zip corduroy jacket is part of our Nike Life collection...",
                fontSize = 14.sp
            )
            Text("Shipping & Returns", fontWeight = FontWeight.Bold)
            Text("Free standard shipping and free 60-day returns", fontSize = 14.sp)

            Text("Reviews", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text("4.5 Ratings", fontWeight = FontWeight.Bold)
            Text("295 Reviews")

            ReviewItem("Alex Morgan", "2 days ago")
            ReviewItem("Alex Morgan", "6 days ago")

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5F5F5))
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("$148", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Button(
                    onClick = { /* Add to cart */ },
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF936EF6))
                ) {
                    Text("Add to Bag", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun QuantitySelector(quantity: Int, onIncrease: () -> Unit, onDecrease: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Button(
            onClick = onDecrease,
            modifier = Modifier.size(32.dp),
            contentPadding = PaddingValues(0.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF936EF6))
        ) {
            Text("-", color = Color.White, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(quantity.toString(), fontSize = 16.sp)
        Spacer(modifier = Modifier.width(12.dp))
        Button(
            onClick = onIncrease,
            modifier = Modifier.size(32.dp),
            contentPadding = PaddingValues(0.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF936EF6))
        ) {
            Text("+", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DropdownField(
    label: String,
    selectedOption: String,
    options: List<String>,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFF2F2F2))
                .clickable { expanded = true }
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = selectedOption, fontSize = 14.sp, color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(text = { Text(option) }, onClick = {
                    onOptionSelected(option)
                    expanded = false
                })
            }
        }
    }
}

@Composable
fun DropdownColorField(
    label: String,
    selectedColor: Color,
    options: List<Color>,
    onColorSelected: (Color) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFF2F2F2))
                .clickable { expanded = true }
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text(label, fontSize = 14.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(selectedColor)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { color ->
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(12.dp)
                                    .clip(CircleShape)
                                    .background(color)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    },
                    onClick = {
                        onColorSelected(color)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun ReviewItem(name: String, time: String) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(name, fontWeight = FontWeight.Bold)
            Text("Great selection! Very impressed...", fontSize = 13.sp)
            Text(time, fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProductPagePreview() {
    ProductPage()
}
