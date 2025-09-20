package id.co.mondo.cardname

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.co.mondo.cardname.ui.theme.CardNameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardNameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Profile("Mondo", "Android Developer")
                }
            }
        }
    }
}

@Composable
fun Profile(
    name: String,
    title: String,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(R.drawable.me),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
                .clip(CircleShape)
        )
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            fontStyle = FontStyle.Italic
        )

    }

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        Contact(R.drawable.baseline_call_24, "+6285757438630")
        Contact(R.drawable.baseline_share_24, "@mondeve")
        Contact(R.drawable.baseline_email_24, "raqhib.ataillah@mail.com")
    }
}

@Composable
fun Contact(icon: Int, text: String, modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ){
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = modifier
                .size(24.dp)
        )
        Spacer(modifier.width(8.dp))
        Text(
            text = text,
        )
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CardNameTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Profile("Mondo", "Android Developer")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CardNameTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Contact(R.drawable.baseline_email_24, "kacaucucajcnsjcnacjns")
                Contact(R.drawable.baseline_email_24, "Mondo")
                Contact(R.drawable.baseline_email_24, "Mondo")
            }
        }
    }
}