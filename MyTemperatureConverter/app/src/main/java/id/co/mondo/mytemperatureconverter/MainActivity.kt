package id.co.mondo.mytemperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.co.mondo.mytemperatureconverter.ui.theme.MyTemperatureConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTemperatureConverterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StatefulTemperatureInput()
                }
            }
        }
    }
}

@Composable
fun StatefulTemperatureInput(modifier: Modifier = Modifier) {
    var input by rememberSaveable { mutableStateOf("") }
    var output by rememberSaveable { mutableStateOf("") }
    Column(modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.stateful_converter),
            style = MaterialTheme.typography.headlineSmall
        )
        OutlinedTextField(
            value = input,
            label = {
                Text(stringResource(R.string.enter_celcius))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { newInput->
                input = newInput
                output = convertToFahrenheit(newInput)
            },
        )
        Text(stringResource(R.string.temperature_fahrenheit, output))
    }
}

private fun convertToFahrenheit(celcius: String) =
    celcius.toDoubleOrNull()?.let {
        (it * 9/5) + 32
    }.toString()


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun GreetingPreview() {
    MyTemperatureConverterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            StatefulTemperatureInput()
        }
    }
}