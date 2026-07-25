package eu.lucifera.bricalculator.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import eu.lucifera.bricalculator.R

@Composable
fun HelpScreen() {
    val scrollState = rememberScrollState()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.help_intro),
            style = MaterialTheme.typography.bodyLarge
        )
        
        HelpSection(
            title = stringResource(R.string.help_calc_title),
            content = stringResource(R.string.help_calc_text)
        )
        
        HelpSection(
            title = stringResource(R.string.help_example_title),
            content = stringResource(R.string.help_example_text)
        )
        
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = stringResource(R.string.help_cats_title),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.help_cats_text),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        
        HelpSection(
            title = stringResource(R.string.help_why_title),
            content = stringResource(R.string.help_why_text)
        )
        
        HelpSection(
            title = stringResource(R.string.help_limit_title),
            content = stringResource(R.string.help_limit_text)
        )
        
        HelpSection(
            title = stringResource(R.string.help_tips_title),
            content = stringResource(R.string.help_tips_text)
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = stringResource(R.string.help_summary),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )
        
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun HelpSection(title: String, content: String) {
    Column(modifier = Modifier.padding(vertical = 12.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = content,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}