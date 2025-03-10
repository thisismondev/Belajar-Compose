package id.co.mondo.kuadrancompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.co.mondo.kuadrancompose.ui.theme.KuadranComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KuadranComposeTheme {

            }
        }
    }
}

@Composable
fun viewQuadran(){
    Column(
        Modifier.fillMaxSize()
    ) {
        Row(
            Modifier.weight(1f)
        ) {
            Card(
                title = stringResource(R.string.title_text),
                description = stringResource(R.string.Desc_text),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            Card(
                title = stringResource(R.string.title_image),
                description = stringResource(R.string.Desc_image),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Card(
                title = stringResource(R.string.title_row),
                description = stringResource(R.string.Desc_row),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            Card(
                title = stringResource(R.string.title_column),
                description = stringResource(R.string.Desc_colomn),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Card(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KuadranComposeTheme {
            viewQuadran()
    }
}