package com.example.pizza


data class Pizza(
    val image: Int,
    val size: PizzaSize,
    val ingredients: List<Dropping>,
    val price: Int
)

data class Dropping(
    val image: Int,
    val price: Int,
    val ingredients: List<Int>,
    val isSelected: Boolean = false
)

data class Ingredient(
    val image: Int,
    val ingredientsImage: List<Int>,
    val isSelected: Boolean,
    val toppingsPositions: List<Pair<Float, Float>>
)

enum class PizzaSize(val price: Int) {
    SMALL(5),
    MEDIUM(10),
    LARGE(15)
}