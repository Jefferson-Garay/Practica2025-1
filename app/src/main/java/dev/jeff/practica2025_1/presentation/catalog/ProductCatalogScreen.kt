package dev.jeff.practica2025_1.presentation.catalog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.jeff.practica2025_1.model.Product
import java.text.DecimalFormat

@Composable
fun ProductCatalogScreen(onBackToMenu: () -> Unit) {
    val df = remember { DecimalFormat("#,##0.00") }

    // Lista “hardcoded” para la práctica
    val products = remember {
        listOf(
            Product(
                name = "Laptop Pro 14”",
                category = "Laptop",
                price = 4599.0,
                imageUrl = "https://picsum.photos/seed/laptop/400"
            ),
            Product(
                name = "Smartphone X",
                category = "Smartphone",
                price = 2999.0,
                imageUrl = "https://picsum.photos/seed/phone/400"
            ),
            Product(
                name = "Auriculares BT",
                category = "Accesorio",
                price = 199.9,
                imageUrl = "https://picsum.photos/seed/headphones/400"
            ),
            Product(
                name = "Tablet 11”",
                category = "Tablet",
                price = 1899.0,
                imageUrl = "https://picsum.photos/seed/tablet/400"
            )
        )
    }

    val total = products.sumOf { it.price }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("💻 Catálogo de Productos", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(products) { p ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        AsyncImage(
                            model = p.imageUrl,
                            contentDescription = p.name,
                            modifier = Modifier
                                .size(84.dp)
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            Text(p.name, style = MaterialTheme.typography.titleMedium)
                            Text("Categoría: ${p.category}")
                            Text("Precio: S/. ${df.format(p.price)}")
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(8.dp))
        Divider()
        Spacer(Modifier.height(8.dp))

        Text(
            text = "Total: S/. ${df.format(total)}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(16.dp))

        OutlinedButton(
            onClick = onBackToMenu,
            modifier = Modifier.fillMaxWidth()
        ) { Text("⬅️ Volver al Menú") }
    }
}
