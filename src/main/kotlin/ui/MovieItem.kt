package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import util.loadNetworkImage

@Composable
fun MovieItem(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Image(
            bitmap = loadNetworkImage(imageUrl),
            contentDescription = null
        )
    }
}