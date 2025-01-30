package id.co.mondo.hellojetpackcompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.co.mondo.hellojetpackcompose.ui.theme.HelloJetpackComposeTheme


private val sampleName = listOf(
    "Andre",
    "Desta",
    "Parto",
    "Wendy",
    "Komeng",
    "Raffi Ahmad",
    "Andhika Pratama",
    "Vincent Ryan Rompies"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloJetpackComposeTheme {
                    HelloJetpackComposeApp()
            }
        }
    }
}



@Composable
fun HelloJetpackComposeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        GreetingList(sampleName)
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Preview(showBackground = true, device = Devices.PIXEL_4, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HelloJetpackComposeAppPreview() {
    HelloJetpackComposeTheme {
        HelloJetpackComposeApp()
    }
}

@Composable
fun GreetingList(names: List<String>){
    if(names.isNotEmpty()){
//        Column{
//            for(name in names){
//                Greeting(name)
//            }
//
//
//        }

        LazyColumn {
            items(names) {
                name -> Greeting(name)
            }
        }
    }else{
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ){
//            Text(
//                "No people to greet :"
//            )
//        }

        Box(contentAlignment = Alignment.Center){
            Text("No people to greet :")
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var isExpended by remember { mutableStateOf(false) }
    val animatedSizeDp by animateDpAsState(
        targetValue = if(isExpended) 120.dp else 80.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Card(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.jetpack_compose),
                contentDescription = "Jetpack Compose",
                modifier = modifier.size(animatedSizeDp)
            )

            Spacer(
                modifier = modifier.width(8.dp)
            )
            Column(
                modifier = modifier.weight(1f)
            ) {
                Text(
                    text = "Hello $name!",
                    modifier = modifier,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "Welcome to Dicoding!",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontStyle = FontStyle.Italic
                    )
                )
            }

            IconButton(onClick = { isExpended = !isExpended }) {
                Icon(
                    imageVector = if(isExpended) Icons.Filled.ExpandLess
                        else Icons.Outlined.ExpandMore,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    contentDescription = if(isExpended) "Show Less"
                        else "Show More"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    HelloJetpackComposeTheme {
        Greeting("Android")
    }
}