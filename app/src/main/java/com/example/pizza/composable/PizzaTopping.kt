package com.example.pizza.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizza.Ingredient


@Composable
@OptIn(ExperimentalAnimationApi::class)
fun PizzaToppings(
    pizzaToppingsState: Ingredient,
    pizzaSize: Float,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.scale(pizzaSize)) {
        AnimatedVisibility(
            visible = pizzaToppingsState.isSelected,
            enter = scaleIn(
                initialScale = 2f,
                transformOrigin = TransformOrigin(5f, 5f),
            ),
            exit = scaleOut(),
        ) {

            pizzaToppingsState.ingredientsImage.forEachIndexed { index, toppingImage ->
                Image(
                    painter = painterResource(id = toppingImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .offset(
                            (210 * pizzaToppingsState.toppingsPositions[index].first).dp,
                            (230 * pizzaToppingsState.toppingsPositions[index].second).dp
                        )
                )
            }
        }
    }
}