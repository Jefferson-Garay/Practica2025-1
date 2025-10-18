package dev.jeff.practica2025_1.presentation.dogage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun DogAgeScreen(onBackToMenu: () -> Unit) {
    var ageInput by remember { mutableStateOf("") }
    var size by remember { mutableStateOf("Pequeño") }
    var result by remember { mutableStateOf<String?>(null) }
    val sizes = listOf("Pequeño", "Mediano", "Grande")
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🐶 Calculadora de Edad Canina", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = ageInput,
            onValueChange = { ageInput = it },
            label = { Text("Edad humana del perro (años)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Box {
            OutlinedButton(onClick = { expanded = true }) { Text("Tamaño: $size") }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                sizes.forEach { s ->
                    DropdownMenuItem(
                        text = { Text(s) },
                        onClick = { size = s; expanded = false }
                    )
                }
            }
        }

        Spacer(Modifier.height(24.dp))

        Button(onClick = {
            val age = ageInput.toDoubleOrNull()
            result = if (age == null || age <= 0) {
                "⚠️ Ingresa una edad válida"
            } else {
                val dogAge = when (size) {
                    "Pequeño" -> age * 5
                    "Mediano" -> age * 6
                    else -> age * 7
                }
                "Tu perro tiene ${dogAge.toInt()} años perro 🐾"
            }
        }) { Text("Calcular") }

        Spacer(Modifier.height(24.dp))
        result?.let { Text(it, style = MaterialTheme.typography.bodyLarge) }

        Spacer(Modifier.height(32.dp))
        Button(onClick = onBackToMenu) { Text("⬅️ Volver al Menú") }
    }
}
