package com.example.pizza.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizza.R

@Composable
fun AddToCart(){
    Spacer(modifier = Modifier.height(40.dp))
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.offset(120.dp)
        ) {
        Button(
            onClick = {},
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(Color(0xff2c2221)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cart),
                contentDescription = "cart",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Add to cart",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }
    }
}