package com.example.pizza.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizza.R

@Composable
fun IngredientTypeSelectable(
    @DrawableRes image: Int,
    isSelected: Boolean,
    onSelectionChanged: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .clickable {
                onSelectionChanged(!isSelected)
            }
            .padding(5.dp)
            .size(80.dp)
            .background(
                color = if (isSelected) Color.Green.copy(alpha = 0.1f)
                else Color.White,
                shape = RoundedCornerShape(100.dp)
            )
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "food",
            modifier = Modifier
                .size(80.dp)
                .padding(20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IngredientTypeSelectablePreview() {
    IngredientTypeSelectable(
        image = R.drawable.basil_3,
        isSelected = true,
        onSelectionChanged = {}
    )
}