package dev.jeff.practica2025_1.presentation.currency

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.text.DecimalFormat

@Composable
fun CurrencyConverterScreen(onBackToMenu: () -> Unit) {

    // Estado
    var amountInput by remember { mutableStateOf("") }
    var mode by remember { mutableStateOf(ConvMode.USD_TO_PEN) }
    var result by remember { mutableStateOf<String?>(null) }
    var error by remember { mutableStateOf<String?>(null) }

    val rate = 3.80
    val df = remember { DecimalFormat("#,##0.00") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("💵 Conversor de Divisas", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        // Monto
        OutlinedTextField(
            value = amountInput,
            onValueChange = { amountInput = it; error = null; result = null },
            label = { Text("Monto") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(Modifier.height(16.dp))

        // Tipo de conversión
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = mode == ConvMode.USD_TO_PEN, onClick = { mode = ConvMode.USD_TO_PEN })
            Text("USD → PEN")
            Spacer(Modifier.width(16.dp))
            RadioButton(selected = mode == ConvMode.PEN_TO_USD, onClick = { mode = ConvMode.PEN_TO_USD })
            Text("PEN → USD")
        }

        Spacer(Modifier.height(16.dp))

        // Botón convertir
        Button(
            onClick = {
                val amount = amountInput.toDoubleOrNull()
                if (amount == null || amount <= 0) {
                    error = "Ingresa un monto válido (positivo)"
                    result = null
                } else {
                    error = null
                    val res = when (mode) {
                        ConvMode.USD_TO_PEN -> amount * rate
                        ConvMode.PEN_TO_USD -> amount / rate
                    }
                    result = when (mode) {
                        ConvMode.USD_TO_PEN -> "Resultado: S/. ${df.format(res)}"
                        ConvMode.PEN_TO_USD -> "Resultado: $ ${df.format(res)}"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Convertir") }

        // Mensajes
        if (error != null) {
            Spacer(Modifier.height(8.dp))
            Text(error!!, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
        }
        if (result != null) {
            Spacer(Modifier.height(12.dp))
            Text(result!!, style = MaterialTheme.typography.titleMedium)
        }

        Spacer(Modifier.height(32.dp))

        // Volver al menú
        OutlinedButton(onClick = onBackToMenu, modifier = Modifier.fillMaxWidth()) {
            Text("⬅️ Volver al Menú")
        }
    }
}

private enum class ConvMode { USD_TO_PEN, PEN_TO_USD }
