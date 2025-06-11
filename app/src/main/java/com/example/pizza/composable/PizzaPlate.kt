package com.example.pizza.composable

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizza.R
import com.example.pizza.Ingredient

@Composable
fun PizzaPlate() {
    var selectedSizeIndex by remember { mutableIntStateOf(0) }

    val pizzaSizes = listOf(110.dp, 90.dp, 70.dp)
    val prices = listOf(15, 17, 20)

    val animatedPizzaSize by animateDpAsState(
        targetValue = pizzaSizes[selectedSizeIndex],
        animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing),
        label = "pizza_size"
    )

    // Define available ingredients with their toppings
    val availableIngredients = remember {
        listOf(
            Ingredient(
                image = R.drawable.basil_3,
                ingredientsImage = listOf(
                    R.drawable.basil_1, R.drawable.basil_2, R.drawable.basil_3, R.drawable.basil_4,
                    R.drawable.basil_5, R.drawable.basil_6, R.drawable.basil_7, R.drawable.basil_8,
                    R.drawable.basil_9, R.drawable.basil_10,
                    R.drawable.basil_1, R.drawable.basil_2, R.drawable.basil_3, R.drawable.basil_4,
                    R.drawable.basil_5, R.drawable.basil_6, R.drawable.basil_7, R.drawable.basil_8,
                    R.drawable.basil_9, R.drawable.basil_10,
                ),
                isSelected = false,
                toppingsPositions = listOf(
                    Pair(0.4f, -0.15f), Pair(-0.3f, 0.2f), Pair(0.2f, -0.12f), Pair(-0.1f, -0.3f), Pair(-0.05f, 0.3f),
                    Pair(-0.4f,0.15f), Pair(0f, 0f), Pair(-0.2f, 0.12f), Pair(0.1f, 0.3f), Pair(-0.05f, 0.3f),
                    Pair(-0.4f, -0.15f), Pair(-0.3f, 0.2f), Pair(-0.2f, 0.12f), Pair(-0.1f, 0.3f), Pair(-0.05f, 0.3f),
                    Pair(0.4f,-0.15f), Pair(0.3f, -0.2f), Pair(-0.2f, 0.12f), Pair(0.1f, -0.3f), Pair(0.05f, -0.3f),

                )
            ),
            Ingredient(
                image = R.drawable.onion_3,
                ingredientsImage = listOf(
                    R.drawable.onion_1, R.drawable.onion_2, R.drawable.onion_3, R.drawable.onion_4,
                    R.drawable.onion_5, R.drawable.onion_6, R.drawable.onion_7, R.drawable.onion_8,
                    R.drawable.onion_9, R.drawable.onion_10,
                    R.drawable.onion_1, R.drawable.onion_2, R.drawable.onion_3, R.drawable.onion_4,
                    R.drawable.onion_5, R.drawable.onion_6, R.drawable.onion_7, R.drawable.onion_8,
                    R.drawable.onion_9, R.drawable.onion_10,
                ),
                isSelected = false,
                toppingsPositions = listOf(
                    Pair(0.4f, 0.15f), Pair(-0.3f, 0.2f), Pair(0.2f, 0.12f), Pair(-0.1f, -0.3f), Pair(0.05f, 0.3f),
                    Pair(-0.4f,0.15f), Pair(-0.3f, 0.2f), Pair(-0.2f, 0.12f), Pair(0.1f, 0.3f), Pair(0.05f, 0.3f),
                    Pair(-0.4f, -0.15f), Pair(0.3f, 0.2f), Pair(0.2f, 0.12f), Pair(-0.1f, 0.3f), Pair(-0.05f, 0.3f),
                    Pair(0.4f,-0.15f), Pair(0.3f, -0.2f), Pair(0f, 0f), Pair(0.1f, 0.3f), Pair(0.05f, -0.3f),)
            ),
            Ingredient(
                image = R.drawable.broccoli_3,
                ingredientsImage = listOf(
                    R.drawable.broccoli_1, R.drawable.broccoli_2, R.drawable.broccoli_3, R.drawable.broccoli_4,
                    R.drawable.broccoli_5, R.drawable.broccoli_6, R.drawable.broccoli_7, R.drawable.broccoli_8,
                    R.drawable.broccoli_9, R.drawable.broccoli_10,
                    R.drawable.broccoli_1, R.drawable.broccoli_2, R.drawable.broccoli_3, R.drawable.broccoli_4,
                    R.drawable.broccoli_5, R.drawable.broccoli_6, R.drawable.broccoli_7, R.drawable.broccoli_8,
                    R.drawable.broccoli_9, R.drawable.broccoli_10,
                ),
                isSelected = false,
                toppingsPositions = listOf(
                    Pair(0.4f, -0.15f), Pair(-0.3f, 0.2f), Pair(0.2f, -0.3f), Pair(-0.1f, -0.3f), Pair(0.05f, -0.3f),
                    Pair(-0.4f,0.15f), Pair(-0.3f, 0.2f), Pair(0.2f, -0.2f), Pair(0.1f, 0.3f), Pair(-0.05f, 0.3f),
                    Pair(0.2f, 0.2f), Pair(0.3f,-0.2f), Pair(0.2f, 0.12f), Pair(-0.1f, -0.3f), Pair(0.05f, -0.3f),
                    Pair(0.4f,-0.15f), Pair(0.3f, -0.2f), Pair(0f, 0f), Pair(0.1f, 0.3f), Pair(0.05f, 0.3f),)
            ),
            Ingredient(
                image = R.drawable.mushroom_3,
                ingredientsImage = listOf(
                    R.drawable.mushroom_1, R.drawable.mushroom_2, R.drawable.mushroom_3, R.drawable.mushroom_4,
                    R.drawable.mushroom_5, R.drawable.mushroom_6, R.drawable.mushroom_7, R.drawable.mushroom_8,
                    R.drawable.mushroom_9, R.drawable.mushroom_10,
                    R.drawable.mushroom_1, R.drawable.mushroom_2, R.drawable.mushroom_3, R.drawable.mushroom_4,
                    R.drawable.mushroom_5, R.drawable.mushroom_6, R.drawable.mushroom_7, R.drawable.mushroom_8,
                    R.drawable.mushroom_9, R.drawable.mushroom_10,
                ),
                isSelected = false,
                toppingsPositions = listOf(
                    Pair(0.1f, -0.4f), Pair(0.3f, 0.2f), Pair(0.2f, 0.1f), Pair(-0.1f, 0.2f), Pair(-0.05f, -0.3f),
                    Pair(-0.2f,0.4f), Pair(-0.3f, 0.2f), Pair(0.2f, -0.2f), Pair(0.1f, 0.1f), Pair(-0.05f, 0.3f),
                    Pair(0.3f, 0f), Pair(0.3f,-0.2f), Pair(-0.2f, 0.12f), Pair(0.1f, 0.1f), Pair(0.05f, -0.1f),
                    Pair(0.2f,-0.3f), Pair(-0.3f, -0.2f), Pair(0f, 0f), Pair(0.1f, 0.3f), Pair(-0.05f, 0.4f),)
            ),
            Ingredient(
                image = R.drawable.sausage_3,
                ingredientsImage = listOf(
                    R.drawable.sausage_1, R.drawable.sausage_2, R.drawable.sausage_3, R.drawable.sausage_4,
                    R.drawable.sausage_5, R.drawable.sausage_6, R.drawable.sausage_7, R.drawable.sausage_8,
                    R.drawable.sausage_9, R.drawable.sausage_10,
                    R.drawable.sausage_1, R.drawable.sausage_2, R.drawable.sausage_3, R.drawable.sausage_4,
                    R.drawable.sausage_5, R.drawable.sausage_6, R.drawable.sausage_7, R.drawable.sausage_8,
                    R.drawable.sausage_9, R.drawable.sausage_10,
                ),
                isSelected = false,
                toppingsPositions = listOf(
                    Pair(0.1f, -0.4f), Pair(-0.3f, 0.2f), Pair(0.2f, 0.1f), Pair(-0.1f, -0.2f), Pair(-0.05f, 0.3f),
                    Pair(-0.2f,-0.4f), Pair(-0.3f, -0.2f), Pair(-0.2f, -0.2f), Pair(0.1f, 0.1f), Pair(0.05f,- 0.3f),
                    Pair(-0.3f, 0f), Pair(0.3f,-0.2f), Pair(0.2f, -0.12f), Pair(0.1f, -0.1f), Pair(-0.05f, -0.1f),
                    Pair(0.2f,-0.3f), Pair(0.3f, -0.2f), Pair(0f, 0f), Pair(0.1f, -0.3f), Pair(-0.05f, 0.4f),)   )
            )
    }

    var ingredients by remember { mutableStateOf(availableIngredients) }

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.plate),
                contentDescription = "plate",
                modifier = Modifier
                    .padding(horizontal = 50.dp)
            )

            // Pizza base images
            val images = listOf(
                R.drawable.bread_1,
                R.drawable.bread_2,
                R.drawable.bread_3,
                R.drawable.bread_4,
                R.drawable.bread_5
            )
            ImageCarousel(images = images, carouselSize = animatedPizzaSize)

            // Pizza toppings overlay
            ingredients.forEach { ingredient ->
                PizzaToppings(
                    pizzaToppingsState = ingredient,
                    pizzaSize = when(selectedSizeIndex) {
                        0 -> 0.9f// Small
                        1 -> 1.2f // Medium
                        2 -> 1.5f  // Large
                        else -> 1.0f
                    },
                    modifier = Modifier
                )
            }
        }

        Text(
            text = "$${prices[selectedSizeIndex]}",
            fontSize = 40.sp,
            fontWeight = FontWeight.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        SizeSelector(
            selectedIndex = selectedSizeIndex,
            onSizeSelected = { index ->
                selectedSizeIndex = index
            }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "CUSTOMIZE YOUR PIZZA",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            itemsIndexed(ingredients) { index, ingredient ->
                IngredientTypeSelectable(
                    image = ingredient.image,
                    isSelected = ingredient.isSelected,
                    onSelectionChanged = { selected ->
                        ingredients = ingredients.toMutableList().apply {
                            this[index] = this[index].copy(isSelected = selected)
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PizzaPlatePreview() {
    PizzaPlate()
}