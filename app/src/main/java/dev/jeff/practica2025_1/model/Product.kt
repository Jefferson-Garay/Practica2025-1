package dev.jeff.practica2025_1.model

data class Product(
    val name: String,
    val category: String,  // Laptop, Smartphone, Accesorio...
    val price: Double,
    val imageUrl: String
)
