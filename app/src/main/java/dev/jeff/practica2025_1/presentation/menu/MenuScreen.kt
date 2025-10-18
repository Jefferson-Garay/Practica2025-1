package dev.jeff.practica2025_1.presentation.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MenuScreen(
    onGoToDogAge: () -> Unit,
    onGoToCurrency: () -> Unit,
    onGoToCatalog: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Menú Principal 🏠", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(24.dp))

        Button(onClick = onGoToDogAge, modifier = Modifier.fillMaxWidth()) {
            Text("🐶 Calculadora de Edad Canina")
        }
        Spacer(Modifier.height(12.dp))
        Button(onClick = onGoToCurrency, modifier = Modifier.fillMaxWidth()) {
            Text("💵 Conversor de Divisas")
        }
        Spacer(Modifier.height(12.dp))
        Button(onClick = onGoToCatalog, modifier = Modifier.fillMaxWidth()) {
            Text("💻 Catálogo de Productos")
        }
    }
}
