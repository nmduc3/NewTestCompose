package com.loud.mytestapplication

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            MainActivityScreen()
        }
    }

    @Composable
    fun MainActivityScreen() {
        val image = painterResource(id = R.drawable.androidparty)
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Box {
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alpha = 0.5f,
                )
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.hello_android),
                        fontSize = 24.sp,
                        lineHeight = 28.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .background(color = Color.White)
                            .padding(16.dp)
                    )
                    Text(
                        text = stringResource(R.string.from_mainactivity),
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(alignment = Alignment.End)
                    )
                    Button(onClick = {

                    }) {
                        Text(stringResource(R.string.firstfragment))
                    }
                    Button(onClick = {}) {
                        Text(stringResource(R.string.Secondfragment))
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainActivityScreenPreview() {
        MainActivityScreen()
    }
}