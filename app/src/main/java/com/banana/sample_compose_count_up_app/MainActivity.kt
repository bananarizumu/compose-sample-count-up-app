package com.banana.sample_compose_count_up_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banana.sample_compose_count_up_app.ui.theme.SamplecomposecountupappTheme

class MainActivity : ComponentActivity() {

    private val viewModel: CountViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Counter(viewModel = viewModel)
        }
    }
}

@Composable
fun Counter(viewModel: CountViewModel) {
    val currentCount = viewModel.currentCount.value
    Scaffold(
        // ①トップバー
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Count Up App",
                    )
                },
            )
        },
        // ③右下のアクションボタン
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onClickCounter()
            }) {
                /* FAB content */
                Icon(Icons.Filled.Add, "Add")
            }
        }
    ) {}

    // ②画面中央のカウントを表示するテキスト
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "You have pushed the button this many times:",
            fontSize = 12.sp
        )
        Text(
            text = "${viewModel.currentCount.value}",
            modifier = Modifier.padding(8.dp),
            fontSize = 24.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    val viewModel = CountViewModel()
    Counter(viewModel = viewModel)
}
