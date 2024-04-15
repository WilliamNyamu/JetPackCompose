package com.ashley.myjetpack

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ashley.myjetpack.R
import com.ashley.myjetpack.ui.theme.MyJetPackTheme

class ScrollActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetPackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val students = listOf("James", "Willy", "Liam", "June", "Robi", "John")
                    DashBoardScreen(students = students)
                    Column {
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(onClick = {
                            val intent = Intent(this@ScrollActivity,TopActivity::class.java)
                            startActivity(intent)
                        }) {
                            Text(text = "NEXT")

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RowCards(name: String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .height(100.dp)
            .aspectRatio(3f),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(text = name)
        }
    }
}

@Composable
fun DashBoardScreen(students: List<String>) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.stanford),
            contentDescription = "background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier.fillMaxSize()) {
            LazyRow(contentPadding = PaddingValues(20.dp)) {
                items(items = students) { student ->
                    RowCards(name = student)
                }
            }
        }
    }
}

@Preview
@Composable
fun RowCardsPreview() {
    // Provide a name for preview
    RowCards(name = "James")
}
