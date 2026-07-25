package eu.lucifera.bricalculator.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import eu.lucifera.bricalculator.R
import kotlin.math.sqrt

@Composable
fun CalculatorScreen() {
    var height by remember { mutableStateOf("") }
    var waist by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<Double?>(null) }
    
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_app_logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        
        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text(stringResource(R.string.height_label)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = waist,
            onValueChange = { waist = it },
            label = { Text(stringResource(R.string.waist_label)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        
        Button(
            onClick = {
                val hCm = height.toDoubleOrNull()
                val wCm = waist.toDoubleOrNull()
                if (hCm != null && wCm != null && hCm > 0) {
                    val h = hCm / 100.0
                    val w = wCm / 100.0
                    val eccentricitySquared = 1.0 - ((w / (Math.PI * 2.0)) / (0.5 * h)).let { it * it }
                    result = 364.2 - 365.5 * sqrt(eccentricitySquared.coerceAtLeast(0.0))
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(stringResource(R.string.calculate_btn))
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        result?.let { bri ->
            ResultDisplay(bri)
        }
    }
}

@Composable
fun ResultDisplay(bri: Double) {
    val categoryInfo = getCategoryInfo(bri)
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            // Geen achtergrondkleur meer, neemt de kleur van de app over
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.result_label, bri),
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary, // Gebruikt de thema-hoofdkleur (Donkerblauw)
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Text(
            text = stringResource(R.string.category_label, stringResource(categoryInfo.labelRes)),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold,
            color = categoryInfo.color,
            textAlign = TextAlign.Center
        )
    }
}

data class CategoryInfo(val labelRes: Int, val color: Color)

@Composable
fun getCategoryInfo(bri: Double): CategoryInfo {
    // Kleuren geoptimaliseerd voor weergave zonder witte achtergrond (werkt goed op zowel licht als donker thema)
    return when {
        bri < 3.5 -> CategoryInfo(R.string.cat_lean, Color(0xFF03A9F4)) // Lichtblauw - sportief
        bri < 5.5 -> CategoryInfo(R.string.cat_healthy, Color(0xFF4CAF50)) // Groen - gezond
        bri < 7.0 -> CategoryInfo(R.string.cat_increased, Color(0xFFFF9800)) // Oranje - let op
        else -> CategoryInfo(R.string.cat_high, Color(0xFFE91E63)) // Roze/Rood - actie vereist
    }
}