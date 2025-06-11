package com.example.pizza.composable

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SizeSelector(
    selectedIndex: Int,
    onSizeSelected: (Int) -> Unit
) {
    val sizes = listOf("S", "M", "L")

    val animatedOffset by animateDpAsState(
        targetValue = (selectedIndex * 79).dp,
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
        label = "selector_offset"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 109.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .offset(x = animatedOffset)
                .size(70.dp)
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(50.dp))
                .background(Color.White, shape = RoundedCornerShape(50.dp))
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            sizes.forEachIndexed { index, label ->
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .clickable {
                            onSizeSelected(index)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = label,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                }
            }
        }
    }
}
