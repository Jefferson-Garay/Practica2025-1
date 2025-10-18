package dev.jeff.practica2025_1.presentation.catalog

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductCatalogScreen(onBackToMenu: () -> Unit) {
    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Text("💻 Catálogo de Productos", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(24.dp))
        Button(onClick = onBackToMenu) { Text("⬅️ Volver al Menú") }
    }
}
