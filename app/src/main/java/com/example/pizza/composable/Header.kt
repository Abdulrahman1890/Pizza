package com.example.pizza.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizza.R

@Composable
fun Header(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().padding(16.dp)

    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
            contentDescription = "back",
            Modifier.size(32.dp)
            )
        Text(
            text = "Pizza",
            fontSize = 28.sp,
            fontWeight = FontWeight.Black
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_favorite_24),
            contentDescription = "favorate",
            Modifier.size(32.dp)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    Header()
}