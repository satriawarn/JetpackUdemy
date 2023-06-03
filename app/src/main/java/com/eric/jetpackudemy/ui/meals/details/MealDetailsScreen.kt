package com.eric.jetpackudemy.ui.meals.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.eric.jetpackudemy.model.response.MealsResponse

@Composable
fun MealDetailScreen(meal: MealsResponse?) {
    Column {
        Row {
            Card {
                Image(
                    painter = rememberAsyncImagePainter(model = meal?.imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(shape = CircleShape)
                )
            }
            Text(text = meal?.name ?: "default name", style = MaterialTheme.typography.bodyLarge)
        }
        Button(onClick = { /*TODO*/ }) {
            Text(
                text = "Change state of meal profile picture",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}