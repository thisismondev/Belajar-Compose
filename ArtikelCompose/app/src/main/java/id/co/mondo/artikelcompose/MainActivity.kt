package id.co.mondo.artikelcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.co.mondo.artikelcompose.ui.theme.ArtikelComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtikelComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) { 
                    Artikle()
                }
            }
        }
    }
}

@Composable
fun Artikle(
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.bg_compose_background)

    Column{
        Image(
            painter = image,
            contentDescription = null,
        )
        Description(
            modifier = Modifier
                .padding(16.dp)
        )
    }

}

@Composable
fun Description(
    modifier: Modifier = Modifier,
){
    Column {
        Text(
            text = stringResource(R.string.title_Artikel),
            fontSize = 24.sp,
            modifier = modifier
        )
        Text(
            text = stringResource(R.string.p1_Artikel),

            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(R.string.p2_Artikel),
            textAlign = TextAlign.Justify,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtikelComposeTheme {
        Artikle()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ArtikelComposeTheme {
        Description()
    }
}